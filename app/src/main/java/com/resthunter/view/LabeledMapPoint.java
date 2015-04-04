package com.resthunter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.resthunter.R;

/**
 * Created by okovalchuk on 4/4/15.
 */
public class LabeledMapPoint extends RelativeLayout {
  private TextView mLabel;

  public LabeledMapPoint(Context context) {
    super(context);
  }

  public LabeledMapPoint(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public LabeledMapPoint(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  private void initView(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v = inflater.inflate(R.layout.view_map_point, this);
    mLabel = (TextView) v.findViewById(R.id.tv_pin_label);
  }

  public void setText(CharSequence text) {
    mLabel.setText(text);
  }

}
