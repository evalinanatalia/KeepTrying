package com.example.widyabrigita.keeptrying;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLayoutActivity extends TabActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab_layout);

    TabHost tabHost = getTabHost();

    // Tab for Home
    TabSpec homeTab = tabHost.newTabSpec("Home");
    // setting Title and Icon for the Tab
    homeTab.setIndicator(null, getResources().getDrawable(R.drawable.ic_home_selected));
    Intent homeIntent = new Intent(this, HomeActivity.class);
    homeTab.setContent(homeIntent);

    // Tab for History
    TabSpec historyTab = tabHost.newTabSpec("History");
    historyTab.setIndicator(null, getResources().getDrawable(R.drawable.ic_history_selected));
    Intent historyIntent = new Intent(this, HistoryActivity.class);
    historyTab.setContent(historyIntent);

    // Tab for Help
    TabSpec helpTab = tabHost.newTabSpec("Help");
    helpTab.setIndicator(null, getResources().getDrawable(R.drawable.ic_help_selected));
    Intent helpIntent = new Intent(this, HelpActivity.class);
    helpTab.setContent(helpIntent);

    // Tab for Account
    TabSpec accountTab = tabHost.newTabSpec("Account");
    accountTab.setIndicator(null, getResources().getDrawable(R.drawable.ic_account_selected));
    Intent accountIntent = new Intent(this, AccountActivity.class);
    accountTab.setContent(accountIntent);

    // Adding all Tab to TabHost
    tabHost.addTab(homeTab); // Adding home tab
    tabHost.addTab(historyTab); // Adding history tab
    tabHost.addTab(helpTab); // Adding help tab
    tabHost.addTab(accountTab); // Adding account tab
  }
}
