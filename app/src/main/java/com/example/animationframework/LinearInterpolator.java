package com.example.animationframework;

public class LinearInterpolator implements TimeInterpolator{
    @Override
    public float getInterpolation(float input) {
        return input;
    }
}
