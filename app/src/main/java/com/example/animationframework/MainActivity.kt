package com.example.animationframework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animator = MyObjectAnimator.ofFloat(button,"scaleX",1f,2f)
        animator.setDuration(3000)
        animator.setInterpolator(LinearInterpolator())
        animator.start()
    }
}
