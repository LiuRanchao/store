package com.lrchao.store.ui.activity;


import com.lrchao.store.R;
import com.lrchao.store.ui.fragment.LoginFragment;

/**
 * Description: 登录页面
 *
 * @author liuranchao
 * @date 15/11/8 上午1:17
 */
public class LoginActivity extends BaseActivity {


    @Override
    protected void initView() {
        setTitle(R.string.login);
        showFragment(new LoginFragment());

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common;
    }
}
