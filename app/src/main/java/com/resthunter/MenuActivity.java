package com.resthunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.resthunter.ui.SlidingTabLayout;

import java.util.ArrayList;

/**
 * Created by denys on 4/4/15.
 */
public class MenuActivity extends ActionBarActivity{

    private Toolbar mToolbar;
    private ViewPager mPager;
    private String[] mPagerItems = null;
    private ActionBar bar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

    }

    private void setUI() {
        setContentView(R.layout.activity_menu);
        setToolbar();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToolbar = toolbar;

        bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setViewPager() {
        mPagerItems = new String[] {
             //   getResources().getString(),
            //    getResources().getString(),
            //    getResources().getString(),
           //     getResources().getString()
        };

        //MainPagerAdapter mPagerAdapter = new MainPagerAdapter(getFragmentManager());
        mPager = (ViewPager) findViewById(R.id.view_pager);
        //mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(4);

        final SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text2);
        slidingTabLayout.setDistributeEvenly(false);
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.material_blue_500));
        slidingTabLayout.setViewPager(mPager);

        if (slidingTabLayout != null) {
            slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        }
    }


    class MainPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Integer> categories;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public MainPagerAdapter(FragmentManager fm, ArrayList<Integer> categories) {
            super(fm);
            this.categories = categories;
        }
        @Override
        public Fragment getItem(int position) {


            return null;
        }
        @Override
        public int getCount() {
            return categories.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerItems[position];
        }
    }

}
