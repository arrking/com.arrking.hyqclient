package com.arrking.hyqclient.ui.contacts;

/**
 * Created by hain on 26/12/2014.
 */
import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.arrking.hyqclient.R;

public class ListNoDataAdapter extends BaseAdapter
        implements View.OnClickListener
{
    private Activity activity;
    private String tipWord;

    public ListNoDataAdapter(Activity paramActivity, String paramString)
    {
        this.activity = paramActivity;
        this.tipWord = paramString;
    }

    public int getCount()
    {
        return 1;
    }

    public Object getItem(int paramInt)
    {
        return null;
    }

    public long getItemId(int paramInt)
    {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        LinearLayout localLinearLayout = new LinearLayout(this.activity);
        // LinearLayout.HORIZONTAL also got the integer value 0 and Vertical got 1
        localLinearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        TextView localTextView1 = new TextView(this.activity);
        localTextView1.setTextSize(15.0F);
        localTextView1.setText(" ");
        localTextView1.setOnClickListener(this);
        TextView localTextView2 = new TextView(this.activity);
        localTextView2.setTextSize(15.0F);
        localTextView2.setText(this.tipWord);
        localTextView2.setTextColor(this.activity.getResources().getColor(R.color.not_data_tip));
        localTextView2.setOnClickListener(this);
        TextView localTextView3 = new TextView(this.activity);
        localTextView3.setTextSize(15.0F);
        localTextView3.setText(" ");
        localTextView3.setOnClickListener(this);
        localLinearLayout.addView(localTextView1, localLayoutParams);
        localLinearLayout.addView(localTextView2, localLayoutParams);
        localLinearLayout.addView(localTextView3, localLayoutParams);
        localLinearLayout.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
                return false;
            }
        });
        return localLinearLayout;
    }

    public void onClick(View paramView)
    {
    }
}