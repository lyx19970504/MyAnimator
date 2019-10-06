package com.example.animationframework;

import android.view.View;

import java.lang.ref.WeakReference;

public class MyObjectAnimator implements VSYNCManager.AnimationFrameCallback {

    private WeakReference<View> target;
    private MyFloatPropertyValuesHolder holder;
    private int mDuration;
    private float index = 0;
    private TimeInterpolator mInterpolator;

    public void setDuration(int duration){
        mDuration = duration;
    }

    public void setInterpolator(TimeInterpolator interpolator){
        mInterpolator = interpolator;
    }


    public static MyObjectAnimator ofFloat(View view, String propertyName,float... values){
        return new MyObjectAnimator(view,propertyName,values);
    }

    private MyObjectAnimator(View view, String propertyName,float... values){
        target = new WeakReference<>(view);
        holder = new MyFloatPropertyValuesHolder(propertyName,values);
    }

    public void start(){
        holder.setupSetter();
        VSYNCManager.getInstance().add(this);
    }

    //每隔16ms回调
    @Override
    public void doAnimationFrame() {
        float total = mDuration / 16f;       //一共多少次
        float fraction = (index++) / total;
        if(mInterpolator != null){
            fraction = mInterpolator.getInterpolation(fraction);   //加入差值器
        }
        if(index >= total){
            index = 0;
        }
        holder.setAnimatedValue(target.get(),fraction);
    }
}
