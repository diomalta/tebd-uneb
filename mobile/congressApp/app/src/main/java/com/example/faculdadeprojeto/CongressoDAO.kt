package com.example.faculdadeprojeto

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException
import java.time.LocalDateTime
import java.util.*


class CongressoDAO(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, "CongressDB", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val ddl1 = "DROP TABLE IF EXISTS Participants"
        db?.execSQL(ddl1)


        val ddl = "CREATE TABLE Participants (id TEXT PRIMARY KEY, name TEXT NOT NULL, telephone TEXT NOT NULL)"
        db?.execSQL(ddl)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val ddl = "DROP	TABLE IF EXISTS	Participants"
        db.execSQL(ddl)
        onCreate(db)
    }

    fun saveEachParticipant(participant: ParticipantsValue) {
        val values = ContentValues()
        values.put("name", participant.name)
        values.put("telephone", participant.telephone)
        values.put("id", participant.name + participant.telephone)

        writableDatabase.insert("Participants", null, values)

    }

    fun removeDisciplina(disciplinaValue: ParticipantsValue) {
        val values: Array<String> = arrayOf(disciplinaValue.id.toString())
        writableDatabase.delete("Disciplina", "id = ?", values)
    }

    fun saveParticipants(participantList: List<ParticipantsValue>) {
        participantList.forEach { p -> saveEachParticipant(p) }
    }

    fun getParticipants(): ArrayList<ParticipantsValue> {
        val allClasses = ArrayList<ParticipantsValue>()
        val query = "SELECT	* FROM Participants order by name"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val participant = ParticipantsValue(id = cursor.getString(0),
                    name = cursor.getString(1),
                    telephone = cursor.getString(2),
                    address = mapOf("endereco" to "rua"),
                    cards = arrayListOf(Card(name = "", number = "", ccv = "", due = "", flag = ""))
                )
                allClasses.add(participant)
            } while (cursor.moveToNext())
        }

        return allClasses
    }

}