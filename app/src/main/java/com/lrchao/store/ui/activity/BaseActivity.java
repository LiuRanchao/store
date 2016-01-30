package com.lrchao.store.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.lrchao.store.R;
import com.lrchao.store.util.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Description: activity的基类
 *
 * @author liuranchao
 * @date 15/11/7 下午10:09
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = getClass().getSimpleName();


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    /**
     * FragmentManager在onCreate()时候初始化
     */
    private FragmentManager mFragmentManager;

    /**
     * 初始化数据使用，和view无关
     *
     * @param intent Intent
     */
    protected void initData(Intent intent) {
        if (intent == null) {
            return;
        }

    }

    /**
     * 初始化view相关的方法
     */
    protected abstract void initView();

    /**
     * 设置布局文件
     *
     * @return R.layout.xxx
     */
    protected abstract int getLayoutId();


    /**
     * 显示Fragment
     */
    protected void showFragment(Fragment fragment) {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);

        transaction.commitAllowingStateLoss();
    }

    /**
     * fragment 切换
     *
     * @param from   当前是哪个fragment
     * @param to     要跳转到哪个fragment
     * @param bundle 携带的数据
     */
    protected void switchContent(Fragment from, Fragment to, Bundle bundle, int containerResId) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        // 如果from已经添加 则隐藏
        if (from.isAdded()) {
            transaction.hide(from);
        }
        // 如果to 已经添加 则显示
        if (to.isAdded()) {
            transaction.show(to);
        } else {
            // 如果TO未添加则添加
            to.setArguments(bundle);
            transaction.add(containerResId, to);
        }
        transaction.commitAllowingStateLoss();
    }


    /**
     * 设置FloatingActionButton
     */
    protected void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.D(TAG, "onCreate");
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData(getIntent());
        initToolBar();
        initFragment();
        initView();
    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
    }


    /**
     * 初始初始化toolbar
     */
    private void initToolBar() {
        LogUtils.D(TAG, "mToolbar=" + mToolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.toolbar_back_white);

        setSupportActionBar(mToolbar);
        // 要放在setSupportActionBar之后
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doFinish();
            }
        });
    }

    /**
     * 关闭界面
     */
    protected void doFinish() {
        this.finish();
    }

    /**
     * @return ToolBar
     */
    public Toolbar getToolbar() {
        return mToolbar;
    }

    /**
     * 设置toolbar显示
     *
     * @param resId String资源ID
     */
    protected void setToolbarTitle(int resId) {
        if (mToolbar != null) {
            mToolbar.setTitle(resId);
        }
    }

    /**
     * 设置toolbar的背景色
     * @param colorResId colors.xml
     */
    protected void setToolbarColor(int colorResId) {
        if (mToolbar != null) {
            mToolbar.setBackgroundResource(colorResId);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
