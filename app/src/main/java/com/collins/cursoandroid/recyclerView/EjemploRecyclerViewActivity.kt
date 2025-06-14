package com.collins.cursoandroid.recyclerView

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R
import com.collins.cursoandroid.databinding.ActivityEjemploRecyclerViewBinding
import com.collins.cursoandroid.recyclerView.adaptador.AdaptadorHeroe

class EjemploRecyclerViewActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_ejemplo_recycler_view)
//        iniciarRecyclerView()
//    }

//    private fun iniciarRecyclerView () {
//        val recyclerView = findViewById<RecyclerView>(R.id.rvHeroes)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = AdaptadorHeroe(ProveedorHeroes.listaHeroes)
//    }

    // UTILIZANDO VIEWBINDING
    private lateinit var binding: ActivityEjemploRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjemploRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarRecyclerView()
    }

    private fun iniciarRecyclerView () {
        val manager = LinearLayoutManager(this)

        //PARA PONER LOS ITEMS EN VARIAS COLUMNAS, EN ESTE CASO 2
        //val manager = GridLayoutManager(this, 2)

        binding.rvHeroes.layoutManager = manager
        binding.rvHeroes.adapter = AdaptadorHeroe(ProveedorHeroes.listaHeroes) {
                                        heroe ->  alSeleccionarItem(heroe) }

        //PARA AÑADIR LINEA DIVISORIA ENTRE LOS ITEMS
        //val divisor = DividerItemDecoration(this, manager.orientation)

        //binding.rvHeroes.addItemDecoration(divisor)
    }

    private fun alSeleccionarItem(heroe: Heroe) {
        Toast.makeText(this, heroe.nombreReal, Toast.LENGTH_SHORT).show()
    }

}