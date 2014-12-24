package com.arrking.hqyclient;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.arrking.hqyclient.ui.dashboard.DashIndexActivity;

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

    private static final String HOME_TAB="home";
    private static final String AT_TAB="at";
    private static final String MSG_TAB="msg";
    private static final String MORE_TAB="more";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabHost = this.getTabHost();
        TabSpec homeSpec=tabHost.newTabSpec(HOME_TAB).setIndicator(HOME_TAB).setContent(new Intent(this, DashIndexActivity.class));
        TabSpec atSpec=tabHost.newTabSpec(AT_TAB).setIndicator(AT_TAB).setContent(new Intent(this,DashIndexActivity.class));
        TabSpec msgSpec=tabHost.newTabSpec(MSG_TAB).setIndicator(MSG_TAB).setContent(new Intent(this,DashIndexActivity.class));
        TabSpec moreSpec=tabHost.newTabSpec(MORE_TAB).setIndicator(MORE_TAB).setContent(new Intent(this,DashIndexActivity.class));

        tabHost.addTab(homeSpec);
        tabHost.addTab(atSpec);
        tabHost.addTab(msgSpec);
        tabHost.addTab(moreSpec);

        tabHost.setCurrentTabByTag(HOME_TAB);

        RadioGroup radioGroup =  (RadioGroup) this.findViewById(R.id.main_radio);
        final RadioButton rb=(RadioButton)this.findViewById(R.id.rb_home);
        rb.setBackgroundResource(R.drawable.tabhost_press);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                rb.setBackgroundResource(R.drawable.tabhost_bg_selector);
                switch (checkedId)
                {
                    case R.id.rb_home:
                        tabHost.setCurrentTabByTag(HOME_TAB);
                        break;

                    case R.id.rb_at:
                        tabHost.setCurrentTabByTag(AT_TAB);
                        break;

                    case R.id.rb_mess:
                        tabHost.setCurrentTabByTag(MSG_TAB);
                        break;

                    case R.id.rb_more:
                        tabHost.setCurrentTabByTag(MORE_TAB);
                        break;

                    default:
                        break;
                }
            }
        });

    }


}
