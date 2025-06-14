package com.collins.cursoandroid.tareasApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R

class AdaptadorCategorias(private val categorias:List<TareasCategorias>, private val alSeleccionarItem: (Int) -> Unit):
    RecyclerView.Adapter<ViewHolderCategorias>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategorias {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tareas_categorias, parent, false)
        return ViewHolderCategorias(view)
    }

    override fun getItemCount() = categorias.size

    override fun onBindViewHolder(holder: ViewHolderCategorias, position: Int) {
        holder.render(categorias[position], alSeleccionarItem)
    }
}