package com.example.animationframework;

import android.view.View;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFloatPropertyValuesHolder {

    private String mPropertyName;
    private MyKeyFrameSet mMyKeyFrameSet;
    private Method mSetter = null;      //方法

    public MyFloatPropertyValuesHolder(String propertyName,float... values){
        mPropertyName = propertyName;
        mMyKeyFrameSet = MyKeyFrameSet.ofFloat(values);
    }

    public void setupSetter(){
        char firstLetter = Character.toUpperCase(mPropertyName.charAt(0));
        String theRest = mPropertyName.substring(1);
        String methodName = "set" + firstLetter + theRest;
        try {
            mSetter = View.class.getMethod(methodName,float.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void setAnimatedValue(View view,float fraction){
        Object value = mMyKeyFrameSet.getValue(fraction);
        try {
            mSetter.invoke(view,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
