package com.collins.cursoandroid.tareasApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R

class ViewHolderCategorias(view: View) : RecyclerView.ViewHolder(view) {

    private val tvNombreCategoria: TextView = view.findViewById(R.id.tvNombreCategoria)
    private val divisor: View = view.findViewById(R.id.divisor)
    private val cvContenedor: CardView = view.findViewById(R.id.cvContenedor)

    fun render(tareasCategorias: TareasCategorias, alSeleccionarItem: (Int) -> Unit) {

        val color = if(tareasCategorias.estaSeleccionada) {
            R.color.tareas_background_card
        } else {
            R.color.tareas_background_disabled
        }

        cvContenedor.setCardBackgroundColor(ContextCompat.getColor(cvContenedor.context, color))

        itemView.setOnClickListener {alSeleccionarItem(layoutPosition) }

        when(tareasCategorias) {
            TareasCategorias.Negocios -> {
                tvNombreCategoria.text = "Negocios"
                divisor.setBackgroundColor(
                    ContextCompat.getColor(divisor.context, R.color.tareas_business_category)
                )
            }
            TareasCategorias.Otros -> {
                tvNombreCategoria.text = "Otros"
                divisor.setBackgroundColor(
                    ContextCompat.getColor(divisor.context, R.color.tareas_other_category)
                )
            }
            TareasCategorias.Personal -> {
                tvNombreCategoria.text = "Personal"
                divisor.setBackgroundColor(
                    ContextCompat.getColor(divisor.context, R.color.tareas_personal_category)
                )
            }
        }
    }
}