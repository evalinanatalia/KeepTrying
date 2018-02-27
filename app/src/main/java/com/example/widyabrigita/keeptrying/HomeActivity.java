package com.example.widyabrigita.keeptrying;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

  private ViewPager viewPager;
  private MyViewPagerAdapter myViewPagerAdapter;
  private int[] layouts;
  private TextView[] dots;
  private Button btnSkip, btnNext;
  private LinearLayout dotsLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    viewPager = (ViewPager) findViewById(R.id.view_pager);
    dotsLayout = (LinearLayout)findViewById(R.id.layoutDots);
    layouts = new int[]{
        R.layout.banner_slide1,
        R.layout.banner_slide2,
        R.layout.banner_slide3,
        R.layout.banner_slide4};

    // adding bottom dots
    addBottomDots(0);

    changeStatusBarColor();

    myViewPagerAdapter = new MyViewPagerAdapter();
    viewPager.setAdapter(myViewPagerAdapter);

//    GridView gridView = (GridView)findViewById(R.id.gridview);
//    LogoAdapter logoAdapter = new LogoAdapter(this, logos);
//    gridView.setAdapter(logoAdapter);
  }

  private void addBottomDots(int currentPage) {
    dots = new TextView[layouts.length];

    int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
    int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

    dotsLayout.removeAllViews();
    for (int i = 0; i < dots.length; i++) {
      dots[i] = new TextView(this);
      dots[i].setText(Html.fromHtml("&#8226;"));
      dots[i].setTextSize(35);
      dots[i].setTextColor(colorsInactive[currentPage]);
      dotsLayout.addView(dots[i]);
    }

    if (dots.length > 0)
      dots[currentPage].setTextColor(colorsActive[currentPage]);
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

//  public Logo[] logos = {
//      new Logo(R.drawable.icon_help_black, R.string.refueling),
//      new Logo(R.drawable.icon_help_red, R.string.trip_planner),
//      new Logo(R.drawable.icon_account_black, R.string.motorist_diary),
//      new Logo(R.drawable.icon_account_red, R.string.refueling),
//      new Logo(R.drawable.icon_history_black, R.string.trip_planner),
//      new Logo(R.drawable.icon_history_red, R.string.motorist_diary)
//  };
}
