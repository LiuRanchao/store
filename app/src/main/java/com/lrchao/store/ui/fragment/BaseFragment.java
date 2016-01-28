package com.lrchao.store.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lrchao.store.util.LogUtils;

import butterknife.ButterKnife;

/**
 * Description: Fragment的基类
 *
 * @author liuranchao
 * @date 15/11/8 上午1:29
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Fragment的根view
     */
    protected View mMainView;

    /**
     * 设置Layout布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 初始化布局文件
     *
     * @param mainView 根据
     */
    protected abstract void initView(View mainView);

    /**
     * 初始化数据方法
     * @param intent Intent
     */
    protected void initData(Intent intent) {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(getActivity().getIntent());
        LogUtils.D("onCreate()");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.D("onCreateView()=mMainView" + mMainView);
        if (mMainView == null) {
            mMainView = inflater.inflate(getLayoutId(), container, false);
            // 初始化ButterKnife
            ButterKnife.bind(this, mMainView);
            initView(mMainView);
        } else {
            ViewGroup parent = (ViewGroup) mMainView.getParent();
            if (parent != null) {
                parent.removeView(mMainView);
            }

        }
        return mMainView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 关闭activity
     */
    public void finishActivity() {
        if (getActivity() != null) {
            getActivity().finish();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
