package com.lrchao.store.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.lrchao.store.R;


/**
 * Description: 设置界面
 *
 * @author liuranchao
 * @date 16/1/13 上午10:22
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
