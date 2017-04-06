package com.jaaaelu.gzw.animapp.MDAnim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.GridLayout;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;

public class RevealEffectActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.red_box)
    View mRedBox;
    @BindView(R.id.green_box)
    View mGreenBox;
    @BindView(R.id.blue_box)
    View mBlueBox;
    @BindView(R.id.purple_box)
    View mPurpleBox;
    @BindView(R.id.box_container)
    GridLayout mBoxContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reveal_effect;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("揭露效果");
    }

    @Override
    protected void initListener() {
        mBoxContainer.setOnClickListener(this);
        mRedBox.setOnClickListener(this);
        mBlueBox.setOnClickListener(this);
        mGreenBox.setOnClickListener(this);
        mPurpleBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_box:
                TransitionManager.beginDelayedTransition(mBoxContainer, new Fade());
                toggleVisibility(mRedBox, mGreenBox, mBlueBox, mPurpleBox);
                break;
            case R.id.green_box:
                TransitionManager.beginDelayedTransition(mBoxContainer, new Slide());
                toggleVisibility(mRedBox, mGreenBox, mBlueBox, mPurpleBox);
                break;
            case R.id.blue_box:
                TransitionManager.beginDelayedTransition(mBoxContainer, new Explode());
                toggleVisibility(mRedBox, mGreenBox, mBlueBox, mPurpleBox);
                break;
            case R.id.purple_box:
                circularHideBoxes(mRedBox, mGreenBox, mBlueBox, mPurpleBox);
                break;
            case R.id.box_container:
                if (mRedBox.getVisibility() == View.INVISIBLE) {
                    circularRevealBoxes(mRedBox, mGreenBox, mBlueBox, mPurpleBox);
                }
                break;
        }
    }

    /**
     * 隐藏色块们
     * @param views
     */
    private void circularHideBoxes(View... views) {
        for (View view : views) {
            circularHideBox(view);
        }
    }

    /**
     * 显示色块们
     * @param views
     */
    private void circularRevealBoxes(View... views) {
        for (View view : views) {
            circularRevealBox(view);
        }
    }

    /**
     * 显示的开关
     * @param views
     */
    private void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
    }

    /**
     * 隐藏单个色块
     * @param view
     */
    private static void circularHideBox(View view) {
        int startRadius = view.getWidth();
        circularReveal(view, startRadius, 0, true);
    }


    /**
     * 显示单个色块
     * @param view
     */
    private void circularRevealBox(View view) {
        int endRadius = view.getWidth();
        circularReveal(view, 0, endRadius, false);
    }

    /**
     * 揭露效果调用
     * @param view
     * @param startRadius
     * @param endRadius
     * @param isHide
     */
    private static void circularReveal(final View view, float startRadius, float endRadius, boolean isHide) {
        // get the center for the clipping circle
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        int cx = rect.left + rect.width() / 2;
        int cy = rect.top + rect.height() / 2;

        // create the animation (the final radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, startRadius, endRadius);
        anim.setDuration(1000);
        // start the animation
        anim.start();

        if (isHide) {
            // make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }
}
