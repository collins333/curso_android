package com.collins.cursoandroid.imcApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.collins.cursoandroid.R
import com.collins.cursoandroid.imcApp.imcCalculadorActivity.Companion.IMC_CLAVE

class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var calcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val imc: String = intent.extras?.getString(IMC_CLAVE) ?: "-1.0"
        iniciarComponentes()
        iniciarUI(imc)
        iniciarEscuchas()
    }

    private fun iniciarComponentes() {
        tvResultado = findViewById(R.id.tvResultado)
        tvImc = findViewById(R.id.tvImc)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        calcular = findViewById(R.id.calcular)
    }

    private fun iniciarEscuchas() {
        calcular.setOnClickListener { onBackPressed() }
    }

    private fun iniciarUI(imc: String) {
        tvImc.text = "$imc"
        when(imc) {
            in "0.00".."18.50" -> {//bajo peso
                tvResultado.text = getString(R.string.bajo_peso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescripcion.text = getString(R.string.descrip_bajo_peso)
            }
            in "18.51".."24.99" -> {//peso normal
                tvResultado.text = getString(R.string.normal_peso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescripcion.text = getString(R.string.descrip_normal_peso)
            }
            in "25.00".."29.99" -> {//sobrepeso
                tvResultado.text = getString(R.string.sobrepeso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescripcion.text = getString(R.string.descrip_sobrepeso)
            }
            in "30.00".."99.00" -> {//obesidad
                tvResultado.text = getString(R.string.obeso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescripcion.text = getString(R.string.descrip_obeso)
            }
            else -> {//error
                tvResultado.text  = getString(R.string.error)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvImc.text = getString(R.string.error)
                tvDescripcion.text = getString(R.string.error)
            }
        }
    }
}