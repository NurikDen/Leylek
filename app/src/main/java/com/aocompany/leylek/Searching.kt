package com.aocompany.leylek
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Document
import java.util.Random
import javax.xml.parsers.DocumentBuilderFactory

class Searching: AppCompatActivity(){
    fun searching(
        rich_int: Int,
        strong_int: Int,
        smart_happy_int: Int,
        beautiful_int: Int,
        believer_int: Int, gender: String
    ): ArrayList<String> {
        var random = Random()
        val nameMap = HashMap<String, Int>()
        val characterMap = HashMap<String, String>()
        val final_characters_Map = HashMap<String, String>()
        var final_characters = ""
        val filePath = "man_names.xml"
        var name: String
        var number_of_character = 0
        var meaning_text: String
        val randint_1 = random.nextInt(165)
        val randint_2 = randint_1 + 25
        val total = rich_int + strong_int + smart_happy_int + beautiful_int + believer_int
        val context: Context? = null
        val document = getXmlDocument(filePath)
        var smart:Int
        val nameNodes = document!!.getElementsByTagName("name")
        for (i in randint_1 until randint_2) {
            val name = nameNodes.item(i).textContent
            val nodes = document.getElementsByTagName("character")
            val character = nodes.item(i).textContent
            val rich = getValueForTag(document, "rich", i) * rich_int
            val strong = getValueForTag(document, "strong", i) * strong_int
            if (gender == "man") {
                smart = getValueForTag(document, "smart", i) * smart_happy_int
            } else {
                smart = getValueForTag(document, "happy", i) * smart_happy_int
            }
            val beautiful = getValueForTag(document, "beautiful", i) * beautiful_int
            val believer = getValueForTag(document, "believer", i) * believer_int
            if (rich > 0) {
                if (number_of_character == 0) {
                    final_characters += "Бай";
                    number_of_character = 1;
                } else if (number_of_character == 1) {
                    final_characters += ", Бай";
                }
            }
            if (strong > 0) {
                if (gender.equals("man")) {
                    if (number_of_character == 0) {
                        final_characters += "Көчле";
                        number_of_character = 1;
                    } else if (number_of_character == 1) {
                        final_characters += ", Көчле";
                    }
                } else {
                    if (number_of_character == 0) {
                        final_characters += "Бәхетле";
                        number_of_character = 1;
                    } else if (number_of_character == 1) {
                        final_characters += ", Бәхетле";
                    }
                }

            }
            if (smart > 0) {
                if (number_of_character == 0) {
                    final_characters += "Акыллы";
                    number_of_character = 1;
                } else if (number_of_character == 1) {
                    final_characters += ", Акыллы";
                }
            }
            if (beautiful > 0) {
                if (number_of_character == 0) {
                    final_characters += "Матур";
                    number_of_character = 1;
                } else if (number_of_character == 1) {
                    final_characters += ", Матур";
                }
            }
            if (believer > 0) {
                if (number_of_character == 0) {
                    final_characters += "Иманлы";
                    number_of_character = 1;
                } else if (number_of_character == 1) {
                    final_characters += ", Иманлы";
                }
            }


            val totalScore =
                rich + strong + smart + beautiful + believer
            nameMap[name] = totalScore
            characterMap[name] = character
            final_characters_Map[name] = final_characters
            final_characters = ""
            number_of_character = 0
        }
        val arr: ArrayList<String> = ArrayList()
        for ((key) in nameMap) {
            if (nameMap[key]!! >= total / 2) {
                arr.add(key)
            }
        }
        val random_name = random.nextInt(arr.size / 2)
        arr.sort()
        arr.reverse()
        name = arr[random_name]
        var total_array = ArrayList<String>()
        total_array.add(name)
        total_array.add(characterMap[name].toString())
        total_array.add(final_characters_Map[name].toString())
        return total_array
    }


    fun getXmlDocument(filename: String): Document? {
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