package com.arrking.hyqclient.ui.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.arrking.hyqclient.R;
import com.arrking.hyqclient.component.LoadingUI;

/**
 * Created by hain on 23/12/2014.
 */
public class ContxIndexActivity extends Activity implements  AdapterView.OnItemClickListener {

    private static final String TAG = new String("ContxIndexActivity");
    // top bar title text
    private TextView tb_title;
    private ListView peopleListView;
    private QuickAlphabeticBar alpha;
    private EditText searchBoxEditText;
    private LoadingUI loadingUI;
    private FrameLayout rootView;


    View.OnTouchListener touchListener = new View.OnTouchListener()
    {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
            // do your ontouch magic
            // hide keyboard, etc ...
            return false;
        }
    };

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.contacts);
        initUI();

    }

    private void initUI() {
        this.tb_title = (TextView) findViewById(R.id.txt_wb_title);
        this.tb_title.setText("通讯录");
        this.peopleListView = (ListView) findViewById(R.id.maillist_layout_main_listView);
        this.peopleListView.setOnTouchListener(this.touchListener);
        this.peopleListView.setOnItemClickListener(this);
        this.peopleListView.setDivider(getResources().getDrawable(R.drawable.line_image));
        this.alpha = ((QuickAlphabeticBar)findViewById(R.id.fast_scroller_view));
        this.searchBoxEditText = (EditText) findViewById(R.id.edit);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.searchBoxEditText.measure(i,j);
//        Constants.TOPSEARCH = this.editText.getMeasuredHeight();
        loadAndDisplayContacts();
    }

    private void loadAndDisplayContacts() {
        addLoading();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do open contact card
    }

    private void addLoading()
    {
        this.rootView = ((FrameLayout)getWindow().getDecorView());
        this.loadingUI = new LoadingUI(this, getResources().getString(R.string.loading_tip));
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.loadingUI.setLayoutParams(localLayoutParams);
        this.rootView.addView(this.loadingUI);
    }
}
