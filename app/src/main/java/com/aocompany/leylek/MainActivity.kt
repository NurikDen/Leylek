package com.aocompany.leylek
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilderFactory


open class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ImageView>(R.id.button)
        val name = findViewById<TextView>(R.id.name)
        val meaning = findViewById<TextView>(R.id.meaning)
        val result = findViewById<ImageView>(R.id.result_white)
        val character_type = findViewById<TextView>(R.id.character_type)

        var searching_tool = Searching()

        val rich_name = Name(findViewById<ImageView>(R.id.rich_button),findViewById<ImageView>(R.id.rich_text),false,0f,0f,0f,0f,0f,0f,0)
        val strong_name = Name(findViewById<ImageView>(R.id.strong_button),findViewById<ImageView>(R.id.strong_text),false,0f,0f,0f,0f,0f,0f,0)
        val smart_name = Name(findViewById<ImageView>(R.id.smart_button),findViewById<ImageView>(R.id.smart_text),false,0f,0f,0f,0f,0f,0f,0)
        val beautiful_name = Name(findViewById<ImageView>(R.id.beautiful_button),findViewById<ImageView>(R.id.beautiful_text),false,0f,0f,0f,0f,0f,0f,0)
        val believer_name = Name(findViewById<ImageView>(R.id.believer_button),findViewById<ImageView>(R.id.believer_text),false,0f,0f,0f,0f,0f,0f,0)

        val place_1 = Place(findViewById<ImageView>(R.id.place1),"",true)
        val place_2 = Place(findViewById<ImageView>(R.id.place2),"",true)
        val place_3 = Place(findViewById<ImageView>(R.id.place3),"",true)
        val place_4 = Place(findViewById<ImageView>(R.id.place4),"",true)
        val place_5 = Place(findViewById<ImageView>(R.id.place5),"",true)

        rich_name.get_imageView().setOnClickListener {
            if (rich_name.get_isNameRunning() == false) {
                if (place_1.get_placeIsEmpty()==true) {
                    rich_name.set_placeCount_x(place_1.get_placeView().x)
                    rich_name.set_placeCount_y(place_1.get_placeView().y)
                    rich_name.set_nameDestination_x(7f)
                    rich_name.set_nameDestination_y(10f)
                    rich_name.set_name_textDestination_x(62f)
                    rich_name.set_name_textDestination_y(75f)
                    rich_name.set_count(5)
                    place_1.set_placeText("rich")
                    place_1.set_placeIsEmpty(false)
                }
                else if (place_2.get_placeIsEmpty()==true) {
                    rich_name.set_placeCount_x(place_2.get_placeView().x)
                    rich_name.set_placeCount_y(place_2.get_placeView().y)
                    rich_name.set_nameDestination_x(7f)
                    rich_name.set_nameDestination_y(-10f)
                    rich_name.set_name_textDestination_x(64f)
                    rich_name.set_name_textDestination_y(112f)
                    rich_name.set_count(4)
                    place_2.set_placeText("rich")
                    place_2.set_placeIsEmpty(false)
                    rich_name.get_imageView().rotation=180f
                }
                else if (place_3.get_placeIsEmpty()==true) {
                    rich_name.set_placeCount_x(place_3.get_placeView().x)
                    rich_name.set_placeCount_y(place_3.get_placeView().y)
                    rich_name.set_nameDestination_x(-7f)
                    rich_name.set_nameDestination_y(10f)
                    rich_name.set_name_textDestination_x(75f)
                    rich_name.set_name_textDestination_y(75f)
                    rich_name.set_count(3)
                    place_3.set_placeText("rich")
                    place_3.set_placeIsEmpty(false)
                }
                else if (place_4.get_placeIsEmpty()==true) {
                    rich_name.set_placeCount_x(place_4.get_placeView().x)
                    rich_name.set_placeCount_y(place_4.get_placeView().y)
                    rich_name.set_nameDestination_x(7f)
                    rich_name.set_nameDestination_y(-10f)
                    rich_name.set_name_textDestination_x(64f)
                    rich_name.set_name_textDestination_y(112f)
                    rich_name.set_count(2)
                    rich_name.get_imageView().rotation=180f
                    place_4.set_placeText("rich")
                    place_4.set_placeIsEmpty(false)
                }
                else if (place_5.get_placeIsEmpty()==true) {
                    rich_name.set_placeCount_x(place_5.get_placeView().x)
                    rich_name.set_placeCount_y(place_5.get_placeView().y)
                    rich_name.set_nameDestination_x(7f)
                    rich_name.set_nameDestination_y(10f)
                    rich_name.set_name_textDestination_x(62f)
                    rich_name.set_name_textDestination_y(75f)
                    rich_name.set_count(1)
                    place_5.set_placeText("rich")
                    place_5.set_placeIsEmpty(false)
                }
                rich_name.set_isNameRunning(true)
                val anim = TranslateAnimation(
                    0f,
                    ((rich_name.get_placeCount_x() - rich_name.get_imageView().x)-rich_name.get_nameDestination_x()),
                    0f,
                    ((rich_name.get_placeCount_y() - rich_name.get_imageView().y)+rich_name.get_nameDestination_y()))
                val anim_text = TranslateAnimation(0f,(rich_name.get_placeCount_x() - rich_name.get_textView().x)+rich_name.get_nameDestination_x(),0f,(rich_name.get_placeCount_y()-rich_name.get_textView().y)+rich_name.get_name_textDestination_y())
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                rich_name.get_textView().startAnimation(anim_text)
                rich_name.get_imageView().startAnimation(anim)
            }
        }
        if (rich_name.get_isNameRunning() == true) {
            rich_name.get_imageView().x = rich_name.get_placeCount_x()
            rich_name.get_imageView().y = rich_name.get_placeCount_y()
        }
        strong_name.get_imageView().setOnClickListener{
            if (strong_name.get_isNameRunning() == false) {
                if (place_1.get_placeIsEmpty()==true) {
                    strong_name.set_placeCount_x(place_1.get_placeView().x)
                    strong_name.set_placeCount_y(place_1.get_placeView().y)
                    strong_name.set_nameDestination_x(7f)
                    strong_name.set_nameDestination_y(20f)
                    strong_name.set_name_textDestination_x(60f)
                    strong_name.set_name_textDestination_y(72f)
                    strong_name.set_count(5)
                    place_1.set_placeText("strong")
                    place_1.set_placeIsEmpty(false)
                }
                else if (place_2.get_placeIsEmpty()==true) {
                    strong_name.set_placeCount_x(place_2.get_placeView().x)
                    strong_name.set_placeCount_y(place_2.get_placeView().y)
                    strong_name.set_nameDestination_x(7f)
                    strong_name.set_nameDestination_y(-17f)
                    strong_name.set_name_textDestination_x(60f)
                    strong_name.set_name_textDestination_y(112f)
                    strong_name.set_count(4)
                    place_2.set_placeText("strong")
                    place_2.set_placeIsEmpty(false)
                    strong_name.get_imageView().rotation=180f
                }
                else if (place_3.get_placeIsEmpty()==true) {
                    strong_name.set_placeCount_x(place_3.get_placeView().x)
                    strong_name.set_placeCount_y(place_3.get_placeView().y)
                    strong_name.set_nameDestination_x(-9f)
                    strong_name.set_nameDestination_y(20f)
                    strong_name.set_name_textDestination_x(70f)
                    strong_name.set_name_textDestination_y(72f)
                    strong_name.set_count(3)
                    place_3.set_placeText("strong")
                    place_3.set_placeIsEmpty(false)
                }
                else if (place_4.get_placeIsEmpty()==true) {
                    strong_name.set_placeCount_x(place_4.get_placeView().x)
                    strong_name.set_placeCount_y(place_4.get_placeView().y)
                    strong_name.set_nameDestination_x(7f)
                    strong_name.set_nameDestination_y(-17f)
                    strong_name.set_name_textDestination_x(60f)
                    strong_name.set_name_textDestination_y(112f)
                    strong_name.set_count(2)
                    strong_name.get_imageView().rotation=180f
                    place_4.set_placeText("strong")
                    place_4.set_placeIsEmpty(false)
                }
                else if (place_5.get_placeIsEmpty()==true) {
                    strong_name.set_placeCount_x(place_5.get_placeView().x)
                    strong_name.set_placeCount_y(place_5.get_placeView().y)
                    strong_name.set_nameDestination_x(7f)
                    strong_name.set_nameDestination_y(20f)
                    strong_name.set_name_textDestination_x(60f)
                    strong_name.set_name_textDestination_y(72f)
                    strong_name.set_count(1)
                    place_5.set_placeText("strong")
                    place_5.set_placeIsEmpty(false)
                }
                strong_name.set_isNameRunning(true)
                val anim = TranslateAnimation(
                    0f,
                    ((strong_name.get_placeCount_x() - strong_name.get_imageView().x)- strong_name.get_nameDestination_x()),
                    0f,
                    ((strong_name.get_placeCount_y() - strong_name.get_imageView().y)+ strong_name.get_nameDestination_y()))
                val anim_text = TranslateAnimation(0f,(strong_name.get_placeCount_x() - strong_name.get_textView().x)+strong_name.get_nameDestination_x(),0f,(strong_name.get_placeCount_y()- strong_name.get_textView().y)+strong_name.get_name_textDestination_y())
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                strong_name.get_textView().startAnimation(anim_text)
                strong_name.get_imageView().startAnimation(anim)
            }
        }
        if (strong_name.get_isNameRunning() == true) {
            strong_name.get_imageView().x = strong_name.get_placeCount_x()
            strong_name.get_imageView().y = strong_name.get_placeCount_y()
        }
        smart_name.get_imageView().setOnClickListener {
            if (smart_name.get_isNameRunning() == false) {
                if (place_1.get_placeIsEmpty()==true) {
                    smart_name.set_placeCount_x(place_1.get_placeView().x)
                    smart_name.set_placeCount_y(place_1.get_placeView().y)
                    smart_name.set_nameDestination_x(7f)
                    smart_name.set_nameDestination_y(10f)
                    smart_name.set_name_textDestination_x(52f)
                    smart_name.set_name_textDestination_y(75f)
                    smart_name.set_count(5)
                    place_1.set_placeText("smart")
                    place_1.set_placeIsEmpty(false)
                }
                else if (place_2.get_placeIsEmpty()==true) {
                    smart_name.set_placeCount_x(place_2.get_placeView().x)
                    smart_name.set_placeCount_y(place_2.get_placeView().y)
                    smart_name.set_nameDestination_x(7f)
                    smart_name.set_nameDestination_y(-10f)
                    smart_name.set_name_textDestination_x(50f)
                    smart_name.set_name_textDestination_y(140f)
                    smart_name.set_count(4)
                    place_2.set_placeText("smart")
                    place_2.set_placeIsEmpty(false)
                    smart_name.get_imageView().rotation=180f
                }
                else if (place_3.get_placeIsEmpty()==true) {
                    smart_name.set_placeCount_x(place_3.get_placeView().x)
                    smart_name.set_placeCount_y(place_3.get_placeView().y)
                    smart_name.set_nameDestination_x(-7f)
                    smart_name.set_nameDestination_y(10f)
                    smart_name.set_name_textDestination_x(64f)
                    smart_name.set_name_textDestination_y(75f)
                    smart_name.set_count(3)
                    place_3.set_placeText("smart")
                    place_3.set_placeIsEmpty(false)
                }
                else if (place_4.get_placeIsEmpty()==true) {
                    smart_name.set_placeCount_x(place_4.get_placeView().x)
                    smart_name.set_placeCount_y(place_4.get_placeView().y)
                    smart_name.set_nameDestination_x(7f)
                    smart_name.set_nameDestination_y(-10f)
                    smart_name.set_name_textDestination_x(60f)
                    smart_name.set_name_textDestination_y(112f)
                    smart_name.set_count(2)
                    smart_name.get_imageView().rotation=180f
                    place_4.set_placeText("smart")
                    place_4.set_placeIsEmpty(false)
                }
                else if (place_5.get_placeIsEmpty()==true) {
                    smart_name.set_placeCount_x(place_5.get_placeView().x)
                    smart_name.set_placeCount_y(place_5.get_placeView().y)
                    smart_name.set_nameDestination_x(7f)
                    smart_name.set_nameDestination_y(10f)
                    smart_name.set_name_textDestination_x(50f)
                    smart_name.set_name_textDestination_y(75f)
                    smart_name.set_count(1)
                    place_5.set_placeText("smart")
                    place_5.set_placeIsEmpty(false)
                }
                smart_name.set_isNameRunning(true)
                val anim = TranslateAnimation(
                    0f,
                    ((smart_name.get_placeCount_x() - smart_name.get_imageView().x)- smart_name.get_nameDestination_x()),
                    0f,
                    ((smart_name.get_placeCount_y() - smart_name.get_imageView().y)+ smart_name.get_nameDestination_y()))
                val anim_text = TranslateAnimation(0f,(smart_name.get_placeCount_x() - smart_name.get_textView().x)+smart_name.get_nameDestination_x(),0f,(smart_name.get_placeCount_y()- smart_name.get_textView().y)+smart_name.get_name_textDestination_y())
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                smart_name.get_textView().startAnimation(anim_text)
                smart_name.get_imageView().startAnimation(anim)
            }

        }
        if (smart_name.get_isNameRunning() == true) {
            smart_name.get_imageView().x = smart_name.get_placeCount_x()
            smart_name.get_imageView().y = smart_name.get_placeCount_y()
        }
        beautiful_name.get_imageView().setOnClickListener {
            if (beautiful_name.get_isNameRunning() == false) {
                if (place_1.get_placeIsEmpty()==true) {
                    beautiful_name.set_placeCount_x(place_1.get_placeView().x)
                    beautiful_name.set_placeCount_y(place_1.get_placeView().y)
                    beautiful_name.set_nameDestination_x(7f)
                    beautiful_name.set_nameDestination_y(-18f)
                    beautiful_name.set_name_textDestination_x(60f)
                    beautiful_name.set_name_textDestination_y(72f)
                    beautiful_name.set_count(5)
                    place_1.set_placeText("beautiful")
                    place_1.set_placeIsEmpty(false)
                }
                else if (place_2.get_placeIsEmpty()==true) {
                    beautiful_name.set_placeCount_x(place_2.get_placeView().x)
                    beautiful_name.set_placeCount_y(place_2.get_placeView().y)
                    beautiful_name.set_nameDestination_x(7f)
                    beautiful_name.set_nameDestination_y(18f)
                    beautiful_name.set_name_textDestination_x(60f)
                    beautiful_name.set_name_textDestination_y(112f)
                    beautiful_name.set_count(4)
                    place_2.set_placeText("beautiful")
                    place_2.set_placeIsEmpty(false)
                    beautiful_name.get_imageView().rotation=180f
                }
                else if (place_3.get_placeIsEmpty()==true) {
                    beautiful_name.set_placeCount_x(place_3.get_placeView().x)
                    beautiful_name.set_placeCount_y(place_3.get_placeView().y)
                    beautiful_name.set_nameDestination_x(-8f)
                    beautiful_name.set_nameDestination_y(-18f)
                    beautiful_name.set_name_textDestination_x(77f)
                    beautiful_name.set_name_textDestination_y(72f)
                    beautiful_name.set_count(3)
                    place_3.set_placeText("beautiful")
                    place_3.set_placeIsEmpty(false)
                }
                else if (place_4.get_placeIsEmpty()==true) {
                    beautiful_name.set_placeCount_x(place_4.get_placeView().x)
                    beautiful_name.set_placeCount_y(place_4.get_placeView().y)
                    beautiful_name.set_nameDestination_x(7f)
                    beautiful_name.set_nameDestination_y(17f)
                    beautiful_name.set_name_textDestination_x(60f)
                    beautiful_name.set_name_textDestination_y(112f)
                    beautiful_name.set_count(2)
                    beautiful_name.get_imageView().rotation=180f
                    place_4.set_placeText("beautiful")
                    place_4.set_placeIsEmpty(false)
                }
                else if (place_5.get_placeIsEmpty()==true) {
                    beautiful_name.set_placeCount_x(place_5.get_placeView().x)
                    beautiful_name.set_placeCount_y(place_5.get_placeView().y)
                    beautiful_name.set_nameDestination_x(7f)
                    beautiful_name.set_nameDestination_y(-20f)
                    beautiful_name.set_name_textDestination_x(60f)
                    beautiful_name.set_name_textDestination_y(72f)
                    beautiful_name.set_count(1)
                    place_5.set_placeText("beautiful")
                    place_5.set_placeIsEmpty(false)
                }
                beautiful_name.set_isNameRunning(true)
                val anim = TranslateAnimation(
                    0f,
                    ((beautiful_name.get_placeCount_x() - beautiful_name.get_imageView().x)- beautiful_name.get_nameDestination_x()),
                    0f,
                    ((beautiful_name.get_placeCount_y() - beautiful_name.get_imageView().y)+ beautiful_name.get_nameDestination_y()))
                val anim_text = TranslateAnimation(0f,(beautiful_name.get_placeCount_x() - beautiful_name.get_textView().x)+beautiful_name.get_nameDestination_x(),0f,(beautiful_name.get_placeCount_y()- beautiful_name.get_textView().y)+beautiful_name.get_name_textDestination_y())
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                beautiful_name.get_textView().startAnimation(anim_text)
                beautiful_name.get_imageView().startAnimation(anim)
            }
        }
        if (beautiful_name.get_isNameRunning()== true) {
            beautiful_name.get_imageView().x = beautiful_name.get_placeCount_x()
            beautiful_name.get_imageView().y = beautiful_name.get_placeCount_y()
        }
        believer_name.get_imageView().setOnClickListener {
            if (believer_name.get_isNameRunning() == false) {
                if (place_1.get_placeIsEmpty()==true) {
                    believer_name.set_placeCount_x(place_1.get_placeView().x)
                    believer_name.set_placeCount_y(place_1.get_placeView().y)
                    believer_name.set_nameDestination_x(7f)
                    believer_name.set_nameDestination_y(10f)
                    believer_name.set_name_textDestination_x(35f)
                    believer_name.set_name_textDestination_y(75f)
                    believer_name.set_count(5)
                    place_1.set_placeText("believer")
                    place_1.set_placeIsEmpty(false)
                }
                else if (place_2.get_placeIsEmpty()==true) {
                    believer_name.set_placeCount_x(place_2.get_placeView().x)
                    believer_name.set_placeCount_y(place_2.get_placeView().y)
                    believer_name.set_nameDestination_x(7f)
                    believer_name.set_nameDestination_y(-10f)
                    believer_name.set_name_textDestination_x(35f)
                    believer_name.set_name_textDestination_y(145f)
                    believer_name.set_count(4)
                    place_2.set_placeText("believer")
                    place_2.set_placeIsEmpty(false)
                    believer_name.get_imageView().rotation=180f
                }
                else if (place_3.get_placeIsEmpty()==true) {
                    believer_name.set_placeCount_x(place_3.get_placeView().x)
                    believer_name.set_placeCount_y(place_3.get_placeView().y)
                    believer_name.set_nameDestination_x(-7f)
                    believer_name.set_nameDestination_y(10f)
                    believer_name.set_name_textDestination_x(47f)
                    believer_name.set_name_textDestination_y(75f)
                    believer_name.set_count(3)
                    place_3.set_placeText("believer")
                    place_3.set_placeIsEmpty(false)
                }
                else if (place_4.get_placeIsEmpty()==true) {
                    believer_name.set_placeCount_x(place_4.get_placeView().x)
                    believer_name.set_placeCount_y(place_4.get_placeView().y)
                    believer_name.set_nameDestination_x(7f)
                    believer_name.set_nameDestination_y(-10f)
                    believer_name.set_name_textDestination_x(31f)
                    believer_name.set_name_textDestination_y(140f)
                    believer_name.set_count(2)
                    believer_name.get_imageView().rotation=180f
                    place_4.set_placeText("believer")
                    place_4.set_placeIsEmpty(false)
                }
                else if (place_5.get_placeIsEmpty()==true) {
                    believer_name.set_placeCount_x(place_5.get_placeView().x)
                    believer_name.set_placeCount_y(place_5.get_placeView().y)
                    believer_name.set_nameDestination_x(7f)
                    believer_name.set_nameDestination_y(10f)
                    believer_name.set_name_textDestination_x(32f)
                    believer_name.set_name_textDestination_y(75f)
                    believer_name.set_count(1)
                    place_5.set_placeText("believer")
                    place_5.set_placeIsEmpty(false)
                }
                believer_name.set_isNameRunning(true)
                val anim = TranslateAnimation(
                    0f,
                    ((believer_name.get_placeCount_x() - believer_name.get_imageView().x)- believer_name.get_nameDestination_x()),
                    0f,
                    ((believer_name.get_placeCount_y() - believer_name.get_imageView().y)+ believer_name.get_nameDestination_y()))
                val anim_text = TranslateAnimation(0f,(believer_name.get_placeCount_x() - believer_name.get_textView().x)+ believer_name.get_nameDestination_x(),0f,(believer_name.get_placeCount_y()- believer_name.get_textView().y)+believer_name.get_name_textDestination_y())
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                believer_name.get_textView().startAnimation(anim_text)
                believer_name.get_imageView().startAnimation(anim)
            }
        }
        if (believer_name.get_isNameRunning()== true) {
            believer_name.get_imageView().x = believer_name.get_placeCount_x()
            believer_name.get_imageView().y = believer_name.get_placeCount_y()
        }

        place_1.get_placeView().setOnLongClickListener {
            if(place_1.get_placeIsEmpty()==false) {
                if (rich_name.get_isNameRunning() == true && place_1.get_placeText() =="rich") {
                    val anim =
                        TranslateAnimation(place_1.get_placeView().x - 7f - rich_name.get_imageView().x, 0f, place_1.get_placeView().y + 10f - rich_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_1.get_placeView().x + 62f) - rich_name.get_textView().x,
                        0f,
                        (75f + place_1.get_placeView().y) - rich_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1.set_placeText("")
                    rich_name.set_count(0)
                    rich_name.get_imageView().rotation = 0f
                    rich_name.get_imageView().startAnimation(anim)
                    rich_name.get_textView().startAnimation(anim_text)
                    rich_name.set_isNameRunning(false)
                } else if (strong_name.get_isNameRunning() == true && place_1.get_placeText() =="strong") {
                    val anim =
                        TranslateAnimation(place_1.get_placeView().x - 7f - strong_name.get_imageView().x, 0f, place_1.get_placeView().y + 17f - strong_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_1.get_placeView().x + 60f) - strong_name.get_textView().x,
                        0f,
                        (112f + place_1.get_placeView().y) - strong_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1.set_placeText("")
                    strong_name.set_count(0)
                    strong_name.get_imageView().rotation = 0f
                    strong_name.get_imageView().startAnimation(anim)
                    strong_name.get_textView().startAnimation(anim_text)
                    strong_name.set_isNameRunning(false)
                } else if (smart_name.get_isNameRunning() == true && place_1.get_placeText() == "smart") {
                    val anim =
                        TranslateAnimation(place_1.get_placeView().x - smart_name.get_imageView().x, 0f, place_1.get_placeView().y - smart_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_1.get_placeView().x - 85f) - smart_name.get_textView().x,
                        0f,
                        (140f + place_1.get_placeView().y) - smart_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1.set_placeText("")
                    smart_name.set_count(0)
                    smart_name.get_imageView().rotation = 0f
                    smart_name.get_imageView().startAnimation(anim)
                    smart_name.get_textView().startAnimation(anim_text)
                    smart_name.set_isNameRunning(false)
                } else if (beautiful_name.get_isNameRunning() == true && place_1.get_placeText() == "beautiful") {
                    val anim =
                        TranslateAnimation(place_1.get_placeView().x - beautiful_name.get_imageView().x, 0f, place_1.get_placeView().y - beautiful_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_1.get_placeView().x - 225f) - beautiful_name.get_textView().x,
                        0f,
                        (100f + place_1.get_placeView().y) - beautiful_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1.set_placeText("")
                    beautiful_name.set_count(0)
                    beautiful_name.get_imageView().rotation = 0f
                    beautiful_name.get_imageView().startAnimation(anim)
                    beautiful_name.get_textView().startAnimation(anim_text)
                    beautiful_name.set_isNameRunning(false)
                } else if (believer_name.get_isNameRunning() == true && place_1.get_placeText() == "believer") {
                    val anim =
                        TranslateAnimation(place_1.get_placeView().x - believer_name.get_imageView().x, 0f, place_1.get_placeView().y - believer_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_1.get_placeView().x - 225f) - believer_name.get_textView().x,
                        0f,
                        (place_1.get_placeView().y-55F) - believer_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1.set_placeText("")
                    believer_name.set_count(0)
                    believer_name.get_imageView().rotation = 0f
                    believer_name.get_imageView().startAnimation(anim)
                    believer_name.get_textView().startAnimation(anim_text)
                    believer_name.set_isNameRunning(false)
                }
                place_1.set_placeIsEmpty(true)
            }
                true
        }
        place_2.get_placeView().setOnLongClickListener {
            if(place_2.get_placeIsEmpty()==false) {
                if (rich_name.get_isNameRunning() == true && place_2.get_placeText() =="rich") {
                    val anim =
                        TranslateAnimation(place_2.get_placeView().x - 7f - rich_name.get_imageView().x, 0f, place_2.get_placeView().y + 10f - rich_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_2.get_placeView().x + 62f) - rich_name.get_textView().x,
                        0f,
                        (75f + place_2.get_placeView().y) - rich_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2.set_placeText("")
                    rich_name.set_count(0)
                    rich_name.get_imageView().rotation = 0f
                    rich_name.get_imageView().startAnimation(anim)
                    rich_name.get_textView().startAnimation(anim_text)
                    rich_name.set_isNameRunning(false)
                } else if (strong_name.get_isNameRunning() == true && place_2.get_placeText() =="strong") {
                    val anim =
                        TranslateAnimation(place_2.get_placeView().x - 7f - strong_name.get_imageView().x, 0f, place_2.get_placeView().y + 17f - strong_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_2.get_placeView().x + 60f) - strong_name.get_textView().x,
                        0f,
                        (112f + place_2.get_placeView().y) - strong_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2.set_placeText("")
                    strong_name.set_count(0)
                    strong_name.get_imageView().rotation = 0f
                    strong_name.get_imageView().startAnimation(anim)
                    strong_name.get_textView().startAnimation(anim_text)
                    strong_name.set_isNameRunning(false)
                } else if (smart_name.get_isNameRunning() == true && place_2.get_placeText() == "smart") {
                    val anim =
                        TranslateAnimation(place_2.get_placeView().x - smart_name.get_imageView().x, 0f, place_2.get_placeView().y - smart_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_2.get_placeView().x - 85f) - smart_name.get_textView().x,
                        0f,
                        (140f + place_2.get_placeView().y) - smart_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2.set_placeText("")
                    smart_name.set_count(0)
                    smart_name.get_imageView().rotation = 0f
                    smart_name.get_imageView().startAnimation(anim)
                    smart_name.get_textView().startAnimation(anim_text)
                    smart_name.set_isNameRunning(false)
                } else if (beautiful_name.get_isNameRunning() == true && place_2.get_placeText() == "beautiful") {
                    val anim =
                        TranslateAnimation(place_2.get_placeView().x - beautiful_name.get_imageView().x, 0f, place_2.get_placeView().y - beautiful_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_2.get_placeView().x - 225f) - beautiful_name.get_textView().x,
                        0f,
                        (100f + place_2.get_placeView().y) - beautiful_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2.set_placeText("")
                    beautiful_name.set_count(0)
                    beautiful_name.get_imageView().rotation = 0f
                    beautiful_name.get_imageView().startAnimation(anim)
                    beautiful_name.get_textView().startAnimation(anim_text)
                    beautiful_name.set_isNameRunning(false)
                } else if (believer_name.get_isNameRunning() == true && place_2.get_placeText() == "believer") {
                    val anim =
                        TranslateAnimation(place_2.get_placeView().x - believer_name.get_imageView().x, 0f, place_2.get_placeView().y - believer_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_2.get_placeView().x - 225f) - believer_name.get_textView().x,
                        0f,
                        (place_2.get_placeView().y-55F) - believer_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2.set_placeText("")
                    believer_name.set_count(0)
                    believer_name.get_imageView().rotation = 0f
                    believer_name.get_imageView().startAnimation(anim)
                    believer_name.get_textView().startAnimation(anim_text)
                    believer_name.set_isNameRunning(false)
                }
                place_2.set_placeIsEmpty(true)
            }
            true
        }
        place_3.get_placeView().setOnLongClickListener {
            if(place_3.get_placeIsEmpty()==false) {
                if (rich_name.get_isNameRunning() == true && place_3.get_placeText() =="rich") {
                    val anim =
                        TranslateAnimation(place_3.get_placeView().x - 7f - rich_name.get_imageView().x, 0f, place_3.get_placeView().y + 10f - rich_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_3.get_placeView().x + 62f) - rich_name.get_textView().x,
                        0f,
                        (75f + place_3.get_placeView().y) - rich_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3.set_placeText("")
                    rich_name.set_count(0)
                    rich_name.get_imageView().rotation = 0f
                    rich_name.get_imageView().startAnimation(anim)
                    rich_name.get_textView().startAnimation(anim_text)
                    rich_name.set_isNameRunning(false)
                } else if (strong_name.get_isNameRunning() == true && place_3.get_placeText() =="strong") {
                    val anim =
                        TranslateAnimation(place_3.get_placeView().x - 7f - strong_name.get_imageView().x, 0f, place_3.get_placeView().y + 17f - strong_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_3.get_placeView().x + 60f) - strong_name.get_textView().x,
                        0f,
                        (112f + place_3.get_placeView().y) - strong_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3.set_placeText("")
                    strong_name.set_count(0)
                    strong_name.get_imageView().rotation = 0f
                    strong_name.get_imageView().startAnimation(anim)
                    strong_name.get_textView().startAnimation(anim_text)
                    strong_name.set_isNameRunning(false)
                } else if (smart_name.get_isNameRunning() == true && place_3.get_placeText() == "smart") {
                    val anim =
                        TranslateAnimation(place_3.get_placeView().x - smart_name.get_imageView().x, 0f, place_3.get_placeView().y - smart_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_3.get_placeView().x - 85f) - smart_name.get_textView().x,
                        0f,
                        (140f + place_3.get_placeView().y) - smart_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3.set_placeText("")
                    smart_name.set_count(0)
                    smart_name.get_imageView().rotation = 0f
                    smart_name.get_imageView().startAnimation(anim)
                    smart_name.get_textView().startAnimation(anim_text)
                    smart_name.set_isNameRunning(false)
                } else if (beautiful_name.get_isNameRunning() == true && place_3.get_placeText() == "beautiful") {
                    val anim =
                        TranslateAnimation(place_3.get_placeView().x - beautiful_name.get_imageView().x, 0f, place_3.get_placeView().y - beautiful_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_3.get_placeView().x - 225f) - beautiful_name.get_textView().x,
                        0f,
                        (100f + place_3.get_placeView().y) - beautiful_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3.set_placeText("")
                    beautiful_name.set_count(0)
                    beautiful_name.get_imageView().rotation = 0f
                    beautiful_name.get_imageView().startAnimation(anim)
                    beautiful_name.get_textView().startAnimation(anim_text)
                    beautiful_name.set_isNameRunning(false)
                } else if (believer_name.get_isNameRunning() == true && place_3.get_placeText() == "believer") {
                    val anim =
                        TranslateAnimation(place_3.get_placeView().x - believer_name.get_imageView().x, 0f, place_3.get_placeView().y - believer_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_3.get_placeView().x - 225f) - believer_name.get_textView().x,
                        0f,
                        (place_3.get_placeView().y-55F) - believer_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3.set_placeText("")
                    believer_name.set_count(0)
                    believer_name.get_imageView().rotation = 0f
                    believer_name.get_imageView().startAnimation(anim)
                    believer_name.get_textView().startAnimation(anim_text)
                    believer_name.set_isNameRunning(false)
                }
                place_3.set_placeIsEmpty(true)
            }
            true
        }
        place_4.get_placeView().setOnLongClickListener {
            if(place_4.get_placeIsEmpty()==false) {
                if (rich_name.get_isNameRunning() == true && place_4.get_placeText() =="rich") {
                    val anim =
                        TranslateAnimation(place_4.get_placeView().x - 7f - rich_name.get_imageView().x, 0f, place_4.get_placeView().y + 10f - rich_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_4.get_placeView().x + 62f) - rich_name.get_textView().x,
                        0f,
                        (75f + place_4.get_placeView().y) - rich_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4.set_placeText("")
                    rich_name.set_count(0)
                    rich_name.get_imageView().rotation = 0f
                    rich_name.get_imageView().startAnimation(anim)
                    rich_name.get_textView().startAnimation(anim_text)
                    rich_name.set_isNameRunning(false)
                } else if (strong_name.get_isNameRunning() == true && place_4.get_placeText() =="strong") {
                    val anim =
                        TranslateAnimation(place_4.get_placeView().x - 7f - strong_name.get_imageView().x, 0f, place_4.get_placeView().y + 17f - strong_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_4.get_placeView().x + 60f) - strong_name.get_textView().x,
                        0f,
                        (112f + place_4.get_placeView().y) - strong_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4.set_placeText("")
                    strong_name.set_count(0)
                    strong_name.get_imageView().rotation = 0f
                    strong_name.get_imageView().startAnimation(anim)
                    strong_name.get_textView().startAnimation(anim_text)
                    strong_name.set_isNameRunning(false)
                } else if (smart_name.get_isNameRunning() == true && place_4.get_placeText() == "smart") {
                    val anim =
                        TranslateAnimation(place_4.get_placeView().x - smart_name.get_imageView().x, 0f, place_4.get_placeView().y - smart_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_4.get_placeView().x - 85f) - smart_name.get_textView().x,
                        0f,
                        (140f + place_4.get_placeView().y) - smart_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4.set_placeText("")
                    smart_name.set_count(0)
                    smart_name.get_imageView().rotation = 0f
                    smart_name.get_imageView().startAnimation(anim)
                    smart_name.get_textView().startAnimation(anim_text)
                    smart_name.set_isNameRunning(false)
                } else if (beautiful_name.get_isNameRunning() == true && place_4.get_placeText() == "beautiful") {
                    val anim =
                        TranslateAnimation(place_4.get_placeView().x - beautiful_name.get_imageView().x, 0f, place_4.get_placeView().y - beautiful_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_4.get_placeView().x - 225f) - beautiful_name.get_textView().x,
                        0f,
                        (100f + place_4.get_placeView().y) - beautiful_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4.set_placeText("")
                    beautiful_name.set_count(0)
                    beautiful_name.get_imageView().rotation = 0f
                    beautiful_name.get_imageView().startAnimation(anim)
                    beautiful_name.get_textView().startAnimation(anim_text)
                    beautiful_name.set_isNameRunning(false)
                } else if (believer_name.get_isNameRunning() == true && place_4.get_placeText() == "believer") {
                    val anim =
                        TranslateAnimation(place_4.get_placeView().x - believer_name.get_imageView().x, 0f, place_4.get_placeView().y - believer_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_4.get_placeView().x - 225f) - believer_name.get_textView().x,
                        0f,
                        (place_4.get_placeView().y-55F) - believer_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4.set_placeText("")
                    believer_name.set_count(0)
                    believer_name.get_imageView().rotation = 0f
                    believer_name.get_imageView().startAnimation(anim)
                    believer_name.get_textView().startAnimation(anim_text)
                    believer_name.set_isNameRunning(false)
                }
                place_4.set_placeIsEmpty(true)
            }
            true
        }
        place_5.get_placeView().setOnLongClickListener {
            if(place_5.get_placeIsEmpty()==false) {
                if (rich_name.get_isNameRunning() == true && place_5.get_placeText() =="rich") {
                    val anim =
                        TranslateAnimation(place_5.get_placeView().x - 7f - rich_name.get_imageView().x, 0f, place_5.get_placeView().y + 10f - rich_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_5.get_placeView().x + 62f) - rich_name.get_textView().x,
                        0f,
                        (75f + place_5.get_placeView().y) - rich_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5.set_placeText("")
                    rich_name.set_count(0)
                    rich_name.get_imageView().rotation = 0f
                    rich_name.get_imageView().startAnimation(anim)
                    rich_name.get_textView().startAnimation(anim_text)
                    rich_name.set_isNameRunning(false)
                } else if (strong_name.get_isNameRunning() == true && place_5.get_placeText() =="strong") {
                    val anim =
                        TranslateAnimation(place_5.get_placeView().x - 7f - strong_name.get_imageView().x, 0f, place_5.get_placeView().y + 17f - strong_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_5.get_placeView().x + 60f) - strong_name.get_textView().x,
                        0f,
                        (112f + place_5.get_placeView().y) - strong_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5.set_placeText("")
                    strong_name.set_count(0)
                    strong_name.get_imageView().rotation = 0f
                    strong_name.get_imageView().startAnimation(anim)
                    strong_name.get_textView().startAnimation(anim_text)
                    strong_name.set_isNameRunning(false)
                } else if (smart_name.get_isNameRunning() == true && place_5.get_placeText() == "smart") {
                    val anim =
                        TranslateAnimation(place_5.get_placeView().x - smart_name.get_imageView().x, 0f, place_5.get_placeView().y - smart_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_5.get_placeView().x - 85f) - smart_name.get_textView().x,
                        0f,
                        (140f + place_5.get_placeView().y) - smart_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5.set_placeText("")
                    smart_name.set_count(0)
                    smart_name.get_imageView().rotation = 0f
                    smart_name.get_imageView().startAnimation(anim)
                    smart_name.get_textView().startAnimation(anim_text)
                    smart_name.set_isNameRunning(false)
                } else if (beautiful_name.get_isNameRunning() == true && place_5.get_placeText() == "beautiful") {
                    val anim =
                        TranslateAnimation(place_5.get_placeView().x - beautiful_name.get_imageView().x, 0f, place_5.get_placeView().y - beautiful_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_5.get_placeView().x - 225f) - beautiful_name.get_textView().x,
                        0f,
                        (100f + place_5.get_placeView().y) - beautiful_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5.set_placeText("")
                    beautiful_name.set_count(0)
                    beautiful_name.get_imageView().rotation = 0f
                    beautiful_name.get_imageView().startAnimation(anim)
                    beautiful_name.get_textView().startAnimation(anim_text)
                    beautiful_name.set_isNameRunning(false)
                } else if (believer_name.get_isNameRunning() == true && place_5.get_placeText() == "believer") {
                    val anim =
                        TranslateAnimation(place_5.get_placeView().x - believer_name.get_imageView().x, 0f, place_5.get_placeView().y - believer_name.get_imageView().y, 0f)
                    val anim_text = TranslateAnimation(
                        (place_5.get_placeView().x - 225f) - believer_name.get_textView().x,
                        0f,
                        (place_5.get_placeView().y-55F) - believer_name.get_textView().y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5.set_placeText("")
                    believer_name.set_count(0)
                    believer_name.get_imageView().rotation = 0f
                    believer_name.get_imageView().startAnimation(anim)
                    believer_name.get_textView().startAnimation(anim_text)
                    believer_name.set_isNameRunning(false)
                }
                place_5.set_placeIsEmpty(true)
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
        result.setOnLongClickListener {
            result.visibility = View.INVISIBLE
            meaning.setText("")
            name.setText("")
            character_type.setText("")
            true
        }
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
}