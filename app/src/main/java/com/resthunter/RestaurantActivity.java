package com.resthunter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.melnykov.fab.FloatingActionButton;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.resthunter.SlidingUpWidget.BaseActivity;
import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.Restaurant;
import com.resthunter.rest.model.User;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.resthunter.rest.model.Restaurant;

/**
 * Created by denys on 4/4/15.
 */
public class RestaurantActivity extends BaseActivity implements ObservableScrollViewCallbacks {

    private static final float MAX_TEXT_SCALE_DELTA = 0.3f;
    private static final boolean TOOLBAR_IS_STICKY = true;

    private View mToolbar;
    private View mImageView;
    private View mOverlayView;
    private ObservableScrollView mScrollView;
    private TextView mTitleView;
    private View mFab;
    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private int mToolbarColor;
    private boolean mFabIsShown;

    private ImageView mCallImageView;
    private ImageView mWifiImageView;
    private ImageView mCardImageView;
    private ImageView mTimeImageView;

    private ImageView mAvatar1;
    private ImageView mAvatar2;
    private ImageView mAvatar3;
    private ImageView mAvatar4;

    private ArrayList<User> users;
    private Restaurant restaurant;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager manager;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        Intent intent = getIntent();
        restaurant = (Restaurant) intent.getSerializableExtra("EXTRA_RESTAURANT");

        findAllViewsByIds();

