package com.collins.cursoandroid.tareasApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.collins.cursoandroid.R

class ViewHolderTareas(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTarea: TextView = view.findViewById(R.id.tvTarea)
    private val cbTarea: CheckBox = view.findViewById(R.id.cbTarea)

    fun render(tarea: Tarea) {
        if(tarea.isSelected) {
            tvTarea.paintFlags = tvTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else {
            tvTarea.paintFlags = tvTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbTarea.isChecked = tarea.isSelected
        tvTarea.text = tarea.nombre

        val color = when(tarea.categoria) {
            TareasCategorias.Negocios -> R.color.tareas_business_category
            TareasCategorias.Otros -> R.color.tareas_other_category
            TareasCategorias.Personal -> R.color.tareas_personal_category
        }

        cbTarea.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTarea.context, color))
    }

}