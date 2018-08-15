package com.matek3022.testanimation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.transition.TransitionSet
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import com.matek3022.testanimation.transition.RotateTransition
import com.matek3022.testanimation.transition.ScaleXTransition
import com.matek3022.testanimation.transition.ScaleYTransition
import com.yy.mobile.rollingtextview.CharOrder
import com.yy.mobile.rollingtextview.strategy.Direction
import com.yy.mobile.rollingtextview.strategy.Strategy
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val transitionSet = TransitionSet()
        agIcon.rotation = -90f
        transitionSet.ordering = TransitionSet.ORDERING_TOGETHER
        transitionSet.addTransition(RotateTransition())
        transitionSet.addTransition(ScaleXTransition())
        transitionSet.addTransition(ScaleYTransition())
        var animationEnd = true

        rollingText.addCharOrder(CharOrder.Number)
        rollingText.animationDuration = 2000L
        rollingText.charStrategy = Strategy.SameDirectionAnimation(Direction.SCROLL_DOWN)
        rollingText.animationInterpolator = AccelerateDecelerateInterpolator()
        rollingText.addAnimatorListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                animationEnd = true
            }
        })

        val random = Random(10000000L)
        somethingButton.setOnClickListener {
            if (animationEnd) {
                rollingText.setText(random.nextInt().toString(), true)
                animationEnd = false
            }
            if (agIcon.rotation == -90f) {
                TransitionManager.beginDelayedTransition(root, transitionSet)
                agIcon.rotation = 0f
                agIcon.scaleX = 2f
                agIcon.scaleY = 2f
            } else if (agIcon.rotation == 0f) {
                TransitionManager.beginDelayedTransition(root, transitionSet)
                agIcon.rotation = -90f
                agIcon.scaleX = 1f
                agIcon.scaleY = 1f
            }
        }
    }

}
