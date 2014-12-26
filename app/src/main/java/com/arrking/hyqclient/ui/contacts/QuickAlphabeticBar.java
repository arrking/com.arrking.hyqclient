package com.arrking.hyqclient.ui.contacts;

/**
 * Created by hain on 26/12/2014.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.arrking.hyqclient.R;

import java.util.HashMap;

public class QuickAlphabeticBar extends ImageButton {
    private HashMap<String, Integer> alphaIndexer;
    private String[] letters = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private TextView mDialogText;
    private Handler mHandler;
    private float mHight;
    private ListView mList;

    public QuickAlphabeticBar(Context paramContext) {
        super(paramContext);
    }

    public QuickAlphabeticBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public QuickAlphabeticBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void init(Activity paramActivity) {
        this.mDialogText = ((TextView) paramActivity.findViewById(R.id.fast_position));
        this.mHandler = new Handler();
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i = paramMotionEvent.getAction();
        // TODO Fix this scroll list
        // get the current letter
        int j = (int) (paramMotionEvent.getY() / (this.mHight / 27.0F));
        if ((j < 27) && (j >= 0)) {
            String str = this.letters[j];
            if (this.alphaIndexer.containsKey(str)) {
                int k = ((Integer) this.alphaIndexer.get(str)).intValue();
                this.mList.setSelectionFromTop(k, 0);
            }
            this.mDialogText.setText(this.letters[j]);
        }
        // i=0 -> ACTION_DOWN
        // i=1 -> ACTION_UP
        if (i == 0 && (this.mHandler != null)) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if ((QuickAlphabeticBar.this.mDialogText != null) && (QuickAlphabeticBar.this.mDialogText.getVisibility() == View.INVISIBLE))
                        QuickAlphabeticBar.this.mDialogText.setVisibility(View.VISIBLE);
                }
            });
            return super.onTouchEvent(paramMotionEvent);
        } else if ((i == 1) && (this.mHandler != null)) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if ((QuickAlphabeticBar.this.mDialogText != null) && (QuickAlphabeticBar.this.mDialogText.getVisibility() == View.VISIBLE))
                        QuickAlphabeticBar.this.mDialogText.setVisibility(View.INVISIBLE);
                }
            });
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setAlphaIndexer(HashMap<String, Integer> paramHashMap) {
        this.alphaIndexer = paramHashMap;
    }

    public void setHight(float paramFloat) {
        this.mHight = paramFloat;
    }

    public void setListView(ListView paramListView) {
        this.mList = paramListView;
    }
}