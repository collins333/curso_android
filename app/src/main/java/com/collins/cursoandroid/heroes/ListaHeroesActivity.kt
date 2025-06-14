package com.collins.cursoandroid.heroes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.collins.cursoandroid.databinding.ActivityListaHeroesBinding
import com.collins.cursoandroid.heroes.DetallesHeroeActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaHeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaHeroesBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adaptador: HeroeAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaHeroesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = crearRetrofit()
        initUI()
    }
    
    private fun initUI() {
        binding.svListaHeroes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                buscarNombre(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adaptador = HeroeAdaptador { heroeId -> navegarADetalle(heroeId) }
        binding.rvHeroe.setHasFixedSize(true)
        binding.rvHeroe.layoutManager = LinearLayoutManager(this)
        binding.rvHeroe.adapter = adaptador
    }

    private fun buscarNombre(query: String) {
        binding.pb.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val miRespuesta: Response<RespuestaDatos> = retrofit.create(ServicioApis::class.java).crearHeroes(query)

            if(miRespuesta.isSuccessful) {
                Log.i("prueba", "está funcionando")
                val respuesta: RespuestaDatos? = miRespuesta.body()
                if(respuesta != null) {
                    Log.i("prueba", respuesta.toString())
                    runOnUiThread {
                        adaptador.actualizarLista(respuesta.heroes)
                        binding.pb.isVisible = false
                    }
                }
            } else {
                Log.i("prueba", "no funcionó")
            }
        }
    }

    private fun crearRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navegarADetalle(id: String) {
        val intent = Intent(this, DetallesHeroeActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}