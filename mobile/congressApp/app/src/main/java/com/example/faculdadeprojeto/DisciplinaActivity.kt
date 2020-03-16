package com.example.faculdadeprojeto

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.R.layout
import android.view.*
import android.widget.AdapterView
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class DisciplinaActivity: AppCompatActivity() {
    private lateinit var listView: ListView
    private val ddao = CongressoDAO(this, null, null, 1)
    private lateinit var selectedDisciplina: ParticipantsValue

    fun fetchJson() {
        val url = "http://172.17.72.97:3333/api/participants-to-transfer"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val resultJson = gson.fromJson(body, ParserResult::class.java).result

                runOnUiThread {
                    updateListView(resultJson)
                }

                ddao.saveParticipants(resultJson)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Deu ruim")
            }
        })

    }

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.disciplina)
        registerForContextMenu(findViewById(R.id.listView))

//        this.deleteDatabase("CongressDB")

        listView = findViewById(R.id.listView)

        updateListView(ddao.getParticipants())

        fetchJson()
        ddao.close()
    }

    private fun updateListView(items: List<ParticipantsValue>) {
        listView.adapter = ArrayAdapter<ParticipantsValue>(this, layout.simple_list_item_1, items)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View,
                                     menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.float_menu , menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.action_update -> {
                fetchJson()
                Toast.makeText(this,"Atualizou a disciplina" + item.itemId, Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_delete -> {
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

}

class ParserResult(val result: List<ParticipantsValue>)