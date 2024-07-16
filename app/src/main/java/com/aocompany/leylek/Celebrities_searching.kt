package com.aocompany.leylek

import org.w3c.dom.Document
import org.w3c.dom.Element

class Celebrities_searching {
    fun celebrities_searching(doc : Document, name : String): MutableList<String>{
        val famousPeople = mutableListOf<String>()
        val nodeIndex = doc.getElementsByTagName("list").length
        var nameIndex = 0
        for (i in 0 until nodeIndex) {
            val node = doc.getElementsByTagName("list").item(i).childNodes.item(1).textContent
            if (node.equals(name)) {
                nameIndex = i
                break
            }
        }
        val personNodes = doc.getElementsByTagName("list").item(nameIndex).childNodes

        var personBefore = ""
        var personAfter = ""
        for (i in 0 until personNodes.length) {
            val node = personNodes.item(i)
            if (node is Element && node.tagName != "name" && node.textContent.contains(name)) {
                val dashIndex = node.textContent.indexOf("(")
                personBefore = node.textContent.substring(0, dashIndex).trim()
                personAfter = node.textContent.substring(dashIndex).trim()
                famousPeople.add(personBefore)
                famousPeople.add(personAfter)
            }
        }
        return famousPeople
    }
}