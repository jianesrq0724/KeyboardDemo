package com.carl.mvpdemo.module.testlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.carl.mvpdemo.R;
import com.carl.mvpdemo.pub.base.BaseActivity;
import com.carl.mvpdemo.pub.base.BasePresenter;
import com.carl.mvpdemo.pub.utils.KeyboardUtil;

import java.lang.reflect.Method;

public class TestActivity extends BaseActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), TestActivity.class);
        context.startActivity(intent);
    }

    private EditText mEtTest;

    private void assignViews() {
        mEtTest =  findViewById(R.id.et_test);
    }


    @Override
    protected void findView() {
        assignViews();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mEtTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showKeyboard();
                return false;
            }
        });
    }

    private void showKeyboard() {
        //隐藏键盘操作
        //4.0以下 danielinbiti
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            mEtTest.setInputType(InputType.TYPE_NULL);
        } else {
            ((Activity) mContext).getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus",
                        boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(mEtTest, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //显示键盘
        new KeyboardUtil(((Activity) mContext), mContext, mEtTest).showKeyboard();
    }

    @Override
    public void setOnInteractListener() {

    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }
}
