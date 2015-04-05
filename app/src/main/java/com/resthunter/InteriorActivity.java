package com.resthunter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.Restaurant;
import com.resthunter.rest.service.RestHunterApiService;
import com.resthunter.util.WebAppInterface;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class InteriorActivity extends ActionBarActivity {

  public static final String ENCODING = "UTF-8";
  public static final String MIME_TYPE = "text/html";
  public static final String SIMPLE_NAME = InteriorActivity.class.getSimpleName();
  private WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_interior);
    this.webView = (WebView) findViewById(R.id.webview);

    WebSettings webSettings = this.webView.getSettings();

    webSettings.setJavaScriptEnabled(true);
    this.webView.addJavascriptInterface(new WebAppInterface(this), "Android");

//    Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("EXTRA_RESTAURANT");
    Callback<ArrayList<Restaurant>> callback = new Callback<ArrayList<Restaurant>>() {
      @Override
      public void success(ArrayList<Restaurant> data, Response response) {
        new LoadDocumentTask().execute(data.get(0));
      }

      @Override
      public void failure(RetrofitError error) {
      }
    };
    RestHunterApiService apiService = new RestClient().getApiService();
    apiService.getRestaurantList(callback);
  }

  public void loadDataWithBaseURL(String document) {
//    Log.v(SIMPLE_NAME, new RestaurantMapGenerator(restaurant).buildDocument());
     webView.loadDataWithBaseURL("", document, MIME_TYPE, ENCODING, "");
  }

  private class LoadDocumentTask extends AsyncTask<Restaurant,Void,String> {
    @Override
    protected String doInBackground(Restaurant... restaurants) {
        return RestaurantMapGenerator.buildDocument(restaurants[0]);
    }

    @Override
    protected void onPostExecute(String aVoid) {
      super.onPostExecute(aVoid);
      Log.v(SIMPLE_NAME,aVoid);
      loadDataWithBaseURL(aVoid);
    }
  }
}
