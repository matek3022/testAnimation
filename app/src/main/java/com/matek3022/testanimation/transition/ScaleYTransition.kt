package com.matek3022.testanimation.transition

import android.animation.Animator
import android.animation.ObjectAnimator
import android.support.transition.Transition
import android.support.transition.TransitionValues
import android.view.ViewGroup

/**
 * @author matek3022 (semenovmm@altarix.ru)
 *         on 15.08.18.
 */
class ScaleYTransition: Transition() {

    private val PROPNAME_SCALE_Y = "scaleTransition:scaleY"

    private fun captureValues(transitionValues: TransitionValues) {
        transitionValues.values[PROPNAME_SCALE_Y] = transitionValues.view.scaleY
    }


    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(sceneRoot: ViewGroup, startValues: TransitionValues?, endValues: TransitionValues?): Animator? {
        if (startValues != null && endValues != null) {
            val start = startValues.values[PROPNAME_SCALE_Y] as Float
            val end = endValues.values[PROPNAME_SCALE_Y] as Float
            if (start != end) {
                endValues.view.scaleY = start
                return ObjectAnimator.ofFloat(endValues.view, "scaleY", start, end)
            }
        }
        return null
    }
}