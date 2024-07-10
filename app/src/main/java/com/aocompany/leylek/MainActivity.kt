package com.aocompany.leylek
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilderFactory


open class MainActivity : AppCompatActivity() {
    private var mExplosionField: ExplosionField? = null
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ConstraintLayout>(R.id.button)
        val name = findViewById<TextView>(R.id.name)
        val meaning = findViewById<TextView>(R.id.meaning)
        val result = findViewById<ImageView>(R.id.result_white)
        val character_type = findViewById<TextView>(R.id.character_type)
        val men_women = findViewById<ImageView>(R.id.men_button)

        var searching_tool = Searching()

        val rich_name = Name(findViewById(R.id.rich),findViewById<ImageView>(R.id.rich_button),findViewById<ImageView>(R.id.rich_text),false,0f,0f,0f,0f,0f,0f,0)
        val strong_name = Name(findViewById(R.id.strong),findViewById<ImageView>(R.id.strong_button),findViewById<ImageView>(R.id.strong_text),false,0f,0f,0f,0f,0f,0f,0)
        val smart_name = Name(findViewById(R.id.smart),findViewById<ImageView>(R.id.smart_button),findViewById<ImageView>(R.id.smart_text),false,0f,0f,0f,0f,0f,0f,0)
        val beautiful_name = Name(findViewById(R.id.beautiful),findViewById<ImageView>(R.id.beautiful_button),findViewById<ImageView>(R.id.beautiful_text),false,0f,0f,0f,0f,0f,0f,0)
        val believer_name = Name(findViewById(R.id.believer),findViewById<ImageView>(R.id.believer_button),findViewById<ImageView>(R.id.believer_text),false,0f,0f,0f,0f,0f,0f,0)

