package com.jaaaelu.gzw.animapp.anim;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationFlyActivity extends BaseActivity {
    @BindView(R.id.iv_anim_target)
    ImageView mAnimTarget;
    @BindView(R.id.btn_start_anim_fly)
    Button mStartAnimFlyBtn;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation_fly;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("一个简单的组合动画");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_start_anim_fly})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_anim_fly:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_set_fly);
                mAnimTarget.startAnimation(animation);
                break;
        }
    }
}
