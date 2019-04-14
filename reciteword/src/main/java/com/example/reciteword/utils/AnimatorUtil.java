package com.example.reciteword.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 * Created by android_home on 2018/8/24.
 */

public class AnimatorUtil {

    public static void setAnimator(final ImageView imageView, final float startAngle, final float endAngle, final long duration) {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", startAngle, endAngle);
        LinearInterpolator lin = new LinearInterpolator();
        animator.setInterpolator(lin);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setAnimator(imageView, startAngle, endAngle, duration);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(duration);
        animator.start();
    }

    public static void setFlickerAnimation(ImageView imageView) {
        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(800);//闪烁时间间隔
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        imageView.setAnimation(animation);
    }

}
