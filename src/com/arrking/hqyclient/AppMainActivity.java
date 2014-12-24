package com.arrking.hqyclient;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.arrking.hqyclient.ui.contacts.ContxIndexActivity;
import com.arrking.hqyclient.ui.dashboard.DashIndexActivity;
import com.arrking.hqyclient.ui.jobs.JobsIndexActivity;
import com.arrking.hqyclient.ui.profile.ProfileIndexActivity;

@SuppressWarnings("deprecation")
public class AppMainActivity extends TabActivity
{
//    private TabHost tabHost=null;
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.app_main);
//        tabHost=(TabHost)findViewById(android.R.id.tabhost);
//        tabHost.setFocusable(true);
//        TabHost.TabSpec tabSpec=tabHost.newTabSpec("1");
//        Intent intent=new Intent(this, DashIndexActivity.class);
//        tabSpec.setIndicator("工作区").setContent(intent);
//        tabHost.setup(this.getLocalActivityManager());
//        tabHost.addTab(tabSpec);
//
//        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("2");
//        Intent intent2=new Intent(this, DashIndexActivity.class);
//        tabSpec2.setIndicator("娱乐生活").setContent(intent2);
//        tabHost.addTab(tabSpec2);
//
//        TabHost.TabSpec tabSpec3=tabHost.newTabSpec("3");
//        Intent intent3=new Intent(this, DashIndexActivity.class);
//        tabSpec3.setIndicator("工具箱").setContent(intent3);
//        tabHost.addTab(tabSpec3);
//
//        TabHost.TabSpec tabSpec4=tabHost.newTabSpec("4");
//        Intent intent4=new Intent(this, DashIndexActivity.class);
//        tabSpec4.setIndicator("个人中心").setContent(intent4);
//        tabHost.addTab(tabSpec4);
//        tabHost.setCurrentTab(0);
//        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.main_radiogroup);
//        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId)
//            {
//                switch (checkedId) {
//                    case R.id.workspace:
//                        tabHost.setCurrentTab(0);
//                        break;
//                    case R.id.entertainment:
//                        tabHost.setCurrentTab(1);
//                        break;
//                    case R.id.tools:
//                        tabHost.setCurrentTab(2);
//                        break;
//                    case R.id.setting:
//                        tabHost.setCurrentTab(3);
//                        break;
//
//                }
//            }
//        });
//    }
private TabHost tabHost;

    private static final String DASH_TAB="dashboard";
    // CONX - contacts
    private static final String CONX_TAB="contacts";
    private static final String JOBS_TAB="jobs";
    private static final String PROFILE_TAB="profile";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabHost = this.getTabHost();
        TabSpec dashSpec=tabHost.newTabSpec(DASH_TAB).setIndicator(DASH_TAB).setContent(new Intent(this, DashIndexActivity.class));
        TabSpec conxSpec=tabHost.newTabSpec(CONX_TAB).setIndicator(CONX_TAB).setContent(new Intent(this, ContxIndexActivity.class));
        TabSpec jobsSpec=tabHost.newTabSpec(JOBS_TAB).setIndicator(JOBS_TAB).setContent(new Intent(this, JobsIndexActivity.class));
        TabSpec profileSpec=tabHost.newTabSpec(PROFILE_TAB).setIndicator(PROFILE_TAB).setContent(new Intent(this,ProfileIndexActivity.class));

        tabHost.addTab(dashSpec);
        tabHost.addTab(conxSpec);
        tabHost.addTab(jobsSpec);
        tabHost.addTab(profileSpec);

        tabHost.setCurrentTabByTag(DASH_TAB);

        RadioGroup radioGroup =  (RadioGroup) this.findViewById(R.id.main_radio);
        final RadioButton rb=(RadioButton)this.findViewById(R.id.rb_dash);
        rb.setBackgroundResource(R.drawable.tabhost_press);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                rb.setBackgroundResource(R.drawable.tabhost_bg_selector);
                switch (checkedId)
                {
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


}