        val place_1 = Place(findViewById<ImageView>(R.id.place1),"",true)
        val place_2 = Place(findViewById<ImageView>(R.id.place2),"",true)
        val place_3 = Place(findViewById<ImageView>(R.id.place3),"",true)
        val place_4 = Place(findViewById<ImageView>(R.id.place4),"",true)
        val place_5 = Place(findViewById<ImageView>(R.id.place5),"",true)

        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein)
        fadeOutAnimation.fillAfter = true
        fadeInAnimation.fillAfter = true

        mExplosionField = ExplosionField.attach2Window(this)

        val anim_men = TranslateAnimation(
            0f, 0f,
            -300f,
           0f)
        anim_men.duration = 1000
        anim_men.fillAfter = true
        men_women.startAnimation(anim_men)

        val translate_button_animation = TranslateAnimation(
            0f, 0f,
            200f,
            0f)
        translate_button_animation.duration =1000
        button.startAnimation(translate_button_animation)

        val anim_rich = ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim_rich.duration = 1000
        anim_rich.fillAfter = true
        findViewById<ConstraintLayout>(R.id.rich).startAnimation(anim_rich)

        val anim_strong = ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim_strong.duration = 1000
        anim_strong.fillAfter = true
        findViewById<ConstraintLayout>(R.id.strong).startAnimation(anim_strong)

        val anim_smart = ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim_smart.duration = 1000
        anim_smart.fillAfter = true
        findViewById<ConstraintLayout>(R.id.smart).startAnimation(anim_smart)

        val anim_beautiful = ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim_beautiful.duration = 1000
        anim_beautiful.fillAfter = true
        findViewById<ConstraintLayout>(R.id.beautiful).startAnimation(anim_beautiful)

        val anim_believer = ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim_believer.duration = 1000
        anim_believer.fillAfter = true
        findViewById<ConstraintLayout>(R.id.believer).startAnimation(anim_believer)

        rich_name.get_imageView().setOnClickListener {
            if (rich_name.get_isNameRunning() == false) {
                rich_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if (place_1.get_placeIsEmpty()==true) {
                            rich_name.set_placeCount_x(place_1.get_placeView().x)
                            rich_name.set_placeCount_y(place_1.get_placeView().y)
                            rich_name.set_nameDestination_x(-7f)
                            rich_name.set_nameDestination_y(10f)
                            rich_name.set_name_textDestination_x(0f)
                            rich_name.set_name_textDestination_y(0f)
                            rich_name.set_count(5)
                            place_1.set_placeText("rich")
                            place_1.set_placeIsEmpty(false)
                        }
                        else if (place_2.get_placeIsEmpty()==true) {
                            rich_name.set_placeCount_x(place_2.get_placeView().x)
                            rich_name.set_placeCount_y(place_2.get_placeView().y)
                            rich_name.set_nameDestination_x(-9f)
                            rich_name.set_nameDestination_y(-10f)
                            rich_name.set_name_textDestination_x(0f)
                            rich_name.set_name_textDestination_y(50f)
                            rich_name.set_count(4)
                            place_2.set_placeText("rich")
                            place_2.set_placeIsEmpty(false)
                            rich_name.get_imageView().rotation=180f
                        }
                        else if (place_3.get_placeIsEmpty()==true) {
                            rich_name.set_placeCount_x(place_3.get_placeView().x)
                            rich_name.set_placeCount_y(place_3.get_placeView().y)
                            rich_name.set_nameDestination_x(7f)
                            rich_name.set_nameDestination_y(10f)
                            rich_name.set_name_textDestination_x(0f)
                            rich_name.set_name_textDestination_y(0f)
                            rich_name.set_count(3)
                            place_3.set_placeText("rich")
                            place_3.set_placeIsEmpty(false)
                        }
                        else if (place_4.get_placeIsEmpty()==true) {
                            rich_name.set_placeCount_x(place_4.get_placeView().x)
                            rich_name.set_placeCount_y(place_4.get_placeView().y)
                            rich_name.set_nameDestination_x(-7f)
                            rich_name.set_nameDestination_y(-10f)
                            rich_name.set_name_textDestination_x(0f)
                            rich_name.set_name_textDestination_y(50f)
                            rich_name.set_count(2)
                            rich_name.get_imageView().rotation=180f
                            place_4.set_placeText("rich")
                            place_4.set_placeIsEmpty(false)
                        }
                        else if (place_5.get_placeIsEmpty()==true) {
                            rich_name.set_placeCount_x(place_5.get_placeView().x)
                            rich_name.set_placeCount_y(place_5.get_placeView().y)
                            rich_name.set_nameDestination_x(-7f)
                            rich_name.set_nameDestination_y(10f)
                            rich_name.set_name_textDestination_x(0f)
                            rich_name.set_name_textDestination_y(0f)
                            rich_name.set_count(1)
                            place_5.set_placeText("rich")
                            place_5.set_placeIsEmpty(false)
                        }
                        rich_name.set_isNameRunning(true)
                        rich_name.get_constraintLayout().x = rich_name.get_placeCount_x()+ rich_name.get_nameDestination_x()
                        rich_name.get_constraintLayout().y = rich_name.get_placeCount_y() + rich_name.get_nameDestination_y()
                        rich_name.get_textView().x+=rich_name.get_name_textDestination_x()
                        rich_name.get_textView().y+=rich_name.get_name_textDestination_y()
                        rich_name.get_constraintLayout().startAnimation(fadeInAnimation)
                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
        }
        strong_name.get_imageView().setOnClickListener {
            if (strong_name.get_isNameRunning() == false) {
                strong_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if (place_1.get_placeIsEmpty()==true) {
                            strong_name.set_placeCount_x(place_1.get_placeView().x)
                            strong_name.set_placeCount_y(place_1.get_placeView().y)
                            strong_name.set_nameDestination_x(-7f)
                            strong_name.set_nameDestination_y(10f)
                            strong_name.set_name_textDestination_x(0f)
                            strong_name.set_name_textDestination_y(0f)
                            strong_name.set_count(5)
                            place_1.set_placeText("strong")
                            place_1.set_placeIsEmpty(false)
                            strong_name.get_imageView().rotation=180f
                        }
                        else if (place_2.get_placeIsEmpty()==true) {
                            strong_name.set_placeCount_x(place_2.get_placeView().x)
                            strong_name.set_placeCount_y(place_2.get_placeView().y)
                            strong_name.set_nameDestination_x(0f)
                            strong_name.set_nameDestination_y(-10f)
                            strong_name.set_name_textDestination_x(0f)
                            strong_name.set_name_textDestination_y(0f)
                            strong_name.set_count(4)
                            place_2.set_placeText("strong")
                            place_2.set_placeIsEmpty(false)
                        }
                        else if (place_3.get_placeIsEmpty()==true) {
                            strong_name.set_placeCount_x(place_3.get_placeView().x)
                            strong_name.set_placeCount_y(place_3.get_placeView().y)
                            strong_name.set_nameDestination_x(0f)
                            strong_name.set_nameDestination_y(10f)
                            strong_name.set_name_textDestination_x(0f)
                            strong_name.set_name_textDestination_y(0f)
                            strong_name.set_count(3)
                            place_3.set_placeText("strong")
                            place_3.set_placeIsEmpty(false)
                            strong_name.get_imageView().rotation=180f
                        }
                        else if (place_4.get_placeIsEmpty()==true) {
                            strong_name.set_placeCount_x(place_4.get_placeView().x)
                            strong_name.set_placeCount_y(place_4.get_placeView().y)
                            strong_name.set_nameDestination_x(0f)
                            strong_name.set_nameDestination_y(-10f)
                            strong_name.set_name_textDestination_x(0f)
                            strong_name.set_name_textDestination_y(0f)
                            strong_name.set_count(2)
                            place_4.set_placeText("strong")
                            place_4.set_placeIsEmpty(false)
                        }
                        else if (place_5.get_placeIsEmpty()==true) {
                            strong_name.set_placeCount_x(place_5.get_placeView().x)
                            strong_name.set_placeCount_y(place_5.get_placeView().y)
                            strong_name.set_nameDestination_x(0f)
                            strong_name.set_nameDestination_y(10f)
                            strong_name.set_name_textDestination_x(0f)
                            strong_name.set_name_textDestination_y(0f)
                            strong_name.set_count(1)
                            place_5.set_placeText("strong")
                            place_5.set_placeIsEmpty(false)
                            strong_name.get_imageView().rotation=180f
                        }
                        strong_name.set_isNameRunning(true)
                        strong_name.get_constraintLayout().x = strong_name.get_placeCount_x()+ strong_name.get_nameDestination_x()
                        strong_name.get_constraintLayout().y = strong_name.get_placeCount_y() + strong_name.get_nameDestination_y()
                        strong_name.get_textView().x+=strong_name.get_name_textDestination_x()
                        strong_name.get_textView().y+=strong_name.get_name_textDestination_y()
                        strong_name.get_constraintLayout().startAnimation(fadeInAnimation)
                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
        }

        smart_name.get_imageView().setOnClickListener {
            if (smart_name.get_isNameRunning() == false) {
                smart_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if (place_1.get_placeIsEmpty()==true) {
                            smart_name.set_placeCount_x(place_1.get_placeView().x)
                            smart_name.set_placeCount_y(place_1.get_placeView().y)
                            smart_name.set_nameDestination_x(-7f)
                            smart_name.set_nameDestination_y(10f)
                            smart_name.set_name_textDestination_x(0f)
                            smart_name.set_name_textDestination_y(0f)
                            smart_name.set_count(5)
                            place_1.set_placeText("smart")
                            place_1.set_placeIsEmpty(false)
                        }
                        else if (place_2.get_placeIsEmpty()==true) {
                            smart_name.set_placeCount_x(place_2.get_placeView().x)
                            smart_name.set_placeCount_y(place_2.get_placeView().y)
                            smart_name.set_nameDestination_x(-9f)
                            smart_name.set_nameDestination_y(-10f)
                            smart_name.set_name_textDestination_x(0f)
                            smart_name.set_name_textDestination_y(50f)
                            smart_name.set_count(4)
                            place_2.set_placeText("smart")
                            place_2.set_placeIsEmpty(false)
                            smart_name.get_imageView().rotation=180f
                        }
                        else if (place_3.get_placeIsEmpty()==true) {
                            smart_name.set_placeCount_x(place_3.get_placeView().x)
                            smart_name.set_placeCount_y(place_3.get_placeView().y)
                            smart_name.set_nameDestination_x(7f)
                            smart_name.set_nameDestination_y(10f)
                            smart_name.set_name_textDestination_x(0f)
                            smart_name.set_name_textDestination_y(0f)
                            smart_name.set_count(3)
                            place_3.set_placeText("smart")
                            place_3.set_placeIsEmpty(false)
                        }
                        else if (place_4.get_placeIsEmpty()==true) {
                            smart_name.set_placeCount_x(place_4.get_placeView().x)
                            smart_name.set_placeCount_y(place_4.get_placeView().y)
                            smart_name.set_nameDestination_x(-7f)
                            smart_name.set_nameDestination_y(-10f)
                            smart_name.set_name_textDestination_x(0f)
                            smart_name.set_name_textDestination_y(50f)
                            smart_name.set_count(2)
                            smart_name.get_imageView().rotation=180f
                            place_4.set_placeText("smart")
                            place_4.set_placeIsEmpty(false)
                        }
                        else if (place_5.get_placeIsEmpty()==true) {
                            smart_name.set_placeCount_x(place_5.get_placeView().x)
                            smart_name.set_placeCount_y(place_5.get_placeView().y)
                            smart_name.set_nameDestination_x(-7f)
                            smart_name.set_nameDestination_y(10f)
                            smart_name.set_name_textDestination_x(0f)
                            smart_name.set_name_textDestination_y(0f)
                            smart_name.set_count(1)
                            place_5.set_placeText("smart")
                            place_5.set_placeIsEmpty(false)
                        }
                        smart_name.set_isNameRunning(true)
                        smart_name.get_constraintLayout().x = smart_name.get_placeCount_x()+ smart_name.get_nameDestination_x()
                        smart_name.get_constraintLayout().y = smart_name.get_placeCount_y() + smart_name.get_nameDestination_y()
                        smart_name.get_textView().x+=smart_name.get_name_textDestination_x()
                        smart_name.get_textView().y+=smart_name.get_name_textDestination_y()
                        smart_name.get_constraintLayout().startAnimation(fadeInAnimation)
                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
        }
        beautiful_name.get_imageView().setOnClickListener {
            if (beautiful_name.get_isNameRunning() == false) {
                beautiful_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if (place_1.get_placeIsEmpty()==true) {
                            beautiful_name.set_placeCount_x(place_1.get_placeView().x)
                            beautiful_name.set_placeCount_y(place_1.get_placeView().y)
                            beautiful_name.set_nameDestination_x(10f)
                            beautiful_name.set_nameDestination_y(10f)
                            beautiful_name.set_name_textDestination_x(0f)
                            beautiful_name.set_name_textDestination_y(0f)
                            beautiful_name.set_count(5)
                            place_1.set_placeText("beautiful")
                            place_1.set_placeIsEmpty(false)
                            beautiful_name.get_imageView().rotation=180f
                        }
                        else if (place_2.get_placeIsEmpty()==true) {
                            beautiful_name.set_placeCount_x(place_2.get_placeView().x)
                            beautiful_name.set_placeCount_y(place_2.get_placeView().y)
                            beautiful_name.set_nameDestination_x(-10f)
                            beautiful_name.set_nameDestination_y(-10f)
                            beautiful_name.set_name_textDestination_x(0f)
                            beautiful_name.set_name_textDestination_y(0f)
                            beautiful_name.set_count(4)
                            place_2.set_placeText("beautiful")
                            place_2.set_placeIsEmpty(false)
                        }
                        else if (place_3.get_placeIsEmpty()==true) {
                            beautiful_name.set_placeCount_x(place_3.get_placeView().x)
                            beautiful_name.set_placeCount_y(place_3.get_placeView().y)
                            beautiful_name.set_nameDestination_x(-10f)
                            beautiful_name.set_nameDestination_y(10f)
                            beautiful_name.set_name_textDestination_x(0f)
                            beautiful_name.set_name_textDestination_y(0f)
                            beautiful_name.set_count(3)
                            place_3.set_placeText("beautiful")
                            place_3.set_placeIsEmpty(false)
                            beautiful_name.get_imageView().rotation=180f
                        }
                        else if (place_4.get_placeIsEmpty()==true) {
                            beautiful_name.set_placeCount_x(place_4.get_placeView().x)
                            beautiful_name.set_placeCount_y(place_4.get_placeView().y)
                            beautiful_name.set_nameDestination_x(10f)
                            beautiful_name.set_nameDestination_y(-10f)
                            beautiful_name.set_name_textDestination_x(0f)
                            beautiful_name.set_name_textDestination_y(0f)
                            beautiful_name.set_count(2)
                            place_4.set_placeText("beautiful")
                            place_4.set_placeIsEmpty(false)
                        }
                        else if (place_5.get_placeIsEmpty()==true) {
                            beautiful_name.set_placeCount_x(place_5.get_placeView().x)
                            beautiful_name.set_placeCount_y(place_5.get_placeView().y)
                            beautiful_name.set_nameDestination_x(0f)
                            beautiful_name.set_nameDestination_y(0f)
                            beautiful_name.set_name_textDestination_x(0f)
                            beautiful_name.set_name_textDestination_y(0f)
                            beautiful_name.set_count(1)
                            place_5.set_placeText("beautiful")
                            place_5.set_placeIsEmpty(false)
                            beautiful_name.get_imageView().rotation=180f
                        }
                        beautiful_name.set_isNameRunning(true)
                        beautiful_name.get_constraintLayout().x = beautiful_name.get_placeCount_x()+ beautiful_name.get_nameDestination_x()
                        beautiful_name.get_constraintLayout().y = beautiful_name.get_placeCount_y() + beautiful_name.get_nameDestination_y()
                        beautiful_name.get_textView().x+=beautiful_name.get_name_textDestination_x()
                        beautiful_name.get_textView().y+=beautiful_name.get_name_textDestination_y()
                        beautiful_name.get_constraintLayout().startAnimation(fadeInAnimation)
                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
        }
        believer_name.get_imageView().setOnClickListener {
            if (believer_name.get_isNameRunning() == false) {
                believer_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if (place_1.get_placeIsEmpty()==true) {
                            believer_name.set_placeCount_x(place_1.get_placeView().x)
                            believer_name.set_placeCount_y(place_1.get_placeView().y)
                            believer_name.set_nameDestination_x(-7f)
                            believer_name.set_nameDestination_y(10f)
                            believer_name.set_name_textDestination_x(0f)
                            believer_name.set_name_textDestination_y(0f)
                            believer_name.set_count(5)
                            place_1.set_placeText("believer")
                            place_1.set_placeIsEmpty(false)
                        }
                        else if (place_2.get_placeIsEmpty()==true) {
                            believer_name.set_placeCount_x(place_2.get_placeView().x)
                            believer_name.set_placeCount_y(place_2.get_placeView().y)
                            believer_name.set_nameDestination_x(-9f)
                            believer_name.set_nameDestination_y(-10f)
                            believer_name.set_name_textDestination_x(0f)
                            believer_name.set_name_textDestination_y(50f)
                            believer_name.set_count(4)
                            place_2.set_placeText("believer")
                            place_2.set_placeIsEmpty(false)
                            smart_name.get_imageView().rotation=180f
                        }
                        else if (place_3.get_placeIsEmpty()==true) {
                            believer_name.set_placeCount_x(place_3.get_placeView().x)
                            believer_name.set_placeCount_y(place_3.get_placeView().y)
                            believer_name.set_nameDestination_x(7f)
                            believer_name.set_nameDestination_y(10f)
                            believer_name.set_name_textDestination_x(0f)
                            believer_name.set_name_textDestination_y(0f)
                            believer_name.set_count(3)
                            place_3.set_placeText("believer")
                            place_3.set_placeIsEmpty(false)
                        }
                        else if (place_4.get_placeIsEmpty()==true) {
                            believer_name.set_placeCount_x(place_4.get_placeView().x)
                            believer_name.set_placeCount_y(place_4.get_placeView().y)
                            believer_name.set_nameDestination_x(-7f)
                            believer_name.set_nameDestination_y(-10f)
                            believer_name.set_name_textDestination_x(0f)
                            believer_name.set_name_textDestination_y(50f)
                            believer_name.set_count(2)
                            believer_name.get_imageView().rotation=180f
                            place_4.set_placeText("believer")
                            place_4.set_placeIsEmpty(false)
                        }
                        else if (place_5.get_placeIsEmpty()==true) {
                            believer_name.set_placeCount_x(place_5.get_placeView().x)
                            believer_name.set_placeCount_y(place_5.get_placeView().y)
                            believer_name.set_nameDestination_x(-7f)
                            believer_name.set_nameDestination_y(10f)
                            believer_name.set_name_textDestination_x(0f)
                            believer_name.set_name_textDestination_y(0f)
                            believer_name.set_count(1)
                            place_5.set_placeText("believer")
                            place_5.set_placeIsEmpty(false)
                        }
                        believer_name.set_isNameRunning(true)
                        believer_name.get_constraintLayout().x = believer_name.get_placeCount_x() + believer_name.get_nameDestination_x()
                        believer_name.get_constraintLayout().y = believer_name.get_placeCount_y() + believer_name.get_nameDestination_y()
                        believer_name.get_textView().x+=believer_name.get_name_textDestination_x()
                        believer_name.get_textView().y+=believer_name.get_name_textDestination_y()
                        believer_name.get_constraintLayout().startAnimation(fadeInAnimation)
                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
        }
        rich_name.get_imageView().setOnLongClickListener {
            if(rich_name.get_isNameRunning()==true){
                rich_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if(place_1.get_placeIsEmpty()==false && place_1.get_placeText().equals("rich")){
                            place_1.set_placeText("")
                            place_1.set_placeIsEmpty(true)
                        }
                        else if (place_2.get_placeIsEmpty()==false && place_2.get_placeText().equals("rich")){
                            place_2.set_placeText("")
                            place_2.set_placeIsEmpty(true)
                        }
                        else if (place_3.get_placeIsEmpty()==false && place_3.get_placeText().equals("rich")){
                            place_3.set_placeText("")
                            place_3.set_placeIsEmpty(true)
                        }
                        else if (place_4.get_placeIsEmpty()==false && place_4.get_placeText().equals("rich")){
                            place_4.set_placeText("")
                            place_4.set_placeIsEmpty(true)
                        }
                        else if (place_5.get_placeIsEmpty()==false && place_5.get_placeText().equals("rich")){
                            place_5.set_placeText("")
                            place_5.set_placeIsEmpty(true)
                        }
                        rich_name.set_count(0)
                        rich_name.get_constraintLayout().x = findViewById<TextView>(R.id.start_rich_destination).x
                        rich_name.get_constraintLayout().y = findViewById<TextView>(R.id.start_rich_destination).y
                        rich_name.get_textView().x-=rich_name.get_name_textDestination_x()
                        rich_name.get_textView().y-=rich_name.get_name_textDestination_y()
                        rich_name.get_imageView().rotation = 0f
                        rich_name.set_isNameRunning(false)
                        rich_name.get_constraintLayout().startAnimation(fadeInAnimation)

                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
                true
        }
        strong_name.get_imageView().setOnLongClickListener {
            if(strong_name.get_isNameRunning()==true){
                strong_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if(place_1.get_placeIsEmpty()==false && place_1.get_placeText().equals("strong")){
                            place_1.set_placeText("")
                            place_1.set_placeIsEmpty(true)
                        }
                        else if (place_2.get_placeIsEmpty()==false && place_2.get_placeText().equals("strong")){
                            place_2.set_placeText("")
                            place_2.set_placeIsEmpty(true)
                        }
                        else if (place_3.get_placeIsEmpty()==false && place_3.get_placeText().equals("strong")){
                            place_3.set_placeText("")
                            place_3.set_placeIsEmpty(true)
                        }
                        else if (place_4.get_placeIsEmpty()==false && place_4.get_placeText().equals("strong")){
                            place_4.set_placeText("")
                            place_4.set_placeIsEmpty(true)
                        }
                        else if (place_5.get_placeIsEmpty()==false && place_5.get_placeText().equals("strong")){
                            place_5.set_placeText("")
                            place_5.set_placeIsEmpty(true)
                        }
                        strong_name.set_count(0)
                        strong_name.get_constraintLayout().x = findViewById<TextView>(R.id.start_strong_destination).x
                        strong_name.get_constraintLayout().y = findViewById<TextView>(R.id.start_strong_destination).y
                        strong_name.get_textView().x-=strong_name.get_name_textDestination_x()
                        strong_name.get_textView().y-=strong_name.get_name_textDestination_y()
                        strong_name.get_imageView().rotation = 0f
                        strong_name.set_isNameRunning(false)
                        strong_name.get_constraintLayout().startAnimation(fadeInAnimation)

                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
            true
        }

        smart_name.get_imageView().setOnLongClickListener {
            if(smart_name.get_isNameRunning()==true){
                smart_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if(place_1.get_placeIsEmpty()==false && place_1.get_placeText().equals("smart")){
                            place_1.set_placeText("")
                            place_1.set_placeIsEmpty(true)
                        }
                        else if (place_2.get_placeIsEmpty()==false && place_2.get_placeText().equals("smart")){
                            place_2.set_placeText("")
                            place_2.set_placeIsEmpty(true)
                        }
                        else if (place_3.get_placeIsEmpty()==false && place_3.get_placeText().equals("smart")){
                            place_3.set_placeText("")
                            place_3.set_placeIsEmpty(true)
                        }
                        else if (place_4.get_placeIsEmpty()==false && place_4.get_placeText().equals("smart")){
                            place_4.set_placeText("")
                            place_4.set_placeIsEmpty(true)
                        }
                        else if (place_5.get_placeIsEmpty()==false && place_5.get_placeText().equals("smart")){
                            place_5.set_placeText("")
                            place_5.set_placeIsEmpty(true)
                        }
                        smart_name.set_count(0)
                        smart_name.get_constraintLayout().x = findViewById<TextView>(R.id.start_smart_destination).x
                        smart_name.get_constraintLayout().y = findViewById<TextView>(R.id.start_smart_destination).y
                        smart_name.get_textView().x-=smart_name.get_name_textDestination_x()
                        smart_name.get_textView().y-=smart_name.get_name_textDestination_y()
                        smart_name.get_imageView().rotation = 0f
                        smart_name.set_isNameRunning(false)
                        smart_name.get_constraintLayout().startAnimation(fadeInAnimation)

                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
            true
        }

        beautiful_name.get_imageView().setOnLongClickListener {
            if(beautiful_name.get_isNameRunning()==true){
                beautiful_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if(place_1.get_placeIsEmpty()==false && place_1.get_placeText().equals("beautiful")){
                            place_1.set_placeText("")
                            place_1.set_placeIsEmpty(true)
                        }
                        else if (place_2.get_placeIsEmpty()==false && place_2.get_placeText().equals("beautiful")){
                            place_2.set_placeText("")
                            place_2.set_placeIsEmpty(true)
                        }
                        else if (place_3.get_placeIsEmpty()==false && place_3.get_placeText().equals("beautiful")){
                            place_3.set_placeText("")
                            place_3.set_placeIsEmpty(true)
                        }
                        else if (place_4.get_placeIsEmpty()==false && place_4.get_placeText().equals("beautiful")){
                            place_4.set_placeText("")
                            place_4.set_placeIsEmpty(true)
                        }
                        else if (place_5.get_placeIsEmpty()==false && place_5.get_placeText().equals("beautiful")){
                            place_5.set_placeText("")
                            place_5.set_placeIsEmpty(true)
                        }
                        beautiful_name.set_count(0)
                        beautiful_name.get_constraintLayout().x = findViewById<TextView>(R.id.start_beautiful_destination).x
                        beautiful_name.get_constraintLayout().y = findViewById<TextView>(R.id.start_beautiful_destination).y
                        beautiful_name.get_textView().x-=beautiful_name.get_name_textDestination_x()
                        beautiful_name.get_textView().y-=beautiful_name.get_name_textDestination_y()
                        beautiful_name.get_imageView().rotation = 0f
                        beautiful_name.set_isNameRunning(false)
                        beautiful_name.get_constraintLayout().startAnimation(fadeInAnimation)

                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
            true
        }

        believer_name.get_imageView().setOnLongClickListener {
            if(believer_name.get_isNameRunning()==true){
                believer_name.get_constraintLayout().startAnimation(fadeOutAnimation)
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        if(place_1.get_placeIsEmpty()==false && place_1.get_placeText().equals("believer")){
                            place_1.set_placeText("")
                            place_1.set_placeIsEmpty(true)
                        }
                        else if (place_2.get_placeIsEmpty()==false && place_2.get_placeText().equals("believer")){
                            place_2.set_placeText("")
                            place_2.set_placeIsEmpty(true)
                        }
                        else if (place_3.get_placeIsEmpty()==false && place_3.get_placeText().equals("believer")){
                            place_3.set_placeText("")
                            place_3.set_placeIsEmpty(true)
                        }
                        else if (place_4.get_placeIsEmpty()==false && place_4.get_placeText().equals("believer")){
                            place_4.set_placeText("")
                            place_4.set_placeIsEmpty(true)
                        }
                        else if (place_5.get_placeIsEmpty()==false && place_5.get_placeText().equals("believer")){
                            place_5.set_placeText("")
                            place_5.set_placeIsEmpty(true)
                        }
                        believer_name.set_count(0)
                        believer_name.get_constraintLayout().x = findViewById<TextView>(R.id.start_believer_destination).x
                        believer_name.get_constraintLayout().y = findViewById<TextView>(R.id.start_believer_destination).y
                        believer_name.get_textView().x-=believer_name.get_name_textDestination_x()
                        believer_name.get_textView().y-=believer_name.get_name_textDestination_y()
                        believer_name.get_imageView().rotation = 0f
                        believer_name.set_isNameRunning(false)
                        believer_name.get_constraintLayout().startAnimation(fadeInAnimation)

                    }
                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }
            true
        }
        button.setOnClickListener {
            var arr = searching_tool.searching(rich_name.get_count(),strong_name.get_count(),smart_name.get_count(),beautiful_name.get_count(),believer_name.get_count(),"man",
                getXmlDocument("man_names.xml")!!,
                getXmlDocument("man_names.xml")!!.getElementsByTagName("name"), getXmlDocument("man_names.xml")!!.getElementsByTagName("character"))
            name.setText(arr[0])
            meaning.setText(arr[1])
            character_type.setText(arr[2])
            result.visibility = View.VISIBLE
        }

        addListener(result,meaning,name,character_type)

    }
    open fun getXmlDocument(filename: String): Document? {
        return try {
            val dbFactory = DocumentBuilderFactory.newInstance()
            val dBuilder = dbFactory.newDocumentBuilder()
            val document = dBuilder.parse(assets.open(filename))
            document.documentElement.normalize()
            return document
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    fun getValueForTag(document: Document?, tag: String?, index: Int): Int {
        val nodes = document!!.getElementsByTagName(tag)
        return nodes.item(index).textContent.toInt()
    }
    private fun addListener(root: View,root2: TextView,root3: TextView,root4: TextView) {
        if (root is ViewGroup) {
            val parent = root
            for (i in 0 until parent.childCount) {
                addListener(parent.getChildAt(i),root2,root3,root4)
            }
        } else {
            root.isClickable = true
            root.setOnLongClickListener { v ->
                mExplosionField!!.explode(v)
                root.visibility = View.INVISIBLE
                root2.setText("")
                root3.setText("")
                root4.setText("")
                true
            }
        }
    }
}