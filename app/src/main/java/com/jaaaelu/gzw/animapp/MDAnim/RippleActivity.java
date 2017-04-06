package com.jaaaelu.gzw.animapp.MDAnim;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RippleActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ripple;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("触摸反馈");
    }

    @Override
    protected void initListener() {

    }
}
