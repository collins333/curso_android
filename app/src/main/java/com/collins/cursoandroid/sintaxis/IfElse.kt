package com.collins.cursoandroid.sintaxis

fun main(){
    ifBasico()
    ifAnidado()
    ifBoolean()
    ifInt()
    ifMultiple()
    ifMultipleOR()
}

fun ifMultipleOR(){
    var mascota = "gato"
    var esFeliz = true

    if (mascota == "perro" || (mascota == "gato" && esFeliz)){
        println("es un gato o un perro")
    }
}

fun ifMultiple(){
    var edad = 18
    var permisoPadres = false
    var soyFeliz = true

    if (edad >= 18 && permisoPadres && soyFeliz){
        println("puedo beber cerveza")
    }
}

fun ifInt(){
    var edad = 18

    if (edad >= 18){
        println("beber cerveza")
    } else {
        println("beber jugo")
    }
}

fun ifBoolean(){
    var soyFeliz:Boolean = false

    if(!soyFeliz){
        println("estoy triste :(")
    }
}

fun ifAnidado(){
    val animal = "Aris"

    if (animal == "perro"){
        println("es un perro")
    } else if (animal == "gato"){
        println("es un gato")
    } else if (animal == "pájaro"){
        println("es un pájaro")
    } else {
        println("no es uno de los animales esperados")
    }
}

fun ifBasico(){
    val nombre = "Collins"

    if (nombre == "Collins"){
        println("Oye, la variable nombre es Collins")
    }else {
        println("Este no es Collins")
    }
}