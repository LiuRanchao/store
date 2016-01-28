package com.lrchao.store.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.lrchao.store.R;
import com.lrchao.store.ui.activity.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 首页导航的头部view
 *
 * @author liuranchao
 * @date 16/1/13 上午11:29
 */
public class NavigationHeaderView extends LinearLayout{

    private Context mContext;

    @Bind(R.id.tv_username)
    TextView mTvUserName;

    public NavigationHeaderView(Context context) {
        super(context);
        initView(context);
    }

    public NavigationHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.nav_header_main, this);
        ButterKnife.bind(this);
    }

    public void bindView() {
        mTvUserName.setText(mContext.getString(R.string.login_or_register));
    }

    @OnClick(R.id.tv_username)
    public void onClickUserName() {
        mContext.startActivity(new Intent(mContext, LoginActivity.class));
    }
}
