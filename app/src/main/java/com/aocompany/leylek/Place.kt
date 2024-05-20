package com.aocompany.leylek

import android.widget.ImageView

class Place(private val placeView: ImageView, private var placeText: String, private var placeIsEmpty: Boolean) {
    fun get_placeView():ImageView{
        return placeView
    }
    fun get_placeText():String{
        return placeText
    }
    fun get_placeIsEmpty():Boolean{
        return placeIsEmpty
    }
    fun set_placeText(placeText: String){
        this.placeText = placeText
    }
    fun set_placeIsEmpty(placeIsEmpty: Boolean){
        this.placeIsEmpty = placeIsEmpty
    }
}