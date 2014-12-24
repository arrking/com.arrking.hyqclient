package com.arrking.hqyclient.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.arrking.android.component.LoadingUI;
import com.arrking.hqyclient.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.arrking.hqyclient.util.AppUtil;

import java.util.ArrayList;

/**
 * Created by hain on 23/12/2014.
 */
public class DashIndexActivity extends Activity {

    private static final String TAG = new String("DashIndexActivity");
    // top bar title text
    private TextView tb_title;
    private LoadingUI LoadingUI;
    private PullToRefreshListView RecommendedListView;
    private RelativeLayout indexRecommendRelativelayout;
    private RelativeLayout.LayoutParams pbLP;
    private String format;

    // handle PullToRefreshListView click event
    private AdapterView.OnItemClickListener listItemClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
        }
    };

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.d(TAG, "get run .... ");
        setContentView(R.layout.dashboard);
        tb_title = (TextView) findViewById(R.id.txt_wb_title);
        tb_title.setText("主页");
        this.format = getString(R.string.pull_to_refresh_last_time_format);
        initView();
    }

    private void initView() {
        // recommended slides container
        this.indexRecommendRelativelayout = ((RelativeLayout)findViewById(R.id.index_recommend_relativelayout));

        // recommended slides
        this.RecommendedListView = ((PullToRefreshListView)findViewById(R.id.recommend_listview));
        ((ListView)this.RecommendedListView.getRefreshableView()).setDividerHeight(0);
        this.RecommendedListView.setOnItemClickListener(this.listItemClickListener);
        this.RecommendedListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        this.RecommendedListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener()
        {
            @Override
            public void onRefresh(PullToRefreshBase refreshView) {
                // do your magic to update the list
                refreshIndexList(false, false);
                String str = AppUtil.getDataString(System.currentTimeMillis() / 1000L, DashIndexActivity.this.format);
            }
        });
        // now, get data into tables
        refreshIndexList(true, true);
    }

    private void refreshIndexList(boolean b, boolean b1) {

    }


}


