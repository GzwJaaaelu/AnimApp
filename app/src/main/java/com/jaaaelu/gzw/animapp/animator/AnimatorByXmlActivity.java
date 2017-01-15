package com.jaaaelu.gzw.animapp.animator;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;
import com.jaaaelu.gzw.animapp.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimatorByXmlActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_anim_target)
    ImageView mAnimTarget;
    @BindView(R.id.btn_start_anim_alpha)
    Button mStartAnimAlphaBtn;
    @BindView(R.id.btn_start_anim_translation)
    Button mStartAnimTranslationBtn;
    @BindView(R.id.btn_start_anim_scale)
    Button mStartAnimScaleBtn;
    @BindView(R.id.btn_start_anim_rotate)
    Button mStartAnimRotateBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("通过xml实现视图动画");
    }

    @Override
    protected void initListener() {
    }

    @OnClick({R.id.iv_anim_target, R.id.btn_start_anim_alpha, R.id.btn_start_anim_translation, R.id.btn_start_anim_scale, R.id.btn_start_anim_rotate})
    public void onClick(View view) {
        Animation animation = null;
        switch (view.getId()) {
            case R.id.iv_anim_target:
                ToastUtil.showShortToast("点击了图片");
                return;
            case R.id.btn_start_anim_alpha:
                //  AnimationUtil通过AnimationUtils的加载xml动画
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                break;
            case R.id.btn_start_anim_translation:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                break;
            case R.id.btn_start_anim_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                break;
            case R.id.btn_start_anim_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                break;
        }
        mAnimTarget.startAnimation(animation);
    }
}
