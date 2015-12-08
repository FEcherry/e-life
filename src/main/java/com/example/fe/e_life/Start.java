package com.example.fe.e_life;

;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fe on 15-8-8.
 */
public class Start extends Activity implements View.OnClickListener {

    private ViewPager mviewPager;
    private List<View> mView=new ArrayList<View>();
    private PagerAdapter madapter;

    private LinearLayout myTabHome;
    private LinearLayout myTabStudy;
    private LinearLayout myTabFun;
    private LinearLayout myTabNews;

    private ImageButton mHomeIcon;
    private ImageButton mStudyIcon;
    private ImageButton mFunIcon;
    private ImageButton mNewsIcon;

    private TextView mhometext;
    private TextView mstudytext;
    private TextView mfuntext;
    private TextView mnewstext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        initView();
        initEvents();

        mviewPager.setCurrentItem(0);
        mHomeIcon.setImageResource(R.drawable.homegreen);
        mhometext.setTextColor(Color.rgb(77, 208, 200));

        ImageButton imageButton=(ImageButton) findViewById(R.id.set);
        imageButton.setOnClickListener(new ImageButton.OnClickListener(){

            @Override
            public void onClick(View v) {
                openOptionsMenu();
            }
        });
    }






    private void initEvents() {
        myTabHome.setOnClickListener(this);
        myTabStudy.setOnClickListener(this);
        myTabFun.setOnClickListener(this);
        myTabNews.setOnClickListener(this);

        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem=mviewPager.getCurrentItem();
                resetimg();
                switch (currentItem) {
                    case 0:
                        mHomeIcon.setImageResource(R.drawable.homegreen);
                        mhometext.setTextColor(Color.rgb(77, 208, 200));
                        break;
                    case 1:
                        mStudyIcon.setImageResource(R.drawable.studygreen);
                        mstudytext.setTextColor(Color.rgb(77, 208, 200));
                        break;
                    case 2:
                        mFunIcon.setImageResource(R.drawable.fungreen);
                        mfuntext.setTextColor(Color.rgb(77, 208, 200));
                        break;
                    case 3:
                        mNewsIcon.setImageResource(R.drawable.newsgreen);
                        mnewstext.setTextColor(Color.rgb(77, 208, 200));
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    private void initView() {
        mviewPager=(ViewPager)findViewById(R.id.viewpager);

        myTabHome=(LinearLayout) findViewById(R.id.hometag);
        myTabStudy=(LinearLayout) findViewById(R.id.studytag);
        myTabFun=(LinearLayout) findViewById(R.id.funtag);
        myTabNews=(LinearLayout) findViewById(R.id.newstag);

        mHomeIcon=(ImageButton) findViewById(R.id.homeicon);
        mStudyIcon=(ImageButton) findViewById(R.id.studyicon);
        mFunIcon=(ImageButton) findViewById(R.id.funicon);
        mNewsIcon=(ImageButton) findViewById(R.id.newsicon);

        mhometext=(TextView) findViewById(R.id.hometext);
        mstudytext=(TextView) findViewById(R.id.studytext);
        mfuntext=(TextView) findViewById(R.id.funtext);
        mnewstext=(TextView) findViewById(R.id.newstext);

        LayoutInflater mInflater=LayoutInflater.from(this);
        View home=mInflater.inflate(R.layout.home, null);
        View study=mInflater.inflate(R.layout.study,null);
        View fun=mInflater.inflate(R.layout.fun,null);
        View news=mInflater.inflate(R.layout.news,null);

        mView.add(home);
        mView.add(study);
        mView.add(fun);
        mView.add(news);

        madapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return mView.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(mView.get(position));
                return mView.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                ((ViewPager) container).removeView(mView.get(position));
            }
        };
        mviewPager.setAdapter(madapter);

    }


    public void onClick(View v){
        resetimg();
        switch (v.getId()){
            case R.id.hometag:
                mviewPager.setCurrentItem(0);
                mHomeIcon.setImageResource(R.drawable.homegreen);
                mhometext.setTextColor(Color.rgb(77,208,200));
                break;
            case R.id.studytag:
                mviewPager.setCurrentItem(1);
                mStudyIcon.setImageResource(R.drawable.studygreen);
                mstudytext.setTextColor(Color.rgb(77, 208, 200));
                break;
            case R.id.funtag:
                mviewPager.setCurrentItem(2);
                mFunIcon.setImageResource(R.drawable.fungreen);
                mfuntext.setTextColor(Color.rgb(77, 208, 200));
                break;
            case R.id.newstag:
                mviewPager.setCurrentItem(3);
                mNewsIcon.setImageResource(R.drawable.newsgreen);
                mnewstext.setTextColor(Color.rgb(77, 208, 200));
                break;
        }
    }

    private void resetimg() {
        mHomeIcon.setImageResource(R.drawable.home);
        mStudyIcon.setImageResource(R.drawable.study);
        mFunIcon.setImageResource(R.drawable.fun);
        mNewsIcon.setImageResource(R.drawable.news);

        mhometext.setTextColor(Color.rgb(184, 195, 194));
        mstudytext.setTextColor(Color.rgb(184, 195, 194));
        mfuntext.setTextColor(Color.rgb(184, 195, 194));
        mnewstext.setTextColor(Color.rgb(184, 195, 194));




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                break;
            case R.id.exit:
                finish();
        }
    return super.onOptionsItemSelected(item);
    }
}