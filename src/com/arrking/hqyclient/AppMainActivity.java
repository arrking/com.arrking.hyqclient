package com.arrking.hqyclient;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AppMainActivity extends TabActivity
        implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup appMainTab;

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

    }

    // init bottom tab as first navigator
    private void initTab() {
        // home button
        RadioButton localRadioButton5 = new RadioButton(this);
        setTabBtn(localRadioButton5);
        localRadioButton5.setId(0);
        localRadioButton5.setText(R.string.info);
        localRadioButton5.setTextSize(1, 15.0F);
        this.appMainTab.addView(localRadioButton5);

        // contacts
        RadioButton localRadioButton4 = new RadioButton(this);
        setTabBtn(localRadioButton4);
        localRadioButton4.setId(1);
        localRadioButton4.setText(R.string.trade);
        localRadioButton4.setTextSize(1, 15.0F);
        this.appMainTab.addView(localRadioButton4);

        // companies
        RadioButton localRadioButton3 = new RadioButton(this);
        setTabBtn(localRadioButton3);
        localRadioButton3.setId(2);
        localRadioButton3.setText(R.string.store_index);
        localRadioButton3.setTextSize(1, 15.0F);
        localRadioButton3.setClickable(false);
        this.appMainTab.addView(localRadioButton3);

        // current user
        RadioButton localRadioButton2 = new RadioButton(this);
        setTabBtn(localRadioButton2);
        localRadioButton2.setId(3);
        localRadioButton2.setText(R.string.member);
        localRadioButton2.setTextSize(1, 15.0F);
        this.appMainTab.addView(localRadioButton2);

        // toolkit
        RadioButton localRadioButton1 = new RadioButton(this);
        setTabBtn(localRadioButton1);
        localRadioButton1.setId(4);
        localRadioButton1.setText(R.string.more);
        localRadioButton1.setTextSize(1, 15.0F);
        this.appMainTab.addView(localRadioButton1);
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
