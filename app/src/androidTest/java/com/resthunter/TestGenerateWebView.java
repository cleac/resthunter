package com.resthunter;

import android.test.AndroidTestCase;

/**
 * Created by cleac on 04.04.15.
 */
public class TestGenerateWebView extends AndroidTestCase {
    public static final String LOG_TAG = TestGenerateWebView.class.getSimpleName();

    public void testBuildWebView() throws Throwable {
         new RestaurantMapView().show();
    }
}
