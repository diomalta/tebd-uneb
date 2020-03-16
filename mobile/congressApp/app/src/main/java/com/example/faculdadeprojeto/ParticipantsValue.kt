package com.example.faculdadeprojeto

import java.util.*
import kotlin.collections.ArrayList

class ParticipantsValue {
    val id: String?
    val name: String
    val telephone: String
    val address: Map<String, String?>?
    val cards: ArrayList<Card>?


    constructor(id: String?, name: String, telephone: String, address: Map<String, String?>, cards: ArrayList<Card>) {
        this.id = id
        this.name = name
        this.cards = cards
        this.telephone = telephone
        this.address = address
    }

    override fun toString(): String {
        return name
    }

}

data class Card(val name: String, val number: String, val flag: String, val ccv: String, val due: String) {

}