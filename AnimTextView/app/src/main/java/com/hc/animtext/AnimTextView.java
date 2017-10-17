package com.hc.animtext;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by liu_lei on 2017/10/16.
 * 数字变化的文本
 */

public class AnimTextView extends AppCompatTextView {

    private static final int DEFAULT_VALUE = 50;
    private static final int DEFAULT_DURATION = 1500;
    private static final boolean DEFAULT_IS_SHOW_ANIM = true;

    public AnimTextView(Context context) {
        this(context, null);
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AnimTextView, 0, defStyleAttr);

        int value = a.getInteger(R.styleable.AnimTextView_animValue, DEFAULT_VALUE);
        int duration = a.getInteger(R.styleable.AnimTextView_duration, DEFAULT_DURATION);    // 动画时长
        boolean isShowAnim = a.getBoolean(R.styleable.AnimTextView_showAnim, DEFAULT_IS_SHOW_ANIM);    // 是否显示动画

        a.recycle();

        if (isShowAnim) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(0, value);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int value = (int) valueAnimator.getAnimatedValue();
                    AnimTextView.this.setText(String.valueOf((value)));
                }
            });
            valueAnimator.setDuration(duration);
            valueAnimator.start();
        } else {
            AnimTextView.this.setText(String.valueOf((value)));
        }
    }

}
