package com.carl.mvpdemo.pub.utils;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.widget.EditText;

import com.carl.mvpdemo.R;


/**
 * @author Carl
 * version 1.0
 * @since 2018/8/21
 */
public class KeyboardUtil {
    private Activity mActivity;
    private Context mContext;
    private KeyboardView keyboardView;

    private Keyboard kLetter1;

    public KeyboardUtil(Activity activity, Context context, EditText edit) {
        this.mActivity = activity;
        this.mContext = context;
        kLetter1 = new Keyboard(context, R.xml.test_keyboard);
        keyboardView = (KeyboardView) activity.findViewById(R.id.keyboard_view);

        keyboardView.setKeyboard(kLetter1);
        keyboardView.setEnabled(true);
        keyboardView.setPreviewEnabled(true);
        keyboardView.setOnKeyboardActionListener(listener);


    }


    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void onPress(int primaryCode) {

        }

        @Override
        public void onRelease(int primaryCode) {

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {

        }

        @Override
        public void onText(CharSequence text) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };


    public void showKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
        }
    }
}
