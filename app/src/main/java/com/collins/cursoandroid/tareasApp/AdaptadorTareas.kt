package com.collins.cursoandroid.tareasApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R

class AdaptadorTareas(var tareas:List<Tarea>, private val alSeleccionarItem: (Int) -> Unit):
    RecyclerView.Adapter<ViewHolderTareas>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTareas {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tareas_tasks, parent, false)
        return ViewHolderTareas(view)
    }

    override fun getItemCount() = tareas.size

    override fun onBindViewHolder(holder: ViewHolderTareas, position: Int) {
        holder.render(tareas[position])
        holder.itemView.setOnClickListener { alSeleccionarItem(position) }
    }
}