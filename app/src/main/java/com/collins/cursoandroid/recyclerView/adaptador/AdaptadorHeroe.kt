package com.collins.cursoandroid.recyclerView.adaptador

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R
import com.collins.cursoandroid.recyclerView.Heroe

class AdaptadorHeroe(private val listaHeroes:List<Heroe>, private val onClickListener: (Heroe)-> Unit): RecyclerView.Adapter<ViewHolderHeroe>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHeroe {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderHeroe(layoutInflater.inflate(R.layout.item_recyclerview_heroes, parent, false))
    }

//    override fun getItemCount(): Int {
//        return listaHeroes.size
//    }

    override fun getItemCount(): Int = listaHeroes.size

    override fun onBindViewHolder(holder: ViewHolderHeroe, position: Int) {
        val item = listaHeroes[position]
        holder.render(item, onClickListener)
    }
}