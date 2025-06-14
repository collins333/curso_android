package com.collins.cursoandroid.tareasApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R
import com.collins.cursoandroid.tareasApp.TareasCategorias.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TareasActivity : AppCompatActivity() {

    private val categorias = listOf(
        Negocios,
        Personal,
        Otros
    )

    private val tareas = mutableListOf(
        Tarea("tareaNegocios", Negocios),
        Tarea("tareaPersonal", Personal),
        Tarea("tareaOtros", Otros)
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var adaptadorCategorias: AdaptadorCategorias

    private lateinit var rvTasks: RecyclerView
    private lateinit var adaptadorTareas: AdaptadorTareas

    private lateinit var btnAddTasks: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tareas)

        iniciarComponentes()
        iniciarUI()
        iniciarEscuchas()
    }

    private fun iniciarEscuchas() {
        btnAddTasks.setOnClickListener { mostrarDialogo() }
    }

    private fun mostrarDialogo() {
        val dialogo = Dialog(this)
        dialogo.setContentView(R.layout.tareas_dialogo)

        val btnCrearTareas: Button = dialogo.findViewById(R.id.btnCrearTareas)
        val etTareas: EditText = dialogo.findViewById(R.id.etTareas)
        val rgCategorias: RadioGroup = dialogo.findViewById(R.id.rgCategorias)

        btnCrearTareas.setOnClickListener {
            val tareaActual = etTareas.text.toString()
            if(tareaActual.isNotEmpty()) {
                val idSeleccionado = rgCategorias.checkedRadioButtonId
                val radioBotonSeleccionado: RadioButton = rgCategorias.findViewById(idSeleccionado)
                val categoriaActual: TareasCategorias = when(radioBotonSeleccionado.text) {
                    getString(R.string.tareas_business) -> Negocios
                    getString(R.string.tareas_personal) -> Personal
                    else -> Otros
                }

                tareas.add(Tarea(tareaActual, categoriaActual))
                actualizarTareas()
                dialogo.hide()
            }
        }

        dialogo.show()
    }

    private fun iniciarComponentes() {
        rvCategorias = findViewById(R.id.rvCategorias)
        rvTasks = findViewById(R.id.rvTasks)
        btnAddTasks = findViewById(R.id.btnAddTasks)
    }

    private fun iniciarUI() {
        adaptadorCategorias = AdaptadorCategorias(categorias) {posicion -> actualizarCategorias(posicion)}
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = adaptadorCategorias

        adaptadorTareas = AdaptadorTareas(tareas) {posicion -> alSeleccionarItem(posicion)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = adaptadorTareas
    }

    private fun alSeleccionarItem(posicion: Int) {
        tareas[posicion].isSelected = !tareas[posicion].isSelected
        actualizarTareas()
    }

    private fun actualizarCategorias(posicion: Int) {
        categorias[posicion].estaSeleccionada = !categorias[posicion].estaSeleccionada
        adaptadorCategorias.notifyItemChanged(posicion)
        actualizarTareas()
    }

    private fun actualizarTareas() {
        val categoriasSeleccionadas: List<TareasCategorias> = categorias.filter { it.estaSeleccionada }
        val nuevasTareas = tareas.filter { categoriasSeleccionadas.contains(it.categoria) }

        adaptadorTareas.tareas = nuevasTareas
        adaptadorTareas.notifyDataSetChanged()
    }
}