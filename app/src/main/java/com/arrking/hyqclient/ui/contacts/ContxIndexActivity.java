package com.arrking.hyqclient.ui.contacts;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.arrking.hyqclient.R;
import com.arrking.hyqclient.component.LoadingUI;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
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
        // fake names -> pinyin data for fast postion
        HashMap<String, String> names = new HashMap<String, String>();
        names.put("李四", "li si");
        names.put("李雷","li lei");
        names.put("韩梅梅", "han mei mei");
        names.put("露西", "lucy");
        names.put("大卫", "david");
        Random random    = new Random();
        List<String> keys      = new ArrayList<String>(names.keySet());
        List<String> randomNames = new ArrayList<String>();
        for(int i = 0 ; i <10 ; i ++){
            String  randomName = keys.get( random.nextInt(keys.size()) );
            randomNames.add(randomName);
        }
        Collections.sort(randomNames);

        for (int j = 0; j < randomNames.size(); j++) {
            ContentValues localContentValues = new ContentValues();

            localContentValues.put("id", j);
            localContentValues.put("userid", j);
            localContentValues.put("username", randomNames.get(j));
            localContentValues.put("gender", 1);
            localContentValues.put("post", "总经理");
            localContentValues.put("company", "中关村软件园HelloWorldCafe");
            localContentValues.put("tel", "010-5888888");
            localContentValues.put("mobile", "15888888888");
            localContentValues.put("catid", 1);
            localContentValues.put("catname", "management");
            localContentValues.put("province", "hei long jiang");
            localContentValues.put("city", "北京");
            localContentValues.put("district", "海淀");
            localContentValues.put("fax", "010-59999999");
            localContentValues.put("addr", "Xi Er Qi");
            // image should 85 * 85 pixels and 72 pixels/inch
            localContentValues.put("imgurl", "http://pic.jschina.com.cn/0/12/19/62/12196279_843728.jpg");
            localContentValues.put("imgpath", "http://pic.jschina.com.cn/0/12/19/62/12196279_843728.jpg");
            localContentValues.put("imgname", "foo");
            localContentValues.put("created", 1);
            localContentValues.put("pinyin", names.get(randomNames.get(j)));
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
            return this.list.size();
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
            Log.d(TAG, "ContactsListAdapter getView @" + Integer.toString(position));
            ContxIndexActivity.ContactViewHolder localViewHolder;

            if(convertView == null){
                Log.d(TAG, "ContactsListAdapter convertView == null");
                convertView = this.inflater.inflate(R.layout.contacts_list_item, null);
                localViewHolder = new ContactViewHolder();
                localViewHolder.alpha = (TextView) convertView.findViewById(R.id.alpha);
                localViewHolder.name = (TextView) convertView.findViewById(R.id.user_name);
                localViewHolder.city = (TextView) convertView.findViewById(R.id.user_city);
                localViewHolder.company = (TextView) convertView.findViewById(R.id.user_company);
                localViewHolder.post = (TextView) convertView.findViewById(R.id.user_post);
                localViewHolder.headImage = (ImageView) convertView.findViewById(R.id.head_icon);
                convertView.setTag(localViewHolder);
            }else{
                Log.d(TAG, "ContactsListAdapter convertView != null");
                localViewHolder = (ContactViewHolder)convertView.getTag();
            }

            ContentValues localContentValues = (ContentValues) this.list.get(position);
            Log.d(TAG, "ContactsListAdapter localContentValues:" + localContentValues.toString());
            Log.d(TAG, "localContentValues city:" + localContentValues.getAsString("city") );
            if(localViewHolder.city == null){
                Log.d(TAG, "localViewHolder city == null ");
            }
            localViewHolder.city.setText(localContentValues.getAsString("city"));
            localViewHolder.alpha.setText(ContxIndexActivity.this.getAlpha(localContentValues.getAsString("pinyin")));
            localViewHolder.company.setText(localContentValues.getAsString("company"));
            localViewHolder.headImage.setImageResource(R.drawable.demo_dummy_leifeng);
            localViewHolder.name.setText(localContentValues.getAsString("username"));
            localViewHolder.post.setText(localContentValues.getAsString("post"));

            return convertView;
        }
    }

    private static class ContactViewHolder
    {
        TextView alpha;
        TextView city;
        TextView company;
        ImageView headImage;
        TextView name;
        TextView post;
    }

}
