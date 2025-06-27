package com.collins.cursoandroid.heroes

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collins.cursoandroid.databinding.ItemHeroesBinding
import com.squareup.picasso.Picasso

class HeroeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHeroesBinding.bind(view)

    fun bind(itemRespuestaHeroes: ItemRespuestaHeroes, itemSeleccionado: (String) -> Unit) {
        binding.tvHeroeNombre.text = itemRespuestaHeroes.heroeNombre
        Glide.with(binding.ivHeroe.context).load(itemRespuestaHeroes.heroeImagen.url).into(binding.ivHeroe)
        //Picasso.with(binding.ivHeroe.context).load(itemRespuestaHeroes.heroeImagen.url).into(binding.ivHeroe)
        binding.root.setOnClickListener { itemSeleccionado(itemRespuestaHeroes.heroeId) }
    }
}