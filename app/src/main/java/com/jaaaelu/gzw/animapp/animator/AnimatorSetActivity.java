package com.jaaaelu.gzw.animapp.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;
import com.jaaaelu.gzw.animapp.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_animator_target)
    ImageView mAnimatorTarget;
    @BindView(R.id.btn_start_animator_set)
    Button mStartAnimatorSet;
    @BindView(R.id.btn_start_animator_parallel_one)
    Button mStartAnimatorParallelOneBtn;
    @BindView(R.id.btn_start_animator_parallel_two)
    Button mStartAnimatorParallelTwoBtn;
    @BindView(R.id.btn_start_animator_parallel_three)
    Button mStartAnimatorParallelThreeBtn;
    @BindView(R.id.btn_start_animator_serial)
    Button mStartAnimatorSerialBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator_set;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.iv_animator_target, R.id.btn_start_animator_set, R.id.btn_start_animator_parallel_one, R.id.btn_start_animator_parallel_two, R.id.btn_start_animator_parallel_three, R.id.btn_start_animator_serial})
    public void onClick(View view) {
        ObjectAnimator alpha = null;
        ObjectAnimator translationX = null;
        ObjectAnimator translationY = null;
        ObjectAnimator rotate = null;
        ObjectAnimator scaleX = null;
        ObjectAnimator scaleY = null;
        AnimatorSet set;
        switch (view.getId()) {
            case R.id.iv_animator_target:
                ToastUtil.showShortToast("点击了图片");
                return;
            case R.id.btn_start_animator_set:
                //  组合 先平移然后再同时执行渐变 缩放 旋转
                rotate = rotate.ofFloat(mAnimatorTarget, "rotation", 0, -45).setDuration(1800);
                alpha = alpha.ofFloat(mAnimatorTarget, "alpha", 1, 0).setDuration(1800);
                scaleY = scaleY.ofFloat(mAnimatorTarget, "scaleY", 1, 2).setDuration(1800);
                scaleX = scaleX.ofFloat(mAnimatorTarget, "scaleX", 1, 2).setDuration(1800);
                translationX = translationX.ofFloat(mAnimatorTarget, "translationX", 0, -200).setDuration(1800);
                translationY = translationY.ofFloat(mAnimatorTarget, "translationY", 0, -200).setDuration(1800);
                set = new AnimatorSet();
                //  with表示同时执行
                set.play(alpha).with(scaleX).with(scaleY).with(rotate).with(translationX);
                //  在alpha之前执行translationY
                set.play(translationY).before(alpha);
                set.start();
                break;
            case R.id.btn_start_animator_parallel_one:
                //  并行方式1  多个ObjectAnimator
                rotate = rotate.ofFloat(mAnimatorTarget, "rotation", 0, 360).setDuration(1800);
                scaleX = scaleX.ofFloat(mAnimatorTarget, "scaleX", 1, 2).setDuration(1800);
                scaleY = scaleY.ofFloat(mAnimatorTarget, "scaleY", 1, 2).setDuration(1800);
                //  这里面也可以调用三次start()
//                rotate.start();
//                scaleX.start();
//                scaleY.start();
                //  or AnimatorSet的playTogether就可以了
                set = new AnimatorSet();
                set.playTogether(rotate, scaleX, scaleY);
                //  可以把上面的三个setDuration()去掉
//                set.setDuration(1800);
                set.start();
                break;
            case R.id.btn_start_animator_parallel_two:
                //  并行方式2  一个ObjectAnimator 配合多个PropertyValuesHolder
                PropertyValuesHolder rotateProperty = PropertyValuesHolder.ofFloat("rotation", 0, 360);
                PropertyValuesHolder scaleXProperty = PropertyValuesHolder.ofFloat("scaleX", 1, 2);
                PropertyValuesHolder scaleYProperty = PropertyValuesHolder.ofFloat("scaleY", 1, 2);
                alpha = ObjectAnimator.ofPropertyValuesHolder(mAnimatorTarget, rotateProperty, scaleXProperty, scaleYProperty);
                alpha.setDuration(1800);
                alpha.start();
                break;
            case R.id.btn_start_animator_parallel_three:
                //  并行方式3 ViewPropertyAnimator实现 ...炒鸡简单
                //  这里没有设置初始值, 但如果执行完并行1或者并行2 它发现现在的状态已经是下面 的状态了  所以就不会再执行了
                mAnimatorTarget.animate().rotation(360).scaleX(2).scaleY(2).setDuration(1800).start();
                break;
            case R.id.btn_start_animator_serial:
                //  串行
                rotate = rotate.ofFloat(mAnimatorTarget, "rotation", 0, 360);
                scaleX = scaleX.ofFloat(mAnimatorTarget, "scaleX", 1, 2);
                scaleY = scaleY.ofFloat(mAnimatorTarget, "scaleY", 1, 2);
                //  这两种都可以 一个是设置延迟时间, 一个是AnimatorSet
//                rotate.setDuration(1800);
//                rotate.start();
//                scaleX.setDuration(1800);
//                scaleX.setStartDelay(1800);
//                scaleX.start();
//                scaleY.setDuration(1800);
//                scaleY.setStartDelay(3600);
//                scaleY.start();
                set = new AnimatorSet();
                set.playSequentially(rotate, scaleX, scaleY);
                set.setDuration(1800);
                set.start();
                break;
        }
    }
}
