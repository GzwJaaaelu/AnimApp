package com.jaaaelu.gzw.animapp.anim;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationInterpolatorActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_interpolator_list)
    RecyclerView mInterpolatorView;
    private SparseArray<android.view.animation.Interpolator> mInterpolatorArray;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation_interpolator;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("Interpolator实现类效果展示");
        mInterpolatorView.setLayoutManager(new LinearLayoutManager(this));
        mInterpolatorView.setAdapter(new InterpolatorAdapter());
    }

    @Override
    protected void getData() {
        //  这里的下标没有写成常量只是下标而已
        mInterpolatorArray = new SparseArray<>();
        //  AccelerateDecelerateInterpolator变化率开始和结束缓慢，但加速通过中间
        mInterpolatorArray.append(0, new AccelerateDecelerateInterpolator());
        //  AccelerateInterpolator变化率开始缓慢，然后加速
        mInterpolatorArray.append(1, new AccelerateInterpolator());
        //  AnticipateInterpolator变化开始向后然后向前
        mInterpolatorArray.append(2, new AnticipateInterpolator());
        //  AnticipateOvershootInterpolator变化开始向后，然后向前和超过目标值，最后回到最终值
        mInterpolatorArray.append(3, new AnticipateOvershootInterpolator());
        //  有边界的插值器
        mInterpolatorArray.append(4, new BounceInterpolator());
        //  CycleInterpolator为了其手动设置周期
        mInterpolatorArray.append(5, new CycleInterpolator(5));
        //  DecelerateInterpolator变化率快速开始然后减速, 可手动设置Factor
        mInterpolatorArray.append(6, new DecelerateInterpolator(5f));
        //  贝塞尔相关
        mInterpolatorArray.append(7, new FastOutLinearInInterpolator());
        //  贝塞尔相关
        mInterpolatorArray.append(8, new FastOutSlowInInterpolator());
        //  LinearInterpolator变化率是恒定的
        mInterpolatorArray.append(9, new LinearInterpolator());
        //  贝塞尔相关
        mInterpolatorArray.append(10, new LinearOutSlowInInterpolator());
        //  可手动设置OvershootInterpolator张力值
        mInterpolatorArray.append(11, new OvershootInterpolator(3f));
        //  Create an Interpolator for a cubic Bezier curve. The end points (0, 0) and (1, 1) are assumed.
        mInterpolatorArray.append(12, new PathInterpolator(0, 0, 1, 1));
    }

    @Override
    protected void initListener() {

    }

    class InterpolatorHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_start_anim_by_interpolator)
        Button mStartAnimByInterpolatorBtn;
        @BindView(R.id.iv_anim_target)
        ImageView mAnimTarget;
        private Animation mAnimation;

        public InterpolatorHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mStartAnimByInterpolatorBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  点击按钮开始动画
                    mAnimTarget.startAnimation(mAnimation);
                }
            });
        }

        /**
         * 设置动画的插值器
         */
        public void setInterpolator() {
            mAnimation = new TranslateAnimation(0, 360, 0, 0);
            mAnimation.setInterpolator(mInterpolatorArray.get(getAdapterPosition()));
            mAnimation.setDuration(3000);
            mAnimation.setFillAfter(true);
            mStartAnimByInterpolatorBtn.setText(mInterpolatorArray.get(getAdapterPosition()).getClass().getSimpleName());
        }
    }

    class InterpolatorAdapter extends RecyclerView.Adapter<InterpolatorHolder> {

        @Override
        public InterpolatorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anim_interpolator, parent, false);
            return new InterpolatorHolder(view);
        }

        @Override
        public void onBindViewHolder(InterpolatorHolder holder, int position) {
            holder.setInterpolator();
        }

        @Override
        public int getItemCount() {
            return mInterpolatorArray.size();
        }
    }
}
