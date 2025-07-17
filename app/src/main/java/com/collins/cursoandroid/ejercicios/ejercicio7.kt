package com.collins.cursoandroid.ejercicios

/**
Subasta especial

Por lo general, en una subasta, el ofertante que ofrece el importe más alto determina el precio de un artículo. En esta subasta especial, si nadie oferta por un artículo, este se vende automáticamente a la casa de subastas al precio mínimo.

En el código inicial que se proporciona en el siguiente fragmento de código, se te proporciona una función auctionPrice() que acepta un tipo Bid? anulable como argumento:

Completa la función precioSubasta() para que el programa imprima estas líneas:

Item A es vendido a 5000.
Item B es vendido a 3000.
 */

fun main() {
    val ganadorSubasta = Subasta(5000, "Colección Privada")

    println("Item A es vendido a ${precioSubasta(ganadorSubasta, 2000)}.")
    println("Item B es vendido a ${precioSubasta(null, 3000)}.")
}

class Subasta(val cantidad: Int, val postor: String)

fun precioSubasta(subasta: Subasta?, precioMinimo: Int): Int {
    return subasta?.cantidad ?: precioMinimo
}
