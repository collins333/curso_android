package com.collins.cursoandroid.imcApp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.collins.cursoandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class imcCalculadorActivity : AppCompatActivity() {

    private var esHombreSeleccionado: Boolean = true
    private var esMujerSeleccionada: Boolean = false
    private var alturaActual: Int = 120
    private var pesoActual: Int = 60
    private var edadActual: Int = 30

    private lateinit var hombre: CardView
    private lateinit var mujer: CardView
    private lateinit var altura: TextView
    private lateinit var slider: RangeSlider
    private lateinit var btnRestarPeso: FloatingActionButton
    private lateinit var btnSumarPeso: FloatingActionButton
    private lateinit var tvPeso: TextView
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var tvEdad: TextView
    private lateinit var calcular: Button

    companion object {
        const val IMC_CLAVE = "IMC_RESULTADO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculador)
        iniciarComponentes()
        iniciarEscuchas()
        iniciarUI()
    }

    private fun iniciarComponentes() {
        hombre = findViewById(R.id.hombre)
        mujer = findViewById(R.id.mujer)
        altura = findViewById(R.id.altura)
        slider = findViewById(R.id.slider)
        btnSumarPeso = findViewById(R.id.btnSumarPeso)
        btnRestarPeso = findViewById(R.id.btnRestarPeso)
        tvPeso = findViewById(R.id.tvPeso)
        btnSumarEdad = findViewById(R.id.btnSumarEdad)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        tvEdad = findViewById(R.id.tvEdad)
        calcular = findViewById(R.id.calcular)
    }

    private fun iniciarEscuchas() {
        hombre.setOnClickListener {
            cambiarGenero()
            cambiarColorGenero()
        }
        mujer.setOnClickListener {
            cambiarGenero()
            cambiarColorGenero()
        }
        slider.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            alturaActual = df.format(value).toInt()
            altura.text = "$alturaActual cm"
        }
        btnSumarPeso.setOnClickListener {
            pesoActual += 1
            cambiarPeso()
        }
        btnRestarPeso.setOnClickListener {
            pesoActual -= 1
            cambiarPeso()
        }
        btnSumarEdad.setOnClickListener {
            edadActual += 1
            cambiarEdad()
        }
        btnRestarEdad.setOnClickListener {
            edadActual -= 1
            cambiarEdad()
        }
        calcular.setOnClickListener {
            val resultado = calcularIMC()
            navegarAResultado(resultado)
        }
    }

    private fun cambiarGenero() {
        esHombreSeleccionado = !esHombreSeleccionado
        esMujerSeleccionada = !esMujerSeleccionada
    }

    private fun cambiarColorGenero() {
        hombre.setCardBackgroundColor(cambiarColorFondo(esHombreSeleccionado))
        mujer.setCardBackgroundColor(cambiarColorFondo(esMujerSeleccionada))
    }

    private fun cambiarColorFondo(esSeleccionadoComponente: Boolean): Int {
        val colorReferencia = if (esSeleccionadoComponente) {
            R.color.background_component_selected

        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReferencia)
    }

    private fun cambiarPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun cambiarEdad() {
        tvEdad.text = "$edadActual años"
    }

    private fun calcularIMC(): String {
        val df = DecimalFormat("#.##")
        val imc = pesoActual / (alturaActual.toDouble()/100 * alturaActual.toDouble()/100)
        val resultado = df.format(imc)
        //Log.i("masa", "su imc es $resultado")
       return resultado
    }

    private fun navegarAResultado(resultado: String) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra(IMC_CLAVE, resultado)
        startActivity(intent)
    }

    private fun iniciarUI() {
        cambiarColorGenero()
        cambiarPeso()
        cambiarEdad()
    }
}