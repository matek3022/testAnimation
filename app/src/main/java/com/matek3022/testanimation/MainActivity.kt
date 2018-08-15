package com.matek3022.testanimation

import android.content.Intent
import android.os.Bundle
import android.support.transition.Slide
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val root: RelativeLayout = findViewById(R.id.root)
        val lottieView: LottieAnimationView = findViewById(R.id.lottieView)
        val goButton: Button = findViewById(R.id.buttonGo)
        goButton.setOnClickListener {
            val slide = Slide(Gravity.RIGHT)
            slide.duration = 1000
            TransitionManager.beginDelayedTransition(root, slide)
            if (lottieView.visibility == View.GONE) {
                lottieView.visibility = View.VISIBLE
            } else lottieView.visibility = View.GONE
        }
        nextButton.setOnClickListener {
            startActivity(Intent(MainActivity@this, Main2Activity::class.java))
        }
    }
}
