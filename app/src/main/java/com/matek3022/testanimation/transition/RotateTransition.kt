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
class RotateTransition: Transition() {

    private val PROPNAME_ROTATE = "rotateTransition:rotation"

    private fun captureValues(transitionValues: TransitionValues) {
        transitionValues.values[PROPNAME_ROTATE] = transitionValues.view.rotation
    }


    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun createAnimator(sceneRoot: ViewGroup, startValues: TransitionValues?, endValues: TransitionValues?): Animator? {
        if (startValues != null && endValues != null) {
            val startRotate = startValues.values[PROPNAME_ROTATE] as Float
            val endRotate = endValues.values[PROPNAME_ROTATE] as Float
            if (startRotate != endRotate) {
                endValues.view.rotation = startRotate
                return ObjectAnimator.ofFloat(endValues.view, "rotation", startRotate, endRotate)
            }
        }
        return null
    }
}