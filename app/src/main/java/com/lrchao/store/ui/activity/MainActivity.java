package com.lrchao.store.ui.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lrchao.store.R;
import com.lrchao.store.ui.fragment.BookShelfFragment;
import com.lrchao.store.ui.fragment.MovieFragment;
import com.lrchao.store.ui.widget.NavigationHeaderView;

import butterknife.Bind;

/**
 * Description: 主界面的activity
 *
 * @author liuranchao
 * @date 15/11/7 下午10:11
 */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //==========View=========
    /**
     * 抽屉控件
     */
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

    /**
     * 导航控件
     */
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    //===头部View
    /**
     * 用户名
     */
    TextView mTvUserName;

    //==========Fragment=========

    /**
     * 本地书架的fragment
     */
    private BookShelfFragment mBookShelfFragment;

    /**
     * 影视的fragment
     */
    private MovieFragment mMovieFragment;


    @Override
    protected void initView() {

        initFragment();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        // 设置头部
        View headerView = mNavigationView.inflateHeaderView(R.layout.view_nav_header_main);
        NavigationHeaderView navigationHeaderView = (NavigationHeaderView) headerView;
        navigationHeaderView.bindView();

        initFloatingActionButton();
    }

    /**
     * 初始化fragment
     */
    private void initFragment(){
        mBookShelfFragment = new BookShelfFragment();
        mMovieFragment = new MovieFragment();

        showFragment(mBookShelfFragment);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onBackPressed() {

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_book_shelf) {
            switchContent(mMovieFragment, mBookShelfFragment, null, R.id.fragment_container);
        } else if (id == R.id.nav_movie) {
            switchContent(mBookShelfFragment, mMovieFragment, null, R.id.fragment_container);
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
