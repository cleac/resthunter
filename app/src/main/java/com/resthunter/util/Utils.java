package com.resthunter.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by okovalchuk on 4/4/15.
 */
public class Utils {
  public static Bitmap loadBitmapFromView(View v) {
    if (v.getMeasuredHeight() > 0) {
      Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
      Canvas c = new Canvas(b);
      v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
      v.draw(c);
      return b;
    } else {
      int specWidth = View.MeasureSpec.makeMeasureSpec(0 /* any */, View.MeasureSpec.UNSPECIFIED);
      v.measure(specWidth, specWidth);
      Bitmap b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      Canvas c = new Canvas(b);
      v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
      v.draw(c);
      return b;
    }
  }
}
