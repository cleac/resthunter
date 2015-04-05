package com.resthunter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.resthunter.rest.model.Restaurant;
import com.resthunter.util.WebAppInterface;


public class InteriorActivity extends ActionBarActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_interior);
    Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("EXTRA_RESTAURANT");

    WebView webView = (WebView) findViewById(R.id.webview);
    WebSettings webSettings = webView.getSettings();
    final String mimeType = "text/html";
    final String encoding = "UTF-8";

    webSettings.setJavaScriptEnabled(true);
    webView.addJavascriptInterface(new WebAppInterface(this), "Android");
    webView.loadDataWithBaseURL("", RestaurantMapGenerator.buildDocument(restaurant), mimeType, encoding, "");
  }
}
