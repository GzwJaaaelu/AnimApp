package com.jaaaelu.gzw.animapp.animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorOtherActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_start_animator_count_down)
    Button mStartAnimatorCountDownBtn;
    @BindView(R.id.btn_start_animator_calculator)
    Button mStartAnimatorCalculatorBtn;
    @BindView(R.id.btn_start_animator_key_frame)
    Button mStartAnimatorKeyFrameBtn;
    @BindView(R.id.tv_show_count_down)
    TextView mShowCountDown;
    @BindView(R.id.iv_animator_target)
    ImageView mAnimatorTarget;
    public static final int TRANS_X = 600;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator_other;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("属性动画的其他应用");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_start_animator_count_down, R.id.btn_start_animator_calculator, R.id.btn_start_animator_key_frame})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_animator_count_down:
                //  计时器的另一种实现方式 通过ValueAnimator的onAnimationUpdate获取当前时间的值
                ValueAnimator animator = ValueAnimator.ofInt(10, 0);
                animator.setDuration(10000);
                animator.start();
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mShowCountDown.setText("" + animation.getAnimatedValue());
                    }
                });
                break;
            case R.id.btn_start_animator_calculator:
                ValueAnimator valueAnimator = new ValueAnimator();
                float startX = mAnimatorTarget.getX();
                float startY = mAnimatorTarget.getY();
                valueAnimator.setDuration(2000);
                //  平移值改变了Y值
                valueAnimator.setObjectValues(new PointF(startX, startY), new PointF(startX + TRANS_X, startY));
                valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
                    @Override
                    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                        //  fraction 从0到1 表示时间轴
                        //  这里轨迹为y = -(1/150)x*x + 4x
                        PointF pointF = new PointF();
                        float d = fraction * TRANS_X;
                        pointF.x = startValue.x + d;
                        //  Android坐标相反
                        pointF.y = startValue.y + (1.0f / 150f) * d * d - 4 * d;
                        return pointF;
                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //  手动更新位置
                        PointF pointF = (PointF) animation.getAnimatedValue();
                        mAnimatorTarget.setX(pointF.x);
                        mAnimatorTarget.setY(pointF.y);
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_start_animator_key_frame:
                //  通过关键帧 设置时间轴0的时候为0度 时间轴一半的时候为360度 时间轴最后又回到0度
                Keyframe k1 = Keyframe.ofFloat(0f, 0f);
                Keyframe k2 = Keyframe.ofFloat(0.5f, 360f);
                Keyframe k3 = Keyframe.ofFloat(1f, 0f);
                //  通过PropertyValuesHolder配合时间轴设置旋转动画
                PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation", k1, k2, k3);
                //  配置动画
                ObjectAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(mAnimatorTarget, valuesHolder);
                rotation.setDuration(2000);
                rotation.start();
                break;
        }
    }
}
