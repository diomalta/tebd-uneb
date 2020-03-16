package com.example.faculdadeprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    private val ddao = CongressoDAO(this, null, null, 1)
    private lateinit var btnSave: Button
    private lateinit var disciplinaText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        btnSave = findViewById(R.id.btnCreateClass)
        disciplinaText = findViewById(R.id.classDescription)

        btnSave.setOnClickListener {
//            ddao.saveDisciplina(ParticipantsValue(disciplina = disciplinaText.text.toString(), id = null))
            val intent = Intent(this@FormActivity, DisciplinaActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

    }

}