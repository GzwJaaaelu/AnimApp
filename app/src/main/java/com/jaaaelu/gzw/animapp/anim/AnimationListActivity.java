package com.jaaaelu.gzw.animapp.anim;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.anim.AnimationByCodeActivity;
import com.jaaaelu.gzw.animapp.anim.AnimationByXmlActivity;
import com.jaaaelu.gzw.animapp.anim.AnimationFlyActivity;
import com.jaaaelu.gzw.animapp.anim.AnimationFrameActivity;
import com.jaaaelu.gzw.animapp.anim.AnimationInterpolatorActivity;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimationListActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_anim_demo_by_xml)
    Button mAnimDemoByXmlBtn;
    @BindView(R.id.btn_anim_demo_by_java)
    Button mAnimDemoByJavaBtn;
    @BindView(R.id.btn_anim_fly)
    Button mAnimSetFlyBtn;
    @BindView(R.id.btn_anim_interpolator)
    Button mAnimInterpolatorBtn;
    @BindView(R.id.btn_anim_frame)
    Button mAnimFrame;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation_list;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("视同动画启动列表");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_anim_demo_by_xml, R.id.btn_anim_demo_by_java, R.id.btn_anim_fly, R.id.btn_anim_interpolator, R.id.btn_anim_frame})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_anim_demo_by_xml:
                startActivity(new Intent(this, AnimationByXmlActivity.class));
                break;
            case R.id.btn_anim_demo_by_java:
                startActivity(new Intent(this, AnimationByCodeActivity.class));
                break;
            case R.id.btn_anim_fly:
                startActivity(new Intent(this, AnimationFlyActivity.class));
                break;
            case R.id.btn_anim_interpolator:
                startActivity(new Intent(this, AnimationInterpolatorActivity.class));
                break;
            case R.id.btn_anim_frame:
                startActivity(new Intent(this, AnimationFrameActivity.class));
                break;
        }
    }
}
