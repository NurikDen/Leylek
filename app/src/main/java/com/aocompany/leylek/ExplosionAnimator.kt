package com.aocompany.leylek

import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Interpolator
import com.aocompany.leylek.Utils.dp2Px
import java.util.Random

class ExplosionAnimator(container: View, bitmap: Bitmap, bound: Rect?) : ValueAnimator() {
    private val mPaint: Paint
    private val mParticles: Array<Particle?>
    private val mBound: Rect
    private val mContainer: View

    init {
        mPaint = Paint()
        mBound = Rect(bound)
        val partLen = 15
        mParticles = arrayOfNulls(partLen * partLen)
        val random = Random(System.currentTimeMillis())
        val w = bitmap.width / (partLen + 2)
        val h = bitmap.height / (partLen + 2)
        for (i in 0 until partLen) {
            for (j in 0 until partLen) {
                mParticles[i * partLen + j] =
                    generateParticle(bitmap.getPixel((j + 1) * w, (i + 1) * h), random)
            }
        }
        mContainer = container
        setFloatValues(0f, END_VALUE)
        interpolator = DEFAULT_INTERPOLATOR
        duration = DEFAULT_DURATION
    }

    private fun generateParticle(color: Int, random: Random): Particle {
        val particle = Particle()
        particle.color = color
        particle.radius = V
        if (random.nextFloat() < 0.2f) {
            particle.baseRadius = V + (X - V) * random.nextFloat()
        } else {
            particle.baseRadius = W + (V - W) * random.nextFloat()
        }
        val nextFloat = random.nextFloat()
        particle.top = mBound.height() * (0.18f * random.nextFloat() + 0.2f)
        particle.top =
            if (nextFloat < 0.2f) particle.top else particle.top + particle.top * 0.2f * random.nextFloat()
        particle.bottom = mBound.height() * (random.nextFloat() - 0.5f) * 1.8f
        var f =
            if (nextFloat < 0.2f) particle.bottom else if (nextFloat < 0.8f) particle.bottom * 0.6f else particle.bottom * 0.3f
        particle.bottom = f
        particle.mag = 4.0f * particle.top / particle.bottom
        particle.neg = -particle.mag / particle.bottom
        f = mBound.centerX() + Y * (random.nextFloat() - 0.5f)
        particle.baseCx = f
        particle.cx = f
        f = mBound.centerY() + Y * (random.nextFloat() - 0.5f)
        particle.baseCy = f
        particle.cy = f
        particle.life = END_VALUE / 10 * random.nextFloat()
        particle.overflow = 0.4f * random.nextFloat()
        particle.alpha = 1f
        return particle
    }

    fun draw(canvas: Canvas): Boolean {
        if (!isStarted) {
            return false
        }
        for (particle in mParticles) {
            particle!!.advance(animatedValue as Float)
            if (particle.alpha > 0f) {
                mPaint.color = particle.color
                mPaint.alpha = (Color.alpha(particle.color) * particle.alpha).toInt()
                canvas.drawCircle(particle.cx, particle.cy, particle.radius, mPaint)
            }
        }
        mContainer.invalidate()
        return true
    }

    override fun start() {
        super.start()
        mContainer.invalidate(mBound)
    }

    private inner class Particle {
        var alpha = 0f
        var color = 0
        var cx = 0f
        var cy = 0f
        var radius = 0f
        var baseCx = 0f
        var baseCy = 0f
        var baseRadius = 0f
        var top = 0f
        var bottom = 0f
        var mag = 0f
        var neg = 0f
        var life = 0f
        var overflow = 0f
        fun advance(factor: Float) {
            var f = 0f
            var normalization = factor / END_VALUE
            if (normalization < life || normalization > 1f - overflow) {
                alpha = 0f
                return
            }
            normalization = (normalization - life) / (1f - life - overflow)
            val f2 = normalization * END_VALUE
            if (normalization >= 0.7f) {
                f = (normalization - 0.7f) / 0.3f
            }
            alpha = 1f - f
            f = bottom * f2
            cx = baseCx + f
            cy = (baseCy - neg * Math.pow(f.toDouble(), 2.0)).toFloat() - f * mag
            radius = V + (baseRadius - V) * f2
        }
    }

    companion object {
        @JvmField
        var DEFAULT_DURATION: Long = 0x400
        private val DEFAULT_INTERPOLATOR: Interpolator = AccelerateInterpolator(0.6f)
        private const val END_VALUE = 1.4f
        private val X = dp2Px(5).toFloat()
        private val Y = dp2Px(20).toFloat()
        private val V = dp2Px(2).toFloat()
        private val W = dp2Px(1).toFloat()
    }
}