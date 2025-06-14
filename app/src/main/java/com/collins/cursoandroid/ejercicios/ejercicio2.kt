package com.collins.cursoandroid.ejercicios

/**
Precio de las entradas de cine

Las entradas de cine suelen tener un precio diferente según la edad de los espectadores.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que calcule los precios de estas entradas basados en la edad:

Un precio de entrada infantil de USD 15 para personas de 12 años o menos.
Un precio de entrada estándar de USD 30 para personas de entre 13 y 60 años. Los lunes, un precio estándar con descuento de USD 25 para el mismo grupo etario
Un precio para adultos mayores de USD 20 para personas de 61 años o más (asumimos que la edad máxima de un espectador es de 100 años)
Un valor de -1 para indicar que el precio no es válido cuando un usuario ingresa una edad fuera de las especificaciones

Completa la función ticketPrice() para que el programa imprima estas líneas:

- El precio de la entrada para una persona de 5 años es 15€.
- El precio de la entrada para una persona de 28 años es 25€.
- El precio de la entrada para una persona de 87 años es 20€.
 */

fun main() {
    val infantil = 5
    val adulto = 28
    val jubilado = 87

    val esLunes = true

    println("El precio de la entrada para una persona de $infantil años es ${precioEntrada(infantil, esLunes)}€.")
    println("El precio de la entrada para una persona de $adulto años es ${precioEntrada(adulto, esLunes)}€.")
    println("El precio de la entrada para una persona de $jubilado años es ${precioEntrada(jubilado, esLunes)}€.")
}

fun precioEntrada(edad: Int, esLunes: Boolean): Int {

    return when (edad) {
        in 0..12 -> 15
        in 16.. 60 -> if (esLunes) {25} else {30}
        in 61..100 -> 20
        else -> {-1}
    }
}
