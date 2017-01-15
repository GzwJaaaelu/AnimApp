package com.jaaaelu.gzw.animapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by admin on 2017/1/15.
 */

public class WrapperView {
    private ImageView mTarget;
    private float scale;

    public WrapperView(ImageView target) {
        mTarget = target;
    }

    public void setScale(float scale) {
        this.scale = scale;
        mTarget.setScaleX(scale);
        mTarget.setScaleY(scale);
    }
}
