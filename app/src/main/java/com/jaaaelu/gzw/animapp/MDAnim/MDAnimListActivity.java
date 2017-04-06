package com.jaaaelu.gzw.animapp.MDAnim;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jaaaelu.gzw.animapp.R;
import com.jaaaelu.gzw.animapp.animator.AnimatorLayoutActivity;
import com.jaaaelu.gzw.animapp.animator.AnimatorOtherActivity;
import com.jaaaelu.gzw.animapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MDAnimListActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn_md_anim_feedback)
    Button mMdAnimFeedbackBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_md_anim_list;
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("Material Design Animation");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_md_anim_feedback, R.id.btn_md_reveal_effect, R.id.btn_md_path_anim})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_md_anim_feedback:
                startActivity(new Intent(this, RippleActivity.class));
                break;
            case R.id.btn_md_reveal_effect:
                startActivity(new Intent(this, RevealEffectActivity.class));
                break;
            case R.id.btn_md_path_anim:
                startActivity(new Intent(this, PathAnimationActivity.class));
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
