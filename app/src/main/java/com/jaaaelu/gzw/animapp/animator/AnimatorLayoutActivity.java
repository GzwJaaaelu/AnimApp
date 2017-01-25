package com.jaaaelu.gzw.animapp.animator;

import android.animation.LayoutTransition;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorLayoutActivity extends BaseActivity {
    @BindView(R.id.btn_add_view)
    Button mAddViewBtn;
    @BindView(R.id.activity_animator_layout)
    LinearLayout mAnimatorLayoutRoot;
    private int count = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator_layout;
    }

    @Override
    protected void initView() {
        mAnimatorLayoutRoot.setLayoutTransition(getLayoutTransition());
    }

    @Override
    protected void initListener() {

    }

    private LayoutTransition getLayoutTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(LayoutTransition.APPEARING, layoutTransition.getAnimator(LayoutTransition.APPEARING));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, layoutTransition.getAnimator(LayoutTransition.CHANGE_APPEARING));
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, layoutTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING));
        layoutTransition.setAnimator(LayoutTransition.CHANGING, layoutTransition.getAnimator(LayoutTransition.CHANGING));
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, layoutTransition.getAnimator(LayoutTransition.DISAPPEARING));
        return layoutTransition;
    }

    @OnClick(R.id.btn_add_view)
    public void onClick() {
        final Button button = new Button(this);
        button.setBackground(getResources().getDrawable(R.drawable.btn_with_ripple));
        button.setTextColor(Color.WHITE);
        button.setText("Button = " + count++ + "  Click to disappear");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 32, 0, 0);
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimatorLayoutRoot.removeView(button);
            }
        });
        mAnimatorLayoutRoot.addView(button);
    }

}
