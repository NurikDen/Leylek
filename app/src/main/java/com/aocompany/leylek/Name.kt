package com.aocompany.leylek

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Name(private val constraintLayout: ConstraintLayout, private val imageView: ImageView, private val textView: ImageView, private var isNameRunning: Boolean,private var placeCount_x: Float, private var placeCount_y: Float, private var nameDestination_x: Float, private var nameDestination_y: Float, private var name_textDestination_x: Float, private var name_textDestination_y: Float,private var count:Int) {
    fun get_constraintLayout(): ConstraintLayout{
        return constraintLayout
    }
    fun get_imageView(): ImageView {
        return imageView
    }
    fun get_textView(): ImageView {
        return textView
    }
    fun get_isNameRunning(): Boolean {
        return isNameRunning
    }
    fun get_nameDestination_x(): Float{
        return nameDestination_x
    }
    fun get_nameDestination_y(): Float{
        return nameDestination_y
    }
    fun get_name_textDestination_x(): Float{
        return name_textDestination_x
    }
    fun get_name_textDestination_y(): Float{
        return name_textDestination_y
    }
    fun get_count(): Int {
        return count
    }
    fun get_placeCount_x(): Float{
        return placeCount_x
    }
    fun get_placeCount_y(): Float{
        return placeCount_y
    }
    fun set_placeCount_x(placeCount_x: Float){
        this.placeCount_x = placeCount_x
    }
    fun set_placeCount_y(placeCount_y: Float){
        this.placeCount_y = placeCount_y
    }
    fun set_isNameRunning(isNameRunning:Boolean){
        this.isNameRunning = isNameRunning
    }
    fun set_nameDestination_x(nameDestination_x: Float){
        this.nameDestination_x = nameDestination_x
    }
    fun set_nameDestination_y(nameDestination_y: Float){
        this.nameDestination_y = nameDestination_y
    }
    fun set_name_textDestination_x(name_textDestination_x:Float){
        this.name_textDestination_x = name_textDestination_x
    }
    fun set_name_textDestination_y(name_textDestination_y:Float){
        this.name_textDestination_y = name_textDestination_y
    }
    fun set_count(count:Int){
        this.count = count
    }
}