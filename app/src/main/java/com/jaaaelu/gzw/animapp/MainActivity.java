package com.jaaaelu.gzw.animapp;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jaaaelu.gzw.animapp.anim.AnimationListActivity;
import com.jaaaelu.gzw.animapp.animator.AnimatorActivity;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_animation)
    Button mAnimationBtn;
    @BindView(R.id.btn_animator)
    Button mAnimatorBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("动画Demo主页");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_animation, R.id.btn_animator})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_animation:
                startActivity(new Intent(this, AnimationListActivity.class));
                break;
            case R.id.btn_animator:
//                startActivity(new Intent(this, AnimatorActivity.class));
                break;
        }
    }
}
