package com.collins.cursoandroid.sintaxis

fun main(){
    var name:String = "Collins"
    var name2:String = "Phil"
    var name3:String = "Talento"
    var name4:String = "Pepe"

    println(name3)

    //Indice: 0-6
    //Tamaño: 7
    val diasSemana = arrayOf("lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    println(diasSemana[4])
    print("El tamaño de este array es ")
    println(diasSemana.size)

    //Tamaños
    if (diasSemana.size >= 8) {
        println(diasSemana[7])
    } else {
        println("No hay tantos valores en el array")
    }

    //Modificar valores
    diasSemana[4] = "Juendres"

    println(diasSemana[4])

    //Bucles para recorrer arrays
    for(valor in diasSemana.indices){
        println(diasSemana[valor])
    }

    for((index, value) in diasSemana.withIndex()){
        println("La posición $index es el $value")
    }

    for(valor in diasSemana){
        println("Ahora es $valor")
    }

    diasSemana.forEach { dia -> println(dia) }

}