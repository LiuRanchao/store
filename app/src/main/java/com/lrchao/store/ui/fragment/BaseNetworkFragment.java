package com.lrchao.store.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lrchao.store.data_provider.NetworkDataProvider;
import com.lrchao.store.service.RequestService;


/**
 * Description: 处理网络请求功能的Fragment
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


        doLoadData();

    }

    /**
     * 请求数据
     */
    private void doLoadData() {
        if (getUIRequestAction() > 0) {
            Intent intent = RequestService.newStartIntent(getUIRequestAction());
            if (getActivity() != null) {
                getActivity().startService(intent);
            }
        }

    }

    /**
     * 子类负责设置请求的action
     * @return
     */
    protected int getUIRequestAction() {
        return 0;
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
