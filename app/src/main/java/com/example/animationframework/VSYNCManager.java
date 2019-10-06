package com.example.animationframework;

import java.util.ArrayList;
import java.util.List;

public class VSYNCManager {

    private static final VSYNCManager manager = new VSYNCManager();
    private List<AnimationFrameCallback> callbacks = new ArrayList<>();

    public static VSYNCManager getInstance(){
        return manager;
    }

    public VSYNCManager(){
        new Thread(runnable).start();
    }

    public void add(AnimationFrameCallback callback){
        callbacks.add(callback);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (AnimationFrameCallback callback : callbacks){
                    callback.doAnimationFrame();
                }
            }
        }
    };

    interface AnimationFrameCallback{
        void doAnimationFrame();
    }
}
