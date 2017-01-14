package com.jaaaelu.gzw.animapp.anim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/1/14.
 */

public class AnimationFrameActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_avater_one)
    ImageView mAvaterOne;
    @BindView(R.id.iv_avater_two)
    ImageView mAvaterTwo;
    @BindView(R.id.iv_anim_target)
    ImageView mAnimTarget;
    @BindView(R.id.btn_start_anim_frame)
    Button mStartAnimFrameBtn;
    @BindView(R.id.btn_end_anim_frame)
    Button mEndAnimFrameBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation_frame;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("帧动画");
        //  把帧动画设置进去
        mAnimTarget.setBackgroundResource(R.drawable.play_list);
        mAnimTarget.setVisibility(View.GONE);
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_start_anim_frame, R.id.btn_end_anim_frame})
    public void onClick(View view) {
        //  获取AnimationDrawable
        AnimationDrawable frameAnimation = (AnimationDrawable) mAnimTarget.getBackground();
        switch (view.getId()) {
            case R.id.btn_start_anim_frame:
                mAnimTarget.setVisibility(View.VISIBLE);
                frameAnimation.start();
                break;
            case R.id.btn_end_anim_frame:
                frameAnimation.stop();
                break;
        }
    }
}
