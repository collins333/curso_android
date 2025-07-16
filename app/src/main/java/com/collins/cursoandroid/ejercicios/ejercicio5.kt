package com.collins.cursoandroid.ejercicios

/**
Perfil de Internet

A menudo, debes completar los perfiles de sitios web en línea que contienen campos obligatorios y no obligatorios. Por ejemplo, puedes agregar tu información personal y un vínculo a otras personas que te refirieron para que registraras tu perfil.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima los detalles del perfil de una persona.
 */

fun main() {
    val amanda = Persona("Amanda", 33, "jugar al tenis", null)
    val atiqah = Persona("Atiqah", 28, "escalar", amanda)

    amanda.mostrarPerfil()
    atiqah.mostrarPerfil()
}

class Persona(val nombre: String, val edad: Int, val hobby: String?, val referencia: Persona?) {

    fun mostrarPerfil() {
        print("Nombre: ${nombre}\nEdad: ${edad}\nLe gusta ${hobby}.")
        if (referencia != null) {
            println("Tiene una referencia llamada ${referencia.nombre}, a quien le gusta ${referencia.hobby}\n")
        } else {
            println("No tiene ninguna referencia\n")
        }
    }
}

/**
Completa la función mostrarPerfil() para que el programa imprima estas líneas:

Nombre: Amanda
Edad: 33
Le gusta jugar al tenis. No tiene ninguna referencia.

Nombre: Atiqah
Edad: 28
Le gusta escalar. Tiene una referencia llamada Amanda, a quien le gusta jugar al tenis.

 */