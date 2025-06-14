package com.collins.cursoandroid.recyclerView.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.collins.cursoandroid.R
import com.collins.cursoandroid.databinding.ItemRecyclerviewHeroesBinding
import com.collins.cursoandroid.recyclerView.Heroe

class ViewHolderHeroe(view: View): RecyclerView.ViewHolder(view) {
//    val heroe = view.findViewById<TextView>(R.id.tvHeroe)
//    val imagen = view.findViewById<ImageView>(R.id.ivHeroe)
//    val editorial = view.findViewById<TextView>(R.id.tvEditorial)
//    val nombreReal = view.findViewById<TextView>(R.id.tvNombreReal)

//    fun render (heroeModel: Heroe) {
//        heroe.text = heroeModel.heroe
//        editorial.text = heroeModel.editorial
//        nombreReal.text = heroeModel.nombreReal
//        Glide.with(imagen.context)
//             .load(heroeModel.foto)
//             .diskCacheStrategy(DiskCacheStrategy.ALL)
//             .centerCrop()
//             .into(imagen)
//    }

    //UTILIZANDO VIEWBINDING
    val binding = ItemRecyclerviewHeroesBinding.bind(view)

    fun render (heroeModel: Heroe, onClickListener: (Heroe)-> Unit) {
        binding.tvHeroe.text = heroeModel.heroe
        binding.tvEditorial.text = heroeModel.editorial
        binding.tvNombreReal.text = heroeModel.nombreReal
        Glide.with(binding.ivHeroe.context)
            .load(heroeModel.foto)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.ivHeroe)

        //AÑADIR UNA ACCION(CREAR UN TOAST EN ESTE CASO) AL CLICAR SOBRE LA IMAGEN
//        binding.ivHeroe.setOnClickListener{
//            Toast.makeText(
//                binding.ivHeroe.context,
//                heroeModel.nombreReal,
//                Toast.LENGTH_SHORT
//            )
//                .show()
//        }

        //AQUI AL CLICAR EN TODO EL ITEM
//        itemView.setOnClickListener{
//            Toast.makeText(
//                binding.ivHeroe.context,
//                heroeModel.heroe,
//                Toast.LENGTH_SHORT
//            )
//                .show()
//        }

        //PASAMOS TODO EL OBJETO HEROE AL CLICAR EN EL ITEM (FUNCION LAMBDA)
            itemView.setOnClickListener { onClickListener(heroeModel) }
    }
}