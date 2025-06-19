package com.collins.cursoandroid.horoscopo.ui.horoscopo.adaptador

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.databinding.ItemHoroscopoBinding
import com.collins.cursoandroid.horoscopo.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, itemSeleccionado: (HoroscopoInfo) -> Unit) {

        val context = binding.tvTitulo.context

        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvTitulo.text = context.getString(horoscopoInfo.nombre)

        binding.clParent.setOnClickListener {
            empezarRotacion(binding.ivHoroscopo, nuevaLambda = {itemSeleccionado(horoscopoInfo)})
            //itemSeleccionado(horoscopoInfo)
        }
    }

    private fun empezarRotacion(view: View, nuevaLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { nuevaLambda() }
            start()
        }
    }
}