        RestClient client = new RestClient();
        Callback<ArrayList<User>> callback = new Callback<ArrayList<User>>() {
            @Override
            public void success(ArrayList<User> data,Response response) {
                //handle data
                fillAvatars(data);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //handle error
            }
        };
        client.getApiService().getUserList(callback);
        fillUiElements();
    }

    private void fillUiElements() {
        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_image);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = getActionBarSize();
        mToolbarColor = getResources().getColor(R.color.material_orange_500);

        mToolbar = findViewById(R.id.toolbar);
        if (!TOOLBAR_IS_STICKY) {
            mToolbar.setBackgroundColor(Color.TRANSPARENT);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = findViewById(R.id.image);
        mOverlayView = findViewById(R.id.overlay);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mTitleView = (TextView) findViewById(R.id.title);
        mTitleView.setText(restaurant.getName());
        Picasso.with(RestaurantActivity.this).load(restaurant.getImage()).into((ImageView)mImageView);
        setTitle(null);
        mFab = findViewById(R.id.fab);
        setColorFab();
        mFabMargin = getResources().getDimensionPixelSize(R.dimen.margin_standard);
        ViewHelper.setScaleX(mFab, 1);
        ViewHelper.setScaleY(mFab, 1);

        ScrollUtils.addOnGlobalLayoutListener(mScrollView, new Runnable() {
            @Override
            public void run() {
                mScrollView.scrollTo(0, 1);
            }
        });
    }

    private void fillAvatars(ArrayList<User> users) {

        Picasso.with(getApplicationContext()).load(users.get(0).getAvatar()).into((ImageView) mAvatar1);
        Picasso.with(getApplicationContext()).load(users.get(1).getAvatar()).into((ImageView) mAvatar2);
        Picasso.with(getApplicationContext()).load(users.get(2).getAvatar()).into((ImageView) mAvatar3);
        Picasso.with(getApplicationContext()).load(users.get(3).getAvatar()).into((ImageView) mAvatar4);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("EXTRA_RESTAURANT", restaurant);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restaurant = (Restaurant) savedInstanceState.getSerializable("EXTRA_RESTAURANT");
    }

    private void findAllViewsByIds() {
        mCallImageView = (ImageView) findViewById(R.id.callImageView);
        mWifiImageView = (ImageView) findViewById(R.id.wifiImageView);
        setWifiColor();
        mCardImageView = (ImageView) findViewById(R.id.cardImageView);
        mTimeImageView = (ImageView) findViewById(R.id.timeImageView);
        setTimeColor();

        mAvatar1 = (ImageView) findViewById(R.id.avatar_1);
        mAvatar2 = (ImageView) findViewById(R.id.avatar_2);
        mAvatar3 = (ImageView) findViewById(R.id.avatar_3);
        mAvatar4 = (ImageView) findViewById(R.id.avatar_4);

        mRecyclerView = (RecyclerView) findViewById(R.id.review_list);
        manager = new LinearLayoutManager(this);
        mAdapter = new RecyclerViewAdapter(getApplicationContext(), getReviews());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onResume() {
        super.onResume();
        fillUiElements();
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        // Translate overlay and image
        float flexibleRange = mFlexibleSpaceImageHeight - mActionBarSize;
        int minOverlayTransitionY = mActionBarSize - mOverlayView.getHeight();
        ViewHelper.setTranslationY(mOverlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));
        ViewHelper.setTranslationY(mImageView, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));

        // Change alpha of overlay
        ViewHelper.setAlpha(mOverlayView, ScrollUtils.getFloat((float) scrollY / flexibleRange, 0, 1));

        // Scale title text
        float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
        ViewHelper.setPivotX(mTitleView, 0);
        ViewHelper.setPivotY(mTitleView, 0);
        ViewHelper.setScaleX(mTitleView, scale);
        ViewHelper.setScaleY(mTitleView, scale);

        // Translate title text
        int maxTitleTranslationY = (int) (mFlexibleSpaceImageHeight - mTitleView.getHeight() * scale);
        int maxTitleTranslationX = 20;
        int titleTranslationY = maxTitleTranslationY - scrollY;
        int titleTranslationX;
        if(scrollY <=277) {
            titleTranslationX = maxTitleTranslationX + (int) ((float) scrollY / 7);
        } else
            titleTranslationX = 59;
        if (TOOLBAR_IS_STICKY) {
            titleTranslationY = Math.max(0, titleTranslationY);
            titleTranslationX = Math.max(0, titleTranslationX);
        }
        ViewHelper.setTranslationY(mTitleView, titleTranslationY);
        ViewHelper.setTranslationX(mTitleView, titleTranslationX);

        // Translate FAB
        int maxFabTranslationY = mFlexibleSpaceImageHeight - mFab.getHeight() / 2;
        float fabTranslationY = ScrollUtils.getFloat(
                -scrollY + mFlexibleSpaceImageHeight - mFab.getHeight() / 2,
                mActionBarSize - mFab.getHeight() / 2,
                maxFabTranslationY);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // On pre-honeycomb, ViewHelper.setTranslationX/Y does not set margin,
            // which causes FAB's OnClickListener not working.
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFab.getLayoutParams();
            lp.leftMargin = mOverlayView.getWidth() - mFabMargin - mFab.getWidth();
            lp.topMargin = (int) fabTranslationY;
            mFab.requestLayout();
        } else {
            ViewHelper.setTranslationX(mFab, mOverlayView.getWidth() - mFabMargin - mFab.getWidth());
            ViewHelper.setTranslationY(mFab, fabTranslationY);
        }

        setFabAlpha((int) ViewHelper.getTranslationY(mFab));

        if (TOOLBAR_IS_STICKY) {
            // Change alpha of toolbar background
            if (-scrollY + mFlexibleSpaceImageHeight <= mActionBarSize) {
                mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, mToolbarColor));
            } else {
                mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, mToolbarColor));
            }
        } else {
            // Translate Toolbar
            if (scrollY < mFlexibleSpaceImageHeight) {
                ViewHelper.setTranslationY(mToolbar, 0);
            } else {
                ViewHelper.setTranslationY(mToolbar, -scrollY);
            }
        }
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }


    private void setFabAlpha(int scroll) {
        float opacityRange = (float)1/(314 - 38)*(scroll-38);
        mFab.setAlpha(opacityRange);
        if(opacityRange < 0.05) {
            mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {}
            });
        } else {
            mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("Name", restaurant.getName());
                    startActivity(intent);
                }
            });
        }
    }

    private void setColorFab() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_local_restaurant_grey600_24dp);

        int iColor = Color.parseColor(getResources().getString(R.color.material_orange_500));

        int red = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red
                , 0, 0, 0, 0, green
                , 0, 0, 0, 0, blue
                , 0, 0, 0, 1, 0 };
        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);

        ((FloatingActionButton) mFab).setImageDrawable(drawable);
    }

    private void setWifiColor() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_signal_wifi_4_bar_grey600_24dp);

        int iColor = Color.parseColor(getResources().getString(R.color.material_light_green_500));

        int red = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red
                , 0, 0, 0, 0, green
                , 0, 0, 0, 0, blue
                , 0, 0, 0, 1, 0 };
        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);

        ((ImageView)mWifiImageView).setImageDrawable(drawable);
    }

    private void setCardColor() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_credit_card_grey600_24dp);

        int iColor = Color.parseColor(getResources().getString(R.color.material_light_green_500));

        int red = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red
                , 0, 0, 0, 0, green
                , 0, 0, 0, 0, blue
                , 0, 0, 0, 1, 0 };
        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);

        ((ImageView)mCardImageView).setImageDrawable(drawable);
    }

    private void setTimeColor() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_timer_grey600_24dp);

        int iColor = Color.parseColor(getResources().getString(R.color.material_light_green_500));

        int red = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red
                , 0, 0, 0, 0, green
                , 0, 0, 0, 0, blue
                , 0, 0, 0, 1, 0 };
        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);

        ((ImageView)mTimeImageView).setImageDrawable(drawable);
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<String> mItems;

        public RecyclerViewAdapter(Context context, ArrayList<String> items) {
            mContext = context;
            mInflater = LayoutInflater.from(context);
            mItems = items;
        }

        @Override
        public int getItemCount() {
            return mItems == null ? 0 : mItems.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mContext, mInflater.inflate(R.layout.review_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.mHumanReview.setText(mItems.get(position));
            viewHolder.fab.setBackgroundColor(mContext.getResources().getColor(R.color.material_orange_500));
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView mHumanReview;
            FloatingActionButton fab;
            Context context;

            public ViewHolder(Context context, View view) {
                super(view);
                this.context = context;
                this.mHumanReview = (TextView) view.findViewById(R.id.textReview);
                this.fab = (FloatingActionButton) view.findViewById(R.id.view);
            }
        }
    }

    private ArrayList<String> getReviews() {
        ArrayList<String> reviews = new ArrayList<>();
        reviews.add("Nice restaurant");
        reviews.add("Reccomend it for everybody");
        reviews.add("I loved yhat kitchen");
        reviews.add("Not bad");
        return reviews;
    }

    private void openRestaurantLocationOnMap(Restaurant restaurant) {

    }
}