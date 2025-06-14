package com.collins.cursoandroid.tareasApp

data class Tarea(val nombre: String, val categoria: TareasCategorias, var isSelected: Boolean = false) {
}