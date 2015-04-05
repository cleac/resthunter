package com.resthunter.SlidingUpWidget;

/**
 * Created by denys on 4/4/15.
 */

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

import com.resthunter.R;

public abstract class BaseActivity extends ActionBarActivity {
  private static final int NUM_OF_ITEMS = 100;

  protected int getActionBarSize() {
    TypedValue typedValue = new TypedValue();
    int[] textSizeAttr = new int[]{R.attr.actionBarSize};
    int indexOfAttrTextSize = 0;
    TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
    int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
    a.recycle();
    return actionBarSize;
  }

  protected int getScreenHeight() {
    return findViewById(android.R.id.content).getHeight();
  }

}
