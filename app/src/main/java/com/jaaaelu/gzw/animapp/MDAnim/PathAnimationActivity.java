package com.jaaaelu.gzw.animapp.MDAnim;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;

public class PathAnimationActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.iv_path_anim_target)
    ImageView mPathAnimTarget;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_path_animation;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("曲线运动");
    }

    @Override
    protected void initListener() {
        mPathAnimTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPathAnim();
            }
        });
    }

    private void startPathAnim() {
        Path path = new Path();
        //path.moveTo(0, 100);
        path.lineTo(200, 700);
        path.cubicTo(200, 200, 300, 200, 400, 700);
        path.cubicTo(500, 400, 550, 400, 700, 700);

        PathInterpolator pathInterpolator = new PathInterpolator(0.8f, 0f, 1f, 1f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mPathAnimTarget, View.X, View.Y, path);
        animator.setInterpolator(pathInterpolator);
        animator.setDuration(3000);
        animator.start();
    }
}
