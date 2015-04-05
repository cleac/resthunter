package com.resthunter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.resthunter.util.WebAppInterface;


public class InteriorActivity extends ActionBarActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_interior);

    WebView webView = (WebView) findViewById(R.id.webview);
    WebSettings webSettings = webView.getSettings();
    final String mimeType = "text/html";
    final String encoding = "UTF-8";

    webSettings.setJavaScriptEnabled(true);
    webView.addJavascriptInterface(new WebAppInterface(this), "Android");
    webView.loadDataWithBaseURL("", html, mimeType, encoding, "");
  }

  private static String html = "<!DOCTYPE html>\n" +
                                 "<html>\n" +
                                 "<head>\n" +
                                 "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js\"></script>\n" +
                                 "</head> \n" +
                                 "<body>\n" +
                                 "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                                 " \n" +
                                 "<svg width=\"625\" height=\"422\" version=\"1.1\"\n" +
                                 "     >\n" +
                                 "<defs>\n" +
                                 "    <pattern id=\"image\" patternUnits=\"userSpaceOnUse\" height=\"50\" width=\"50\">\n" +
                                 "      <image x=\"0\" y=\"0\" height=\"50\" width=\"50\" xlink:href=\"http://i.imgur.com/7Nlcay7.jpg\"></image>\n" +
                                 "    </pattern>\n" +
                                 "  </defs>\n" +
                                 "<image xlink:href=\"http://s28.postimg.org/j3s5mf6od/Screen_Shot_2015_04_04_at_5_02_38_PM.png\" x=\"0\" y=\"0\" height=\"100%\" width=\"100%\"/>\n" +
                                 "<circle class='avatar' cx=\"63\" cy=\"150\" r=\"10\" data-table=\"2\" fill=\"url(#image)\"/>\n" +
                                 "<circle class='avatar' cx=\"180\" cy=\"120\" r=\"20\" data-table=\"5\" fill=\"url(#image)\" />\n" +
                                 "<circle class='avatar' cx=\"180\" cy=\"120\" r=\"20\" data-table=\"7\" fill=\"url(#image)\"/>\n" +
                                 " \n" +
                                 "</svg>\n" +
                                 " \n" +
                                 "<script>\n" +
                                 " \n" +
                                 "$('.avatar').click( function(){\n" +
                                 "  var table_id = this.getAttribute('data-table')\n" +
                                 "  Android.bookTable(table_id)\n" +
                                 "});\n" +
                                 "</script>\n" +
                                 " \n" +
                                 "</body>";
}
