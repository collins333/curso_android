package com.collins.cursoandroid.ejercicios

/**
Catálogo de canciones

Imagina que necesitas crear una app de reproducción de música.

Crea una clase que pueda representar la estructura de una canción. La clase Cancion debe incluir estos elementos de código:

Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones
Propiedad que indica si la canción es popular (si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
Un método para imprimir la descripción de una canción en este formato:

"[Título], interpretada por [artista], se lanzó en [año de lanzamiento]".
 */

fun main() {
    val jg = Cancion("Jesucristo García", "Extremoduro", 1989, 1000000)

    jg.descripcionCancion()
    if(jg.esPopular) {
        println("${jg.titulo} es una canción muy popular. Ha tenido ${jg.reproducciones} de reproducciones")
    } else {
        println("Se ha escuchado muy pocas veces")
    }
}

class Cancion(val titulo: String, val artista: String, val añoPublicacion: Int, val reproducciones: Int) {

    val esPopular: Boolean
        get() = reproducciones >= 1000

    fun descripcionCancion() {
        println("$titulo, interpretada por $artista, se lanzó en $añoPublicacion.")
    }
}

