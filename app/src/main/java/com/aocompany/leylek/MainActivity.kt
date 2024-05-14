package com.aocompany.leylek
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Document
import java.util.Random
import javax.xml.parsers.DocumentBuilderFactory


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var rich_count = 0
    var strong_count = 0
    var smart_count = 0
    var beautiful_count = 0
    var believer_count = 0
    var meaning_text = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rich = findViewById<ImageView>(R.id.rich_button)
        val strong = findViewById<ImageView>(R.id.strong_button)
        val smart = findViewById<ImageView>(R.id.smart_button)
        val beautiful = findViewById<ImageView>(R.id.beautiful_button)
        val believer = findViewById<ImageView>(R.id.believer_button)
        val place1 = findViewById<ImageView>(R.id.place1)
        val place2 = findViewById<ImageView>(R.id.place2)
        val place3 = findViewById<ImageView>(R.id.place3)
        val place4 = findViewById<ImageView>(R.id.place4)
        val place5 = findViewById<ImageView>(R.id.place5)
        val rich_text = findViewById<ImageView>(R.id.rich_text)
        val strong_text = findViewById<ImageView>(R.id.strong_text)
        val smart_text = findViewById<ImageView>(R.id.smart_text)
        val beautiful_text = findViewById<ImageView>(R.id.beautiful_text)
        val believer_text = findViewById<ImageView>(R.id.believer_text)
        val button = findViewById<ImageView>(R.id.button)
        val name = findViewById<TextView>(R.id.name)
        val meaning = findViewById<TextView>(R.id.meaning)
        val ending = findViewById<ImageView>(R.id.result_white)
        val character_type = findViewById<TextView>(R.id.character_type)

        var isrichRunning = false
        var isstrongRunning = false
        var issmartRunning = false
        var isbeautifulRunning = false
        var isbelieverRunning = false

        var place1isempty = true
        var place2isempty = true
        var place3isempty = true
        var place4isempty = true
        var place5isempty = true

        var placecount_x_rich=0f
        var placecount_y_rich=0f
        var placecount_x_strong=0f
        var placecount_y_strong=0f
        var placecount_x_smart=0f
        var placecount_y_smart=0f
        var placecount_x_beautiful=0f
        var placecount_y_beautiful=0f
        var placecount_x_believer=0f
        var placecount_y_believer=0f

        var rich_destination_x = 0f
        var rich_destination_y = 0f
        var rich_text_destination_x = 0f
        var rich_text_destination_y = 0f
        var strong_destination_x = 0f
        var strong_destination_y = 0f
        var strong_text_destination_x = 0f
        var strong_text_destination_y = 0f
        var smart_destination_x = 0f
        var smart_destination_y = 0f
        var smart_text_destination_x = 0f
        var smart_text_destination_y = 0f
        var beautiful_destination_x = 0f
        var beautiful_destination_y = 0f
        var beautiful_text_destination_x = 0f
        var beautiful_text_destination_y = 0f
        var believer_destination_x = 0f
        var believer_destination_y = 0f
        var believer_text_destination_x = 0f
        var believer_text_destination_y = 0f


        var place_1_text = ""
        var place_2_text = ""
        var place_3_text = ""
        var place_4_text = ""
        var place_5_text = ""

        var richinwaiting =false
        var stronginwaiting =true
        var smartinwaiting =false
        var beautifulinwaiting =false
        var believerinwaiting =false

        var searching_tool = Searching()

        rich.setOnClickListener {
            if (isrichRunning == false) {
                if (place1isempty==true) {
                    placecount_x_rich = place1.x
                    placecount_y_rich = place1.y
                    rich_destination_x = 7f
                    rich_destination_y = 10f
                    rich_text_destination_x = 62f
                    rich_text_destination_y = 75f
                    place_1_text="rich"
                    rich_count = 5
                    place1isempty=false
                }
                else if (place2isempty==true) {
                    placecount_x_rich = place2.x
                    placecount_y_rich = place2.y
                    rich_destination_x = 7f
                    rich_destination_y = -10f
                    rich_text_destination_x = 64f
                    rich_text_destination_y = 112f
                    rich.rotation=180f
                    place_2_text="rich"
                    rich_count = 4
                    place2isempty=false
                }
                else if (place3isempty==true) {
                    placecount_x_rich = place3.x
                    placecount_y_rich = place3.y
                    rich_destination_x = -7f
                    rich_destination_y = 10f
                    rich_text_destination_x = 75f
                    rich_text_destination_y = 75f
                    place_3_text="rich"
                    rich_count = 3
                    place3isempty=false
                }
                else if (place4isempty==true) {
                    placecount_x_rich = place4.x
                    placecount_y_rich = place4.y
                    rich_destination_x = 7f
                    rich_destination_y = -10f
                    rich_text_destination_x = 64f
                    rich_text_destination_y = 112f
                    place_4_text="rich"
                    rich_count = 2
                    rich.rotation=180f
                    place4isempty=false
                }
                else if (place5isempty==true) {
                    placecount_x_rich = place5.x
                    placecount_y_rich = place5.y
                    rich_destination_x = 7f
                    rich_destination_y = 10f
                    rich_text_destination_x = 62f
                    rich_text_destination_y = 75f
                    place_5_text="rich"
                    rich_count = 1
                    place5isempty=false
                }
                isrichRunning = true
                val anim = TranslateAnimation(
                    0f,
                    ((placecount_x_rich - rich.x)-rich_destination_x),
                    0f,
                    ((placecount_y_rich - rich.y)+rich_destination_y))
                val anim_text = TranslateAnimation(0f,(placecount_x_rich - rich_text.x)+rich_text_destination_x,0f,(placecount_y_rich-rich_text.y)+rich_text_destination_y)
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                rich_text.startAnimation(anim_text)
                rich.startAnimation(anim)
            }
        }
        if (isrichRunning == true) {
            rich.x = placecount_x_rich
            rich.y = placecount_y_rich
        }
        strong.setOnClickListener{
            if (isstrongRunning == false) {
                if (place1isempty==true) {
                    placecount_x_strong = place1.x
                    placecount_y_strong = place1.y
                    strong_destination_x = 7f
                    strong_destination_y = 20f
                    strong_text_destination_x = 60f
                    strong_text_destination_y = 72f
                    strong.rotation = 180f
                    place_1_text="strong"
                    strong_count = 5
                    place1isempty=false
                }
                else if (place2isempty==true) {
                    placecount_x_strong = place2.x
                    placecount_y_strong = place2.y
                    strong_destination_x = 7f
                    strong_destination_y = -17f
                    strong_text_destination_x = 60f
                    strong_text_destination_y = 112f
                    place_2_text="strong"
                    strong_count = 4
                    place2isempty=false
                }
                else if (place3isempty==true) {
                    placecount_x_strong = place3.x
                    placecount_y_strong = place3.y
                    strong_destination_x = -9f
                    strong_destination_y = 20f
                    strong_text_destination_x = 70f
                    strong_text_destination_y = 72f
                    strong.rotation = 180f
                    place_3_text="strong"
                    strong_count = 3
                    place3isempty=false
                }
                else if (place4isempty==true) {
                    placecount_x_strong = place4.x
                    placecount_y_strong = place4.y
                    place_4_text="strong"
                    strong_count = 2
                    strong_destination_x = 7f
                    strong_destination_y = -17f
                    strong_text_destination_x = 60f
                    strong_text_destination_y = 112f
                    place4isempty=false
                }
                else if (place5isempty==true) {
                    placecount_x_strong = place5.x
                    placecount_y_strong = place5.y
                    strong_destination_x = 7f
                    strong_destination_y = 20f
                    strong_text_destination_x = 60f
                    strong_text_destination_y = 72f
                    strong.rotation = 180f
                    place_5_text="strong"
                    strong_count = 1
                    place5isempty=false
                }
                isstrongRunning = true
                val anim = TranslateAnimation(
                    0f,
                    (placecount_x_strong - strong.x)-strong_destination_x,
                    0f,
                    (placecount_y_strong - strong.y) - strong_destination_y)
                val anim_text = TranslateAnimation(0f,(placecount_x_strong-strong_text.x)+strong_text_destination_x,0f,(placecount_y_strong-strong_text.y)+strong_text_destination_y)
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                strong_text.startAnimation(anim_text)
                strong.startAnimation(anim)
            }
        }
        if (isstrongRunning == true) {
            strong.x = placecount_x_strong
            strong.y = placecount_y_strong
        }

        smart.setOnClickListener {
            if (issmartRunning == false) {
                if (place1isempty==true) {
                    placecount_x_smart = place1.x
                    placecount_y_smart = place1.y
                    smart_destination_x = 7f
                    smart_destination_y = 10f
                    smart_text_destination_x = 52f
                    smart_text_destination_y = 75f
                    place_1_text="smart"
                    smart_count = 5
                    place1isempty=false
                }
                else if (place2isempty==true) {
                    placecount_x_smart = place2.x
                    placecount_y_smart = place2.y
                    smart_destination_x = 7f
                    smart_destination_y = -10f
                    smart_text_destination_x = 50f
                    smart_text_destination_y = 140f
                    smart.rotation=180f
                    place_2_text="smart"
                    smart_count = 4
                    place2isempty=false
                }
                else if (place3isempty==true) {
                    placecount_x_smart = place3.x
                    placecount_y_smart = place3.y
                    smart_destination_x = -7f
                    smart_destination_y = 10f
                    smart_text_destination_x = 64f
                    smart_text_destination_y = 75f
                    place_3_text="smart"
                    smart_count = 3
                    place3isempty=false
                }
                else if (place4isempty==true) {
                    placecount_x_smart = place4.x
                    placecount_y_smart = place4.y
                    smart_destination_x = 7f
                    smart_destination_y = -10f
                    smart_text_destination_x = 50f
                    smart_text_destination_y = 140f
                    place_4_text="smart"
                    smart_count = 2
                    smart.rotation=180f
                    place4isempty=false
                }
                else if (place5isempty==true) {
                    placecount_x_smart = place5.x
                    placecount_y_smart = place5.y
                    smart_destination_x = 7f
                    smart_destination_y = 10f
                    smart_text_destination_x = 50f
                    smart_text_destination_y = 75f
                    place_5_text="smart"
                    smart_count = 1
                    place5isempty=false
                }
                issmartRunning = true
                val anim = TranslateAnimation(
                    0f,
                    ((placecount_x_smart - smart.x)-smart_destination_x),
                    0f,
                    ((placecount_y_smart - smart.y)+smart_destination_y))
                val anim_text = TranslateAnimation(0f,(placecount_x_smart - smart_text.x)+smart_text_destination_x,0f,(placecount_y_smart-smart_text.y)+smart_text_destination_y)
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                smart_text.startAnimation(anim_text)
                smart.startAnimation(anim)
            }
        }
        if (issmartRunning == true) {
            smart.x = placecount_x_smart
            smart.y = placecount_y_smart
        }

        beautiful.setOnClickListener {
            if (isbeautifulRunning == false) {
                if (place1isempty==true) {
                    placecount_x_beautiful = place1.x
                    placecount_y_beautiful = place1.y
                    beautiful_destination_x = 7f
                    beautiful_destination_y = -18f
                    beautiful_text_destination_x = 60f
                    beautiful_text_destination_y = 72f
                    beautiful.rotation = 180f
                    beautiful_count = 5
                    place_1_text="beautiful"
                    place1isempty=false
                }
                else if (place2isempty==true) {
                    placecount_x_beautiful = place2.x
                    placecount_y_beautiful = place2.y
                    beautiful_destination_x = 7f
                    beautiful_destination_y = 18f
                    beautiful_text_destination_x = 60f
                    beautiful_text_destination_y = 112f
                    place_2_text="beautiful"
                    beautiful_count = 4
                    place2isempty=false
                }
                else if (place3isempty==true) {
                    placecount_x_beautiful = place3.x
                    placecount_y_beautiful = place3.y
                    beautiful_destination_x = -8f
                    beautiful_destination_y = -18f
                    beautiful_text_destination_x = 77f
                    beautiful_text_destination_y = 72f
                    beautiful.rotation = 180f
                    place_3_text="beautiful"
                    beautiful_count = 3
                    place3isempty=false
                }
                else if (place4isempty==true) {
                    placecount_x_beautiful = place4.x
                    placecount_y_beautiful = place4.y
                    place_4_text="beautiful"
                    beautiful_count = 2
                    beautiful_destination_x = 7f
                    beautiful_destination_y = 17f
                    beautiful_text_destination_x = 60f
                    beautiful_text_destination_y = 112f
                    place4isempty=false
                }
                else if (place5isempty==true) {
                    placecount_x_beautiful = place5.x
                    placecount_y_beautiful = place5.y
                    beautiful_destination_x = 7f
                    beautiful_destination_y = -20f
                    beautiful_text_destination_x = 60f
                    beautiful_text_destination_y = 72f
                    beautiful.rotation = 180f
                    place_5_text="beautiful"
                    beautiful_count = 1
                    place5isempty=false
                }
                isbeautifulRunning = true
                val anim = TranslateAnimation(
                    0f,
                    ((placecount_x_beautiful - beautiful.x)-beautiful_destination_x),
                    0f,
                    ((placecount_y_beautiful - beautiful.y)+beautiful_destination_y))
                val anim_text = TranslateAnimation(0f,(placecount_x_beautiful - beautiful_text.x)+beautiful_text_destination_x,0f,(placecount_y_beautiful-beautiful_text.y)+beautiful_text_destination_y)
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                beautiful_text.startAnimation(anim_text)
                beautiful.startAnimation(anim)
            }
        }
        if (isbeautifulRunning == true) {
            beautiful.x = placecount_x_beautiful
            beautiful.y = placecount_y_beautiful
        }
        believer.setOnClickListener {
            if (isbelieverRunning == false) {
                if (place1isempty==true) {
                    placecount_x_believer = place1.x
                    placecount_y_believer = place1.y
                    believer_destination_x = 7f
                    believer_destination_y = 10f
                    believer_text_destination_x = 35f
                    believer_text_destination_y = 75f
                    place_1_text="believer"
                    believer_count = 5
                    place1isempty=false
                }
                else if (place2isempty==true) {
                    placecount_x_believer = place2.x
                    placecount_y_believer = place2.y
                    believer_destination_x = 7f
                    believer_destination_y = -10f
                    believer_text_destination_x = 35f
                    believer_text_destination_y = 145f
                    believer.rotation=180f
                    place_2_text="believer"
                    believer_count = 4
                    place2isempty=false
                }
                else if (place3isempty==true) {
                    placecount_x_believer = place3.x
                    placecount_y_believer = place3.y
                    believer_destination_x = -7f
                    believer_destination_y = 10f
                    believer_text_destination_x = 47f
                    believer_text_destination_y = 75f
                    place_3_text="believer"
                    believer_count = 3
                    place3isempty=false
                }
                else if (place4isempty==true) {
                    placecount_x_believer = place4.x
                    placecount_y_believer = place4.y
                    believer_destination_x = 7f
                    believer_destination_y = -10f
                    believer_text_destination_x = 31f
                    believer_text_destination_y = 140f
                    place_4_text="believer"
                    believer_count = 2
                    believer.rotation=180f
                    place4isempty=false
                }
                else if (place5isempty==true) {
                    placecount_x_believer = place5.x
                    placecount_y_believer = place5.y
                    believer_destination_x = 7f
                    believer_destination_y = 10f
                    believer_text_destination_x = 32f
                    believer_text_destination_y = 75f
                    place_5_text="believer"
                    believer_count = 1
                    place5isempty=false
                }
                isbelieverRunning = true
                val anim = TranslateAnimation(
                    0f,
                    ((placecount_x_believer - believer.x)-believer_destination_x),
                    0f,
                    ((placecount_y_believer - believer.y)+believer_destination_y))
                val anim_text = TranslateAnimation(0f,(placecount_x_believer - believer_text.x)+believer_text_destination_x,0f,(placecount_y_believer-believer_text.y)+believer_text_destination_y)
                anim_text.duration=1000
                anim_text.fillAfter=true
                anim.duration = 1000
                anim.fillAfter = true
                believer_text.startAnimation(anim_text)
                believer.startAnimation(anim)
            }
        }
        if (isbelieverRunning == true) {
            believer.x = placecount_x_believer
            believer.y = placecount_y_believer
        }

        place1.setOnLongClickListener {
            if(place1isempty==false) {
                if (isrichRunning == true && place_1_text =="rich") {
                    val anim =
                        TranslateAnimation(place1.x - 7f - rich.x, 0f, place1.y + 10f - rich.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place1.x + 62f) - rich_text.x,
                        0f,
                        (75f + place1.y) - rich_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1_text ="rich"
                    rich_count = 0
                    rich.startAnimation(anim)
                    rich_text.startAnimation(anim_text)
                    isrichRunning = false
                } else if (isstrongRunning == true && place_1_text =="strong") {
                    val anim = TranslateAnimation(place1.x - 7f - strong.x, 0f, place1.y + 10f - strong.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place1.x + 60f) - strong_text.x,
                        0f,
                        (112f + place1.y) - strong_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_1_text ="strong"
                    strong_count = 0
                    strong.startAnimation(anim)
                    strong_text.startAnimation(anim_text)
                    strong.rotation = 0f
                    isstrongRunning = false
                } else if (issmartRunning == true && place_1_text =="smart") {
                    val anim =
                        TranslateAnimation(place1.x - smart.x, 0f, place1.y - smart.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place1.x - 80f) - strong_text.x,
                        0f,
                        (130f + place1.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim_text.duration =1000
                    anim_text.fillAfter = true
                    anim.fillAfter = true
                    place_1_text ="smart"
                    smart_count = 0
                    smart_text.startAnimation(anim_text)
                    smart.startAnimation(anim)
                    issmartRunning = false
                } else if (isbeautifulRunning == true && place_1_text =="beautiful") {
                    val anim =
                        TranslateAnimation(place1.x - beautiful.x, 0f, place1.y - beautiful.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place1.x - 225f) - strong_text.x,
                        0f,
                        (90f + place1.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration =1000
                    anim_text.fillAfter = true
                    beautiful_count = 0
                    beautiful.startAnimation(anim)
                    beautiful_text.startAnimation(anim_text)
                    place_1_text ="beautiful"
                    isbeautifulRunning = false
                    beautiful.rotation = 0f
                } else if (isbelieverRunning == true && place_1_text =="believer") {
                    val anim =
                        TranslateAnimation(place1.x - believer.x, 0f, place1.y - believer.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place1.x - 225f) - strong_text.x,
                        0f,
                        (place1.y-70f) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    place_1_text ="believer"
                    believer_count = 0
                    believer.startAnimation(anim)
                    believer_text.startAnimation(anim_text)
                    isbelieverRunning = false
                }
                place1isempty = true
            }
                true
        }
        place2.setOnLongClickListener {
            if(place2isempty==false) {
                if (isrichRunning == true && place_2_text =="rich") {
                    val anim =
                        TranslateAnimation(place2.x - 7f - rich.x, 0f, place2.y + 10f - rich.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place2.x + 62f) - rich_text.x,
                        0f,
                        (75f + place2.y) - rich_text.y,
                        0f
                    )
                    rich.rotation=0f
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2_text =""
                    rich_count = 0
                    rich.startAnimation(anim)
                    rich_text.startAnimation(anim_text)
                    isrichRunning = false
                } else if (isstrongRunning == true && place_2_text =="strong") {
                    val anim = TranslateAnimation(place2.x - 7f - strong.x, 0f, place2.y + 17f - strong.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place2.x + 60f) - strong_text.x,
                        0f,
                        (112f + place2.y) - strong_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_2_text =""
                    strong_count = 0
                    strong.startAnimation(anim)
                    strong_text.startAnimation(anim_text)
                    isstrongRunning = false
                } else if (issmartRunning == true && place_2_text =="smart") {
                    val anim =
                        TranslateAnimation(place2.x - smart.x, 0f, place2.y - smart.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place2.x - 85f) - strong_text.x,
                        0f,
                        (140f + place2.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration =1000
                    anim_text.fillAfter =true
                    smart.rotation = 0f
                    place_2_text =""
                    smart_count = 0
                    smart_text.startAnimation(anim_text)
                    smart.startAnimation(anim)
                    issmartRunning = false
                } else if (isbeautifulRunning == true && place_2_text =="beautiful") {
                    val anim =
                        TranslateAnimation(place2.x - beautiful.x, 0f, place2.y - beautiful.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place2.x - 225f) - strong_text.x,
                        0f,
                        (100f + place2.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    beautiful_count = 0
                    beautiful.startAnimation(anim)
                    beautiful_text.startAnimation(anim_text)
                    place_2_text =""
                    isbeautifulRunning = false
                    beautiful.rotation = 0f
                } else if (isbelieverRunning == true && place_2_text =="believer") {
                    val anim =
                        TranslateAnimation(place2.x - believer.x, 0f, place2.y - believer.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place2.x - 225f) - strong_text.x,
                        0f,
                        (place2.y-55f) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    place_2_text =""
                    believer_count = 0
                    believer.rotation=0f
                    believer_text.startAnimation(anim_text)
                    believer.startAnimation(anim)
                    isbelieverRunning = false
                }
                place2isempty = true
            }
            true
        }
        place3.setOnLongClickListener {
            if(place3isempty==false) {
                if (isrichRunning == true && place_3_text =="rich") {
                    val anim =
                        TranslateAnimation(place3.x - 7f - rich.x, 0f, place3.y + 10f - rich.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place3.x + 62f) - rich_text.x,
                        0f,
                        (75f + place3.y) - rich_text.y,
                        0f
                    )
                    rich.rotation=0f
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3_text =""
                    rich_count = 0
                    rich.startAnimation(anim)
                    rich_text.startAnimation(anim_text)
                    isrichRunning = false
                } else if (isstrongRunning == true && place_3_text =="strong") {
                    val anim = TranslateAnimation(place3.x - 7f - strong.x, 0f, place3.y + 17f - strong.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place3.x + 60f) - strong_text.x,
                        0f,
                        (112f + place3.y) - strong_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_3_text =""
                    strong.rotation=0f
                    strong_count = 0
                    strong.startAnimation(anim)
                    strong_text.startAnimation(anim_text)
                    isstrongRunning = false
                } else if (issmartRunning == true && place_3_text =="smart") {
                    val anim =
                        TranslateAnimation(place3.x - smart.x, 0f, place3.y - smart.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place3.x - 85f) - strong_text.x,
                        0f,
                        (140f + place3.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration =1000
                    anim_text.fillAfter =true
                    smart.rotation = 0f
                    place_3_text =""
                    smart_count = 0
                    smart_text.startAnimation(anim_text)
                    smart.startAnimation(anim)
                    issmartRunning = false
                } else if (isbeautifulRunning == true && place_3_text =="beautiful") {
                    val anim =
                        TranslateAnimation(place3.x - beautiful.x, 0f, place3.y - beautiful.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place3.x - 225f) - strong_text.x,
                        0f,
                        (100f + place3.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    beautiful_count = 0
                    beautiful.startAnimation(anim)
                    beautiful_text.startAnimation(anim_text)
                    place_3_text =""
                    isbeautifulRunning = false
                    beautiful.rotation = 0f
                } else if (isbelieverRunning == true && place_3_text =="believer") {
                    val anim =
                        TranslateAnimation(place3.x - believer.x, 0f, place3.y - believer.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place3.x - 225f) - strong_text.x,
                        0f,
                        (place3.y-55f) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    place_3_text =""
                    believer_count = 0
                    believer.rotation=0f
                    believer_text.startAnimation(anim_text)
                    believer.startAnimation(anim)
                    isbelieverRunning = false
                }
                place3isempty = true
            }
            true
        }
        place4.setOnLongClickListener {
            if(place4isempty==false) {
                if (isrichRunning == true && place_4_text =="rich") {
                    val anim =
                        TranslateAnimation(place4.x - 7f - rich.x, 0f, place4.y + 10f - rich.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place4.x + 62f) - rich_text.x,
                        0f,
                        (75f + place4.y) - rich_text.y,
                        0f
                    )
                    rich.rotation=0f
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4_text =""
                    rich_count = 0
                    rich.startAnimation(anim)
                    rich_text.startAnimation(anim_text)
                    isrichRunning = false
                } else if (isstrongRunning == true && place_4_text =="strong") {
                    val anim = TranslateAnimation(place4.x - 7f - strong.x, 0f, place4.y + 17f - strong.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place4.x + 60f) - strong_text.x,
                        0f,
                        (112f + place4.y) - strong_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_4_text =""
                    strong_count = 0
                    strong.startAnimation(anim)
                    strong_text.startAnimation(anim_text)
                    isstrongRunning = false
                } else if (issmartRunning == true && place_4_text =="smart") {
                    val anim =
                        TranslateAnimation(place4.x - smart.x, 0f, place4.y - smart.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place4.x - 85f) - strong_text.x,
                        0f,
                        (140f + place4.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration =1000
                    anim_text.fillAfter =true
                    smart.rotation = 0f
                    place_4_text =""
                    smart_count = 0
                    smart_text.startAnimation(anim_text)
                    smart.startAnimation(anim)
                    issmartRunning = false
                } else if (isbeautifulRunning == true && place_4_text =="beautiful") {
                    val anim =
                        TranslateAnimation(place4.x - beautiful.x, 0f, place4.y - beautiful.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place4.x - 225f) - strong_text.x,
                        0f,
                        (100f + place4.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    beautiful_count = 0
                    beautiful.startAnimation(anim)
                    beautiful_text.startAnimation(anim_text)
                    place_4_text =""
                    isbeautifulRunning = false
                    beautiful.rotation = 0f
                } else if (isbelieverRunning == true && place_4_text =="believer") {
                    val anim =
                        TranslateAnimation(place4.x - believer.x, 0f, place4.y - believer.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place4.x - 225f) - strong_text.x,
                        0f,
                        (place4.y-55f) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    place_4_text =""
                    believer_count = 0
                    believer.rotation=0f
                    believer_text.startAnimation(anim_text)
                    believer.startAnimation(anim)
                    isbelieverRunning = false
                }
                place4isempty = true
            }
            true
        }
        place5.setOnLongClickListener {
            if(place5isempty==false) {
                if (isrichRunning == true && place_5_text =="rich") {
                    val anim =
                        TranslateAnimation(place5.x - 7f - rich.x, 0f, place5.y + 10f - rich.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place5.x + 62f) - rich_text.x,
                        0f,
                        (75f + place5.y) - rich_text.y,
                        0f
                    )
                    rich.rotation=0f
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5_text =""
                    rich_count = 0
                    rich.startAnimation(anim)
                    rich_text.startAnimation(anim_text)
                    isrichRunning = false
                } else if (isstrongRunning == true && place_5_text =="strong") {
                    val anim = TranslateAnimation(place5.x - 7f - strong.x, 0f, place5.y + 17f - strong.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place5.x + 60f) - strong_text.x,
                        0f,
                        (112f + place5.y) - strong_text.y,
                        0f
                    )
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    anim.duration = 1000
                    anim.fillAfter = true
                    place_5_text =""
                    strong_count = 0
                    strong.rotation = 0f
                    strong.startAnimation(anim)
                    strong_text.startAnimation(anim_text)
                    isstrongRunning = false
                } else if (issmartRunning == true && place_5_text =="smart") {
                    val anim =
                        TranslateAnimation(place5.x - smart.x, 0f, place5.y - smart.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place5.x - 85f) - strong_text.x,
                        0f,
                        (140f + place5.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration =1000
                    anim_text.fillAfter =true
                    smart.rotation = 0f
                    place_5_text =""
                    smart_count = 0
                    smart_text.startAnimation(anim_text)
                    smart.startAnimation(anim)
                    issmartRunning = false
                } else if (isbeautifulRunning == true && place_5_text =="beautiful") {
                    val anim =
                        TranslateAnimation(place5.x - beautiful.x, 0f, place5.y - beautiful.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place5.x - 225f) - strong_text.x,
                        0f,
                        (100f + place5.y) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    beautiful_count = 0
                    beautiful.startAnimation(anim)
                    beautiful_text.startAnimation(anim_text)
                    place_5_text =""
                    isbeautifulRunning = false
                    beautiful.rotation = 0f
                } else if (isbelieverRunning == true && place_5_text =="believer") {
                    val anim =
                        TranslateAnimation(place5.x - believer.x, 0f, place5.y - believer.y, 0f)
                    val anim_text = TranslateAnimation(
                        (place5.x - 225f) - strong_text.x,
                        0f,
                        (place5.y-55f) - strong_text.y,
                        0f
                    )
                    anim.duration = 1000
                    anim.fillAfter = true
                    anim_text.duration = 1000
                    anim_text.fillAfter = true
                    place_5_text =""
                    believer_count = 0
                    believer.rotation=0f
                    believer_text.startAnimation(anim_text)
                    believer.startAnimation(anim)
                    isbelieverRunning = false
                }
                place5isempty = true
            }
            true
        }
        button.setOnClickListener {
            var arr = searching_tool.searching(rich_count,strong_count,smart_count,beautiful_count,believer_count,"man")
            name.setText(arr[0])
            meaning.setText(arr[1])
            character_type.setText(arr[2])
            ending.visibility = View.VISIBLE
        }
        ending.setOnLongClickListener {
            ending.visibility = View.INVISIBLE
            meaning.setText("")
            name.setText("")
            character_type.setText("")
            true
        }
    }

}