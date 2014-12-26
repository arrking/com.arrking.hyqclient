package com.arrking.hyqclient;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.arrking.hyqclient.ui.contacts.ContxIndexActivity;
import com.arrking.hyqclient.ui.dashboard.DashIndexActivity;
import com.arrking.hyqclient.ui.jobs.JobsIndexActivity;
import com.arrking.hyqclient.ui.profile.ProfileIndexActivity;
import com.arrking.hyqclient.util.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

@SuppressWarnings("deprecation")
public class AppMainActivity extends TabActivity {
    private TabHost tabHost;

    private static final String DASH_TAB = "dashboard";
    // CONX - contacts
    private static final String CONX_TAB = "contacts";
    private static final String JOBS_TAB = "jobs";
    private static final String PROFILE_TAB = "profile";

    public void initUI() {
        tabHost = this.getTabHost();
        TabSpec dashSpec = tabHost.newTabSpec(DASH_TAB).setIndicator(DASH_TAB).setContent(new Intent(this, DashIndexActivity.class));
        TabSpec conxSpec = tabHost.newTabSpec(CONX_TAB).setIndicator(CONX_TAB).setContent(new Intent(this, ContxIndexActivity.class));
        TabSpec jobsSpec = tabHost.newTabSpec(JOBS_TAB).setIndicator(JOBS_TAB).setContent(new Intent(this, JobsIndexActivity.class));
        TabSpec profileSpec = tabHost.newTabSpec(PROFILE_TAB).setIndicator(PROFILE_TAB).setContent(new Intent(this, ProfileIndexActivity.class));

        tabHost.addTab(dashSpec);
        tabHost.addTab(conxSpec);
        tabHost.addTab(jobsSpec);
        tabHost.addTab(profileSpec);

        tabHost.setCurrentTabByTag(DASH_TAB);

        RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.main_radio);
        final RadioButton rb = (RadioButton) this.findViewById(R.id.rb_dash);
        rb.setBackgroundResource(R.drawable.tabhost_selected);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb.setBackgroundResource(R.drawable.tabhost_bg_selector);
                switch (checkedId) {
                    case R.id.rb_dash:
                        tabHost.setCurrentTabByTag(DASH_TAB);
                        break;

                    case R.id.rb_contacts:
                        tabHost.setCurrentTabByTag(CONX_TAB);
                        break;

                    case R.id.rb_jobs:
                        tabHost.setCurrentTabByTag(JOBS_TAB);
                        break;

                    case R.id.rb_profile:
                        tabHost.setCurrentTabByTag(PROFILE_TAB);
                        break;

                    default:
                        break;
                }
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // setup Android-Universal-Image-Loader
        ImageLoader.getInstance().init(ImageUtil.getImageLoaderConfiguration(this));
        initUI();

    }


}
