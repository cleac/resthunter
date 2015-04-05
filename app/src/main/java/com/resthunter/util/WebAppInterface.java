package com.resthunter.util;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.resthunter.InteriorActivity;

public class WebAppInterface {
  Context mContext;

  /** Instantiate the interface and set the context */
  public WebAppInterface(Context c) {
    mContext = c;
  }

  /** Show a toast from the web page */
  @JavascriptInterface
  public void showToast(String toast) {
    Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
  }

  @JavascriptInterface
  public void bookTable(String id) {
    Toast.makeText(mContext,  "Table " + id + " booked", Toast.LENGTH_SHORT).show();
//    ((InteriorActivity)mContext).finish();
  }
}