package com.collins.cursoandroid.tareasApp

sealed class TareasCategorias(var estaSeleccionada: Boolean = true) {
    object Personal : TareasCategorias()
    object Negocios : TareasCategorias()
    object Otros : TareasCategorias()
}