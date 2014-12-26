package com.arrking.hyqclient.ui.profile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arrking.hyqclient.util.Constants;
import com.arrking.hyqclient.util.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import com.arrking.hyqclient.R;
import com.arrking.hyqclient.component.RoundedImageView;
import com.arrking.hyqclient.util.KeyboardUtils;

/**
 * Created by hain on 23/12/2014.
 */
public class ProfileIndexActivity extends Activity implements View.OnClickListener {

    private static final String TAG = new String("JobsIndexActivity");
    private ImageUtil imageUtil;

    // top bar title text
    private TextView tb_title;

    // profile data
    private TextView prf_email;
    private EditText prf_name;
    private EditText prf_phone;
    private EditText prf_status;
    private RoundedImageView avatarImageView;


    // layouts for clickable event
    private RelativeLayout changeFullNameRelativeLayout;
    private RelativeLayout changePhoneRelativeLayout;
    private RelativeLayout changeStatusRelativeLayout;

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.d(TAG, "get run .... ");
        setContentView(R.layout.profile);
        imageUtil = new ImageUtil(this);

        tb_title = (TextView) findViewById(R.id.txt_wb_title);
        tb_title.setText("我的页面");

        initUI();
        // support change buttons
        initListeners();
        loadUserData();
    }

    private void loadUserData() {
        loadAvatar();
    }

    private void initUI() {
        // avatar image
        this.avatarImageView = (RoundedImageView) findViewById(R.id.avatar_imageview);

        // set profile texts
        this.prf_email = (TextView) findViewById(R.id.email_textview);
        this.prf_phone = (EditText) findViewById(R.id.phone_edittext);
        this.prf_status = (EditText) findViewById(R.id.status_edittext);
        this.prf_name = (EditText) findViewById(R.id.fullname_edittext);

        this.prf_name.setText("张三");
        this.prf_email.setText("zhangsan@foo.com");
        this.prf_phone.setText("139-9999-9999");
        this.prf_status.setText("圣诞节");

        // disable editing for texts input by default
        this.prf_name.setEnabled(false);
        this.prf_email.setEnabled(false);
        this.prf_phone.setEnabled(false);
        this.prf_status.setEnabled(false);
    }

    private void initListeners() {
//        changeAvatarLinearLayout.setOnClickListener(this);
//        avatarImageView.setOnClickListener(this);
        changeFullNameRelativeLayout = (RelativeLayout) findViewById(R.id.change_fullname_relativelayout);
        changePhoneRelativeLayout = (RelativeLayout) findViewById(R.id.change_phone_relativelayout);
        changeStatusRelativeLayout = (RelativeLayout) findViewById(R.id.change_status_relativelayout);

        changeFullNameRelativeLayout.setOnClickListener(this);
        changePhoneRelativeLayout.setOnClickListener(this);
        changeStatusRelativeLayout.setOnClickListener(this);
    }

    private void changeNameOnClick() {
        initChangingEditText(this.prf_name);
    }

    private void changePhoneOnClick() {
        initChangingEditText(this.prf_phone);
    }

    private void changeStatusOnClick() {
        initChangingEditText(this.prf_status);
    }

    private void initChangingEditText(EditText editText) {
        editText.setEnabled(true);
        editText.requestFocus();
        KeyboardUtils.showKeyboard(this);
    }

    private void stopChangingEditText(EditText editText) {
        editText.setEnabled(false);
        KeyboardUtils.hideKeyboard(this);
    }

    private void loadAvatar() {
        ImageLoader.getInstance().displayImage("http://pic.jschina.com.cn/0/12/19/62/12196279_843728.jpg",
                avatarImageView, Constants.UIL_USER_AVATAR_DISPLAY_OPTIONS);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // TODO Support Avatar Change
//            case R.id.avatar_imageview:
//            case R.id.change_avatar_linearlayout:
//                changeAvatarOnClick();
//                break;
            case R.id.change_fullname_relativelayout:
                changeNameOnClick();
                break;
            case R.id.change_phone_relativelayout:
                changePhoneOnClick();
                break;
            case R.id.change_status_relativelayout:
                changeStatusOnClick();
                break;
        }
    }
}
