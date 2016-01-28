package com.lrchao.store.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lrchao.store.data_provider.NetworkDataProvider;


/**
 * Description: TODO
 *
 * @author liuranchao
 * @date 15/11/23 上午10:34
 */
public abstract class BaseNetworkFragment extends BaseFragment {

    protected NetworkDataProvider mDataProvider;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDataProvider = initDataProvider();

        if (mDataProvider == null) {
           // finishActivity();
        }

        //mDataProvider.setOnLoadListener();
    }

    /**
     * 初始化DataProvider
     *
     * @return BaseDataProvider
     */
    protected abstract NetworkDataProvider initDataProvider();


     protected void onLoadStart() {

     }


     protected void setOnLoadEnd() {

     }



}
