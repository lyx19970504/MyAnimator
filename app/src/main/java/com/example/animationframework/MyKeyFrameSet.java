package com.example.animationframework;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyKeyFrameSet {

    TypeEvaluator mEvaluator;
    private List<MyFloatKeyFrame> mKeyFrames;
    private MyFloatKeyFrame mFirstKeyFrame;

    public static MyKeyFrameSet ofFloat(float... values){
        int numKeyFrames = values.length;
        MyFloatKeyFrame[] keyframes = new MyFloatKeyFrame[numKeyFrames];
        keyframes[0] = new MyFloatKeyFrame(0,values[0]);
        for (int i=1;i<keyframes.length;++i){
            keyframes[i] = new MyFloatKeyFrame((float) i / (numKeyFrames - 1),values[i]);
        }
        return new MyKeyFrameSet(keyframes);
    }

    public MyKeyFrameSet(MyFloatKeyFrame... values){
        mKeyFrames = Arrays.asList(values);
        mFirstKeyFrame = values[0];
        mEvaluator = new FloatEvaluator();
    }

    public Object getValue(float fraction){
        MyFloatKeyFrame prevKeyFrame = mFirstKeyFrame;
        for (int i = 1; i<mKeyFrames.size();i++){
            MyFloatKeyFrame nextKeyFrame = mKeyFrames.get(i);
            if(fraction < nextKeyFrame.getmFraction()){
                return mEvaluator.evaluate(fraction,prevKeyFrame.getmValue(),nextKeyFrame.getmValue());
            }
            prevKeyFrame = nextKeyFrame;
        }
        return null;
    }
}
