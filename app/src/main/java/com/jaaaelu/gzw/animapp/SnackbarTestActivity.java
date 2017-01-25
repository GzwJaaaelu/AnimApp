package com.jaaaelu.gzw.animapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.jaaaelu.gzw.animapp.base.BaseActivity;
import com.jaaaelu.gzw.animapp.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackbarTestActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private Snackbar mSnackbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_snackbar_test;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("模仿QQ音乐的返回");
        mSnackbar = Snackbar.make(mToolbar, "再次点击返回键退出当前界面", Snackbar.LENGTH_SHORT);
    }

    @Override
    protected void initListener() {
//        mFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if (mSnackbar.isShown()) {
            super.onBackPressed();
            return;
        }
        View view = mSnackbar.getView();
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            view.setMinimumHeight(150);
        }
        mSnackbar.show();
    }
}
