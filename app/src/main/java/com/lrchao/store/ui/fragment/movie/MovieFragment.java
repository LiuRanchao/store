package com.lrchao.store.ui.fragment.movie;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lrchao.store.R;
import com.lrchao.store.data_provider.NetworkDataProvider;
import com.lrchao.store.data_provider.user.UserDataProvider;
import com.lrchao.store.model.movie.in_theaters.InTheatersModel;
import com.lrchao.store.service.RequestService;
import com.lrchao.store.ui.activity.SettingsActivity;
import com.lrchao.store.ui.fragment.BaseNetworkFragment;


/**
 * Description: 影视的fragment
 *
 * @author liuranchao
 * @date 15/12/23 下午4:19
 */
public class MovieFragment extends BaseNetworkFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
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

        RecyclerView recyclerView = (RecyclerView) mainView.findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //recyclerView.setAdapter();
    }

    @Override
    protected int getUIRequestAction() {
        return RequestService.ACTION_DOUBAN_MOVIE_IN_THEATERS;
    }







}
