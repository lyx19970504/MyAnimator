package com.example.animationframework;

//关键帧，保存某一时刻的具体状态
public class MyFloatKeyFrame {

    float mFraction;
    Class mValueType;
    float mValue;

    public MyFloatKeyFrame(float fraction,float value){
        mFraction = fraction;
        mValue = value;
        mValueType = float.class;
    }

    public float getmFraction() {
        return mFraction;
    }

    public float getmValue() {
        return mValue;
    }

    public void setmValue(float mValue) {
        this.mValue = mValue;
    }
}
