package com.collins.cursoandroid.primeraApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.collins.cursoandroid.R

class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo_actitity)

        val saludo = findViewById<TextView>(R.id.saludo)
        val nombre: String = intent.extras?.getString("EXTRA_NOMBRE").orEmpty()
        saludo.text = "Hola $nombre"
    }
}