package com.aocompany.leylek

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Result_celebrity(private val constraintLayout: ConstraintLayout, private val imageView: ImageView, private val textView: TextView, private val infoView: ImageView) {
    fun get_constraintLayout(): ConstraintLayout{
        return constraintLayout
    }
    fun get_imageView(): ImageView {
        return imageView
    }
    fun get_textView(): TextView {
        return textView
    }
    fun get_infoView(): ImageView {
        return infoView
    }
}