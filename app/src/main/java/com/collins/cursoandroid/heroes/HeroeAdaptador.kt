package com.collins.cursoandroid.heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R

class HeroeAdaptador(
    var listaHeroes: List<ItemRespuestaHeroes> = emptyList(),
    private val itemSeleccionado: (String) -> Unit
):
    RecyclerView.Adapter<HeroeViewHolder> () {

    fun actualizarLista(listaHeroes: List<ItemRespuestaHeroes>) {
        this.listaHeroes = listaHeroes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroeViewHolder {
        return HeroeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_heroes, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: HeroeViewHolder, position: Int) {
       viewHolder.bind(listaHeroes[position], itemSeleccionado)
    }

    override fun getItemCount() = listaHeroes.size
}