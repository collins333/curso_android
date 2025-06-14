package com.collins.cursoandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.collins.cursoandroid.configuraciones.ConfiguracionesActivity
import com.collins.cursoandroid.databinding.ActivityMenuBinding
import com.collins.cursoandroid.ejerciciosLayout.ConstraintLayoutActivity
import com.collins.cursoandroid.ejerciciosLayout.FrameLayoutActivity
import com.collins.cursoandroid.ejerciciosLayout.LinearLayoutActivity
import com.collins.cursoandroid.heroes.ListaHeroesActivity
import com.collins.cursoandroid.horoscopo.ui.home.HoroscopoActivity
import com.collins.cursoandroid.imcApp.imcCalculadorActivity
import com.collins.cursoandroid.primeraApp.primeraAppActivity
import com.collins.cursoandroid.recyclerView.EjemploRecyclerViewActivity
import com.collins.cursoandroid.tareasApp.TareasActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_menu)
//        val btnSaludo = findViewById<AppCompatButton>(R.id.btnSaludo)
//        val btnFrame = findViewById<AppCompatButton>(R.id.btnFrame)
//        val btnLinear = findViewById<AppCompatButton>(R.id.btnLinear)
//        val btnConstraint = findViewById<AppCompatButton>(R.id.btnConstraint)
//        val btnIMC = findViewById<AppCompatButton>(R.id.btnIMC)
//        val btnTareas = findViewById<AppCompatButton>(R.id.btnTareas)
//        val btnHeroes = findViewById<AppCompatButton>(R.id.btnHeroes)
//        val btnRecyclerView = findViewById<AppCompatButton>(R.id.btnRecyclerView)
//        val btnConfiguraciones = findViewById<AppCompatButton>(R.id.btnConfiguraciones)

        binding.btnSaludo.setOnClickListener { navegarToSaludo() }
        binding.btnFrame.setOnClickListener { navegarToFrame() }
        binding.btnLinear.setOnClickListener { navegarToLinear() }
        binding.btnConstraint.setOnClickListener { navegarToConstraint() }
        binding.btnIMC.setOnClickListener { navegarToIMC() }
        binding.btnTareas.setOnClickListener { navegarToTareas() }
        binding.btnHeroes.setOnClickListener { navegarToHeroes() }
        binding.btnRecyclerView.setOnClickListener { navegarToRecyclerView() }
        binding.btnConfiguraciones.setOnClickListener { navegarToConfiguraciones() }
        binding.btnHoroscopos.setOnClickListener { navegarToHoroscopos() }
    }

    private fun navegarToConfiguraciones() {
        val intent = Intent(this, ConfiguracionesActivity::class.java)
        startActivity((intent))
    }

    private fun navegarToRecyclerView() {
        val intent = Intent(this, EjemploRecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToHeroes() {
        val intent = Intent(this, ListaHeroesActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToTareas() {
        val intent = Intent(this, TareasActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToIMC() {
        val intent = Intent(this, imcCalculadorActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToSaludo() {
        val intent = Intent(this, primeraAppActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToFrame() {
        val intent = Intent(this, FrameLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToLinear() {
        val intent = Intent(this, LinearLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToConstraint() {
        val intent = Intent(this, ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun navegarToHoroscopos() {
        val intent = Intent(this, HoroscopoActivity::class.java)
        startActivity(intent)
    }

}