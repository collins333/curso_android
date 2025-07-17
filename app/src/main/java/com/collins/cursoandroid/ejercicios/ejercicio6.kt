package com.collins.cursoandroid.ejercicios

/**
Teléfonos plegables

Por lo general, la pantalla del teléfono se enciende y se apaga cuando se presiona el botón de encendido. En cambio, si un teléfono plegable está plegado, su pantalla interna principal no se enciende cuando se presiona el botón de encendido.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe una clase TelefonoPlegable que se herede de la clase Telefono. Debe contener lo siguiente:

Una propiedad que indique si el teléfono está plegado
Un comportamiento de función encender() diferente del de la clase Telefono para que solo encienda la pantalla cuando el teléfono no esté plegado
Métodos para cambiar el estado de plegado
*/

open class Telefono(var estaPantallaEncendida: Boolean = false){
    open fun encender() {
        estaPantallaEncendida = true
    }

    fun apagar() {
        estaPantallaEncendida = false
    }

    fun comprobarLuzPantallaTelefono() {
        val luzPantallaTelefono = if (estaPantallaEncendida) "on" else "off"
        println("La luz de la pantalla del teléfono está $luzPantallaTelefono.")
    }
}

class TelefonoPlegable(var estaPlegado: Boolean = true): Telefono() {
    override fun encender() {
        if(!estaPlegado) {
            estaPantallaEncendida = true
        }
    }

    fun plegado() {
        estaPlegado = true
    }

    fun noPlegado() {
        estaPlegado = false
    }
}

    fun main() {
        val newTelefonoPlegable = TelefonoPlegable()

        newTelefonoPlegable.encender()
        newTelefonoPlegable.comprobarLuzPantallaTelefono()
        newTelefonoPlegable.noPlegado()
        newTelefonoPlegable.encender()
        newTelefonoPlegable.comprobarLuzPantallaTelefono()
    }
