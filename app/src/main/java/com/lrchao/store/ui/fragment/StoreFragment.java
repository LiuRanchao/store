package com.lrchao.store.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.lrchao.store.R;
import com.lrchao.store.data_provider.NetworkDataProvider;
import com.lrchao.store.data_provider.user.UserDataProvider;
import com.lrchao.store.ui.activity.SettingsActivity;


/**
 * Description: TODO
 *
 * @author liuranchao
 * @date 15/12/23 下午4:19
 */
public class StoreFragment extends BaseNetworkFragment{


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initView(View mainView) {

        mainView.findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });

        UserDataProvider provider = new UserDataProvider();
        //provider.load();

    }

    @Override
    protected NetworkDataProvider initDataProvider() {
        return null;
    }
}
