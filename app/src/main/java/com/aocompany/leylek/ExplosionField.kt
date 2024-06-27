package com.aocompany.leylek

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.aocompany.leylek.Utils.createBitmapFromView
import com.aocompany.leylek.Utils.dp2Px
import java.util.Arrays
import java.util.Random

class ExplosionField : View {
    private val mExplosions: MutableList<ExplosionAnimator> = ArrayList()
    private val mExpandInset = IntArray(2)

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        Arrays.fill(mExpandInset, dp2Px(32))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (explosion in mExplosions) {
            explosion.draw(canvas)
        }
    }

    fun expandExplosionBound(dx: Int, dy: Int) {
        mExpandInset[0] = dx
        mExpandInset[1] = dy
    }

    fun explode(bitmap: Bitmap?, bound: Rect?, startDelay: Long, duration: Long) {
        val explosion = ExplosionAnimator(this, bitmap!!, bound)
        explosion.startDelay = startDelay
        explosion.duration = duration
        mExplosions.add(explosion)
        explosion.start()
    }

    fun explode(view: View) {
        val r = Rect()
        view.getGlobalVisibleRect(r)
        val location = IntArray(2)
        getLocationOnScreen(location)
        r.offset(-location[0], -location[1])
        r.inset(-mExpandInset[0], -mExpandInset[1])
        val startDelay = 100
        val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(150)
        animator.start()
        explode(
            createBitmapFromView(view),
            r,
            startDelay.toLong(),
            ExplosionAnimator.DEFAULT_DURATION
        )
    }
    companion object {
        fun attach2Window(activity: Activity): ExplosionField {
            val rootView = activity.findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
            val explosionField = ExplosionField(activity)
            rootView.addView(
                explosionField, ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
            return explosionField
        }
    }
}