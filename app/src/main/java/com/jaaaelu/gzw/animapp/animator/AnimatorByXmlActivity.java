package com.jaaaelu.gzw.animapp.animator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimatorByXmlActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("通过xml实现视图动画");
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    public void finish() {
        super.finish();
        customExit();
    }

    private void customExit() {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
