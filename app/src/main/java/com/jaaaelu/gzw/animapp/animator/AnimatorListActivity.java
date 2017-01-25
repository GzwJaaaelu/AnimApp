package com.jaaaelu.gzw.animapp.animator;

import android.content.Intent;
import android.os.Bundle;
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
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorListActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_animator_by_xml)
    Button mAnimatorByXmlBtn;
    @BindView(R.id.btn_animator_by_java)
    Button mAnimatorByJavaBtn;
    @BindView(R.id.btn_animator_set)
    Button mAnimatorSetBtn;
    @BindView(R.id.btn_animator_other)
    Button mAnimatorOtherBtn;
    @BindView(R.id.btn_animator_layout)
    Button mAnimatorLayoutBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animator_list;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("属性动画启动列表");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_animator_by_xml, R.id.btn_animator_by_java, R.id.btn_animator_set, R.id.btn_animator_other, R.id.btn_animator_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_animator_by_xml:
                break;
            case R.id.btn_animator_by_java:
                startActivity(new Intent(this, AnimatorByCodeActivity.class));
                break;
            case R.id.btn_animator_set:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
            case R.id.btn_animator_other:
                startActivity(new Intent(this, AnimatorOtherActivity.class));
                break;
            case R.id.btn_animator_layout:
                startActivity(new Intent(this, AnimatorLayoutActivity.class));
                break;
        }
    }
}
