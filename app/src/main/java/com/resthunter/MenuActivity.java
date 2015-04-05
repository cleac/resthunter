package com.resthunter;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.resthunter.fragment.FragmentDeserts;
import com.resthunter.fragment.FragmentDrinks;
import com.resthunter.fragment.FragmentFirst;
import com.resthunter.fragment.FragmentGarnish;
import com.resthunter.fragment.FragmentPizza;
import com.resthunter.fragment.FragmentSalads;
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
        setUI();

    }

    private void setUI() {
        setContentView(R.layout.activity_menu);
        setToolbar();
        setViewPager();
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
                "First",
                "Salads",
                "Garnish",
                "Pizza",
                "Deserts",
                "Drinks"
        };

        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(getFragmentManager());
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(6);

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
            Fragment frag = null;
            switch (position) {
                case 0:
                    frag = new FragmentFirst();
                    break;

                case 1:
                    frag = new FragmentSalads();
                    break;

                case 2:
                    frag = new FragmentGarnish();
                    break;

                case 3:
                    frag = new FragmentPizza();
                    break;

                case 4:
                    frag = new FragmentDeserts();
                    break;

                case 5:
                    frag = new FragmentDrinks();
                    break;
            }

            return frag;
        }
        @Override
        public int getCount() {
            return 6;
                    //categories.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerItems[position];
        }
    }

}
