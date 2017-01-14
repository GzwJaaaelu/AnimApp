package com.jaaaelu.gzw.animapp.anim;

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
import com.jaaaelu.gzw.animapp.util.ToastUtil;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimationByCodeActivity extends BaseActivity {
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
        mToolbar.setTitle("通过Java代码实现视图动画, 动画结束停留在该位置");
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
                animation = new AlphaAnimation(1, 0);
                break;
            case R.id.btn_start_anim_translation:
                animation = new TranslateAnimation(0, 0, 0, 200);
                break;
            case R.id.btn_start_anim_scale:
                //  RELATIVE_TO_SELF 0.5 以自己为中心点开始缩放
                animation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                break;
            case R.id.btn_start_anim_rotate:
                //  RELATIVE_TO_SELF 0.5 以自己为中心点开始旋转
                animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                break;
        }
        //  动画持续
        animation.setDuration(2000);
        //  动画结束就停在那个位置 但实际的控件位置没变
        animation.setFillAfter(true);
        mAnimTarget.startAnimation(animation);
    }
}
