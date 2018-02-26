package com.example.widyabrigita.keeptrying;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class HomeActivity extends AppCompatActivity {

  private ViewPager viewPager;
  private MyViewPagerAdapter myViewPagerAdapter;
  private int[] layouts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    viewPager = (ViewPager) findViewById(R.id.view_pager);
    layouts = new int[]{
        R.layout.banner_slide1,
        R.layout.banner_slide2,
        R.layout.banner_slide3,
        R.layout.banner_slide4};

    changeStatusBarColor();

    myViewPagerAdapter = new MyViewPagerAdapter();
    viewPager.setAdapter(myViewPagerAdapter);
  }

  /**
   * Making notification bar transparent
   */
  private void changeStatusBarColor() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = getWindow();
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.TRANSPARENT);
    }
  }

  /**
   * View pager adapter
   */
  public class MyViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter() {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      View view = layoutInflater.inflate(layouts[position], container, false);
      container.addView(view);

      return view;
    }

    @Override
    public int getCount() {
      return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
      return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      View view = (View) object;
      container.removeView(view);
    }
  }
}
