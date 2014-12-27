package com.arrking.hyqclient.ui.contacts;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.arrking.hyqclient.R;
import com.arrking.hyqclient.component.LoadingUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by hain on 23/12/2014.
 */
public class ContxIndexActivity extends Activity implements AdapterView.OnItemClickListener {

    private static final String TAG = new String("ContxIndexActivity");
    // top bar title text
    private TextView tb_title;
    private ListView peopleListView;
    private QuickAlphabeticBar alpha;
    private EditText searchBoxEditText;
    private LoadingUI loadingUI;
    private FrameLayout rootView;
    private List<ContentValues> contactsContentValuesList;
    private ListNoDataAdapter listNoDataAdapter;
    private BaseAdapter adapter;


    View.OnTouchListener touchListener = new View.OnTouchListener() {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
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
        this.alpha = ((QuickAlphabeticBar) findViewById(R.id.fast_scroller_view));
        this.searchBoxEditText = (EditText) findViewById(R.id.edit);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.searchBoxEditText.measure(i, j);
//        Constants.TOPSEARCH = this.editText.getMeasuredHeight();
        loadAndDisplayContacts();
    }

    private void loadAndDisplayContacts() {
//        addLoading();
        // do your magic to load data ...
        refreshList(0, null, false);
    }

    // update the data in contact contactsContentValuesList
    private void refreshList(int paramInt, String queryKey, boolean paramBoolean) {
//        0 is for VISIBLE, 4 is for INVISIBLE, 8 is for GONE
        this.peopleListView.setVisibility(View.VISIBLE);

        // when get data successfully, set alpha as GONE
//        this.alpha.setVisibility(View.GONE);
        this.contactsContentValuesList = fakeListData();
        setAdapter(this.contactsContentValuesList);
    }

    private List<ContentValues> fakeListData() {
        List<ContentValues> tmp = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("id", i);
            localContentValues.put("userid", i);
            localContentValues.put("username", "foo bar");
            localContentValues.put("gender", 1);
            localContentValues.put("post", 10000);
            localContentValues.put("companyname", "ARR");
            localContentValues.put("tel", "010-5888888");
            localContentValues.put("mobile", "15888888888");
            localContentValues.put("catid", 1);
            localContentValues.put("catname", "sooo");
            localContentValues.put("province", "hoooo");
            localContentValues.put("city", "BJ");
            localContentValues.put("district", "HD");
            localContentValues.put("fax", "010-59999999");
            localContentValues.put("addr", "Xi Er Qi");
            localContentValues.put("imgurl", "http://pic.jschina.com.cn/0/12/19/62/12196279_843728.jpg");
            localContentValues.put("imgpath", "http://pic.jschina.com.cn/0/12/19/62/12196279_843728.jpg");
            localContentValues.put("imgname", "foo");
            localContentValues.put("created", 1);
            localContentValues.put("pinyin", "foo bar");
            tmp.add(localContentValues);
        }
        return tmp;
//        this.searchBoxEditText.setVisibility(View.GONE);
//        this.listNoDataAdapter = new ListNoDataAdapter(this, getResources().getString(R.string.no_content_now));
//        this.peopleListView.setAdapter(this.listNoDataAdapter);
    }


    private void setAdapter(List<ContentValues> paramList) {
        this.adapter = new ContactsListAdapter(this, paramList);
        this.peopleListView.setAdapter(this.adapter);
        this.alpha.init(this);
        this.alpha.setListView(this.peopleListView);
        WindowManager localWindowManager = getWindowManager();
//        float f = 60 + (Constants.TOPSEARCH + Constants.BOTTOMHIGHT + Constants.TOPBARHIGHT);
//        this.alpha.setHight(localWindowManager.getDefaultDisplay().getHeight() - f);
        this.alpha.setHight(localWindowManager.getDefaultDisplay().getHeight() - 60);
        this.alpha.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do open contact card
    }

    private void addLoading() {
        this.rootView = ((FrameLayout) getWindow().getDecorView());
        this.loadingUI = new LoadingUI(this, getResources().getString(R.string.loading_tip));
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.loadingUI.setLayoutParams(localLayoutParams);
        this.rootView.addView(this.loadingUI);
    }

    private String getAlpha(String paramString) {
        if (paramString == null)
            return "#";
        if (paramString.trim().length() == 0)
            return "#";
        String c = paramString.trim().substring(0, 1);
        if (Pattern.compile("^[A-Za-z]+$").matcher(c).matches())
            return c.toUpperCase();
        return "#";
    }

    private class ContactsListAdapter extends BaseAdapter {
        private HashMap<String, Integer> alphaIndexer;
        private LayoutInflater inflater;
        private List<ContentValues> list;
        private String[] sections;

        public ContactsListAdapter(Activity activity, List<ContentValues> arg2) {
            Context localContext = activity;
            this.inflater = LayoutInflater.from(localContext);
            this.list = arg2;
//            Object localObject;
//            this.contactsContentValuesList = localObject;
            this.alphaIndexer = new HashMap();
            this.sections = new String[this.list.size()];
            for (int i = 0; ; i++) {
                if (i >= this.list.size()) {
                    ArrayList localArrayList = new ArrayList(this.alphaIndexer.keySet());
                    Collections.sort(localArrayList);
                    this.sections = new String[localArrayList.size()];
                    localArrayList.toArray(this.sections);
                    ContxIndexActivity.this.alpha.setAlphaIndexer(this.alphaIndexer);
                    return;
                }
                String str = ContxIndexActivity.this.getAlpha(((ContentValues) (this.list).get(i)).getAsString("pinyin"));
                if (!this.alphaIndexer.containsKey(str))
                    this.alphaIndexer.put(str, Integer.valueOf(i));
            }
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

}
