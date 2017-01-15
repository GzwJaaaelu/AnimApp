package com.jaaaelu.gzw.animapp.animator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.WrapperView;
import com.jaaaelu.gzw.animapp.base.BaseActivity;
import com.jaaaelu.gzw.animapp.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorByCodeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_animator_target)
    ImageView mAnimatorTarget;
    @BindView(R.id.btn_start_animator_add_property)
    Button mStartAnimatorAddPropertyBtn;
    @BindView(R.id.btn_start_animator_alpha)
    Button mStartAnimatorAlphaBtn;
    @BindView(R.id.btn_start_animator_translation)
    Button mStartAnimatorTranslationBtn;
    @BindView(R.id.btn_start_animator_scale)
    Button mStartAnimatorScaleBtn;
    @BindView(R.id.btn_start_animator_rotate)
    Button mStartAnimatorRotateBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("通过Java代码实现属性动画");
    }

    @Override
    protected void initListener() {
    }

    @OnClick({R.id.iv_animator_target, R.id.btn_start_animator_add_property, R.id.btn_start_animator_alpha, R.id.btn_start_animator_translation, R.id.btn_start_animator_scale, R.id.btn_start_animator_rotate})
    public void onClick(View view) {
        ObjectAnimator animator = null;
        switch (view.getId()) {
            case R.id.iv_animator_target:
                ToastUtil.showShortToast("点击了图片");
                return;
            case R.id.btn_start_animator_add_property:
                //  这里自己设置了一个类并添加了自定义的属性
                WrapperView wrapperView = new WrapperView(mAnimatorTarget);
                animator = ObjectAnimator.ofFloat(wrapperView, "scale", 1, 3);
                break;
            case R.id.btn_start_animator_alpha:
                //  这些propertyName千万不要敲错了 可以不用记 可以去View类中去找对应的setXXX()
                //  setAlpha()
                animator = ObjectAnimator.ofFloat(mAnimatorTarget, "alpha", 1, 0);
                break;
            case R.id.btn_start_animator_translation:
                //  如果只设置一个值表示该值为终止值
                //  setTranslationX()
                animator = ObjectAnimator.ofFloat(mAnimatorTarget, "translationX", 200);
                break;
            case R.id.btn_start_animator_scale:
                //  setScaleX()
                //  setScaleY()
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(mAnimatorTarget, "scaleX", 1, 2);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(mAnimatorTarget, "scaleY", 1, 2);
                scaleX.setDuration(1800);
                scaleX.start();
                scaleY.setDuration(1800);
                scaleY.start();
                return;
            case R.id.btn_start_animator_rotate:
                //  setRotation()
                animator = ObjectAnimator.ofFloat(mAnimatorTarget, "rotation", 0, 180);
                break;
        }
        animator.setDuration(1800);
        animator.start();
    }
}
