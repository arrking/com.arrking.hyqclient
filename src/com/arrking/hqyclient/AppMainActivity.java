package com.arrking.hqyclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.arrking.hqyclient.ui.companies.ComIndexActivity;
import com.arrking.hqyclient.ui.contacts.ContxIndexActivity;
import com.arrking.hqyclient.ui.dashboard.DashIndexActivity;
import com.arrking.hqyclient.ui.profile.ProfileIndexActivity;
import com.arrking.hqyclient.ui.toolkit.ToolkitIndexActivity;

public class AppMainActivity extends TabActivity
        implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup appMainTab;
    private TabHost appTabHost;
    private Intent dashIntent;
    private Intent contactsIntent;
    private Intent companyIntent;
    private Intent profileIntent;
    private Intent toolkitIntent;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        this.appMainTab = ((RadioGroup) findViewById(R.id.app_main_tab_rg));
        this.appMainTab.setBackgroundResource(R.drawable.bottom_bar);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.appMainTab.measure(i, j);
        initTab();
        this.appMainTab.setOnCheckedChangeListener(this);
        setupIntent();
        
    }

    private void setupIntent() {
        this.appTabHost = getTabHost();
        TabHost localTabHost = this.appTabHost;
        // dashboard
        this.dashIntent = new Intent(this, DashIndexActivity.class);
        this.dashIntent.putExtra("bottomHeight", this.appMainTab.getHeight());
        localTabHost.addTab(buildTabSpec("tab_info", R.string.info, R.drawable.info_icon, this.dashIntent));
        // contacts
        this.contactsIntent = new Intent(this, ContxIndexActivity.class);
        localTabHost.addTab(buildTabSpec("tab_trade", R.string.trade, R.drawable.trade_icon, this.contactsIntent));
        // companies
        this.companyIntent = new Intent(this, ComIndexActivity.class);
        localTabHost.addTab(buildTabSpec("tab_store", R.string.store, R.drawable.store_icon, this.companyIntent));
        // profile
        this.profileIntent = new Intent(this, ProfileIndexActivity.class);
        localTabHost.addTab(buildTabSpec("tab_member", R.string.member, R.drawable.member_icon, this.profileIntent));
        // toolkit
        this.toolkitIntent = new Intent(this, ToolkitIndexActivity.class);
        localTabHost.addTab(buildTabSpec("tab_more", R.string.more, R.drawable.more_icon, this.toolkitIntent));
    }

    private TabHost.TabSpec buildTabSpec(String paramString, int paramInt1, int paramInt2, Intent paramIntent)
    {
        return this.appTabHost.newTabSpec(paramString).setIndicator(null, null).setContent(paramIntent);
    }

    // init bottom tab as first navigator
    private void initTab() {
        // home button
        RadioButton dashbordRadioButton = new RadioButton(this);
        setTabBtn(dashbordRadioButton);
        dashbordRadioButton.setId(0);
        dashbordRadioButton.setText(R.string.info);
        dashbordRadioButton.setTextSize(1, 15.0F);
        this.appMainTab.addView(dashbordRadioButton);

        // contacts
        RadioButton contactsRadioButton = new RadioButton(this);
        setTabBtn(contactsRadioButton);
        contactsRadioButton.setId(1);
        contactsRadioButton.setText(R.string.trade);
        contactsRadioButton.setTextSize(1, 15.0F);
        this.appMainTab.addView(contactsRadioButton);

        // companies
        RadioButton companiesRadioButton = new RadioButton(this);
        setTabBtn(companiesRadioButton);
        companiesRadioButton.setId(2);
        companiesRadioButton.setText(R.string.store_index);
        companiesRadioButton.setTextSize(1, 15.0F);
        companiesRadioButton.setClickable(false);
        this.appMainTab.addView(companiesRadioButton);

        // current user
        RadioButton profileRadioButton = new RadioButton(this);
        setTabBtn(profileRadioButton);
        profileRadioButton.setId(3);
        profileRadioButton.setText(R.string.me);
        profileRadioButton.setTextSize(1, 15.0F);
        this.appMainTab.addView(profileRadioButton);

        // toolkit
        RadioButton toolkitRadioButton = new RadioButton(this);
        setTabBtn(toolkitRadioButton);
        toolkitRadioButton.setId(4);
        toolkitRadioButton.setText(R.string.more);
        toolkitRadioButton.setTextSize(1, 15.0F);
        this.appMainTab.addView(toolkitRadioButton);
    }

    // set child btn into tab
    private void setTabBtn(RadioButton paramRadioButton) {
        paramRadioButton.setGravity(1);
        RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams(-2, -1);
        localLayoutParams.setMargins(1, 1, 1, 1);
        localLayoutParams.weight = 1.0F;
        paramRadioButton.setButtonDrawable(R.drawable.none);
        paramRadioButton.setPadding(0, 0, 0, 0);
        paramRadioButton.setLayoutParams(localLayoutParams);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}
