package com.collins.cursoandroid.heroes

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collins.cursoandroid.R
import com.collins.cursoandroid.databinding.ActivityDetallesHeroeBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetallesHeroeActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetallesHeroeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesHeroeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        crearInformacionHeroe(id)
    }

    private fun crearInformacionHeroe(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val detalleHeroe = crearRetrofit().create(ServicioApis::class.java).crearDetalleHeroe(id)

            if(detalleHeroe.body() != null) {
                runOnUiThread {
                    crearUI(detalleHeroe.body()!!)
                }
            }
        }
    }

    private fun crearUI(heroe: RespuestaDetalles) {
        Glide.with(binding.ivHeroe.context).load(heroe.imagen.url).into(binding.ivHeroe)
        //Picasso.with(binding.ivHeroe.context).load(heroe.imagen.url).into(binding.ivHeroe)
        binding.tvNombre.text = heroe.nombre
        binding.tvNombreReal.text = heroe.biografia.nombreReal
        binding.tvEditorial.text = heroe.biografia.editorial

        crearPoderes(heroe.poderes)
    }

    private fun crearPoderes(poderesHeroe: RespuestaPoderes) {
        actualizarAltura(binding.vInteligencia, poderesHeroe.inteligencia)
        actualizarAltura(binding.vFortaleza, poderesHeroe.fortaleza)
        actualizarAltura(binding.vVelocidad, poderesHeroe.velocidad)
        actualizarAltura(binding.vDurabilidad, poderesHeroe.durabilidad)
        actualizarAltura(binding.vPoder, poderesHeroe.poder)
        actualizarAltura(binding.vCombate, poderesHeroe.combate)
    }

    private fun actualizarAltura(view: View, valor: String) {
        val parametros = view.layoutParams
        parametros.height = pixelADp(valor.toFloat())
        view.layoutParams = parametros
    }

    private fun pixelADp(px: Float):Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    private fun crearRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}