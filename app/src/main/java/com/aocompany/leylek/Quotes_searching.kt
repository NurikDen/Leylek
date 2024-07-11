package com.aocompany.leylek

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import java.util.*


class Quotes_searching {
    fun quotes_searching(doc : Document): MutableList<String> {
        val nodeList = doc.getElementsByTagName("quote")
        val randomQuoteIndex = Random().nextInt((nodeList.length)-1)
        val randomQuoteNode = nodeList.item(randomQuoteIndex)
        val famousPeople = mutableListOf<String>()
        val author = randomQuoteNode.getSingleChild("author")?.textContent.toString()
        val text = randomQuoteNode.getSingleChild("text")?.textContent.toString()
        famousPeople.add(author)
        famousPeople.add(text)
        return famousPeople
    }
    fun Node.getSingleChild(tagName: String): Node? {
        val nodeList = this.childNodes
        for (i in 0 until nodeList.length) {
            if (nodeList.item(i).nodeName == tagName) {
                return nodeList.item(i)
            }
        }
        return null
    }
}