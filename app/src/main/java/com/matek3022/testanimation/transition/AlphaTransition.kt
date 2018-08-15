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
class AlphaTransition: Transition() {

    private val PROPNAME_ALPHA = "alphaTransition:alpha"

    private fun captureValues(transitionValues: TransitionValues) {
        transitionValues.values[PROPNAME_ALPHA] = transitionValues.view.alpha
    }


    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(sceneRoot: ViewGroup, startValues: TransitionValues?, endValues: TransitionValues?): Animator? {
        if (startValues != null && endValues != null) {
            val start = startValues.values[PROPNAME_ALPHA] as Float
            val end = endValues.values[PROPNAME_ALPHA] as Float
            if (start != end) {
                endValues.view.alpha = start
                return ObjectAnimator.ofFloat(endValues.view, "alpha", start, end)
            }
        }
        return null
    }
}