package com.arrking.hyqclient.ui.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.arrking.hyqclient.R;

/**
 * Created by hain on 23/12/2014.
 */
public class ContxIndexActivity extends Activity {

    private static final String TAG = new String("ContxIndexActivity");
    // top bar title text
    private TextView tb_title;

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        Log.d(TAG, "get run .... ");
        setContentView(R.layout.contacts);
        tb_title=(TextView)findViewById(R.id.txt_wb_title);
        tb_title.setText("通讯录");
    }
}
