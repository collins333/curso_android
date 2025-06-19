package com.collins.cursoandroid.horoscopo.ui.horoscopo.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo

class HoroscopoAdaptador(private var horoscopoList: List<HoroscopoInfo> = emptyList(), private val itemSeleccionado: (HoroscopoInfo) -> Unit): RecyclerView.Adapter<HoroscopoViewHolder>(){

    fun actualizarLista(lista: List<HoroscopoInfo>) {
        horoscopoList = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo , parent, false)
        )
    }

    override fun getItemCount() = horoscopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position], itemSeleccionado)
    }
}