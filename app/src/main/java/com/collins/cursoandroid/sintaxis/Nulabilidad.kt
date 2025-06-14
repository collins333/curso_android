package com.collins.cursoandroid.sintaxis

fun main(){
    var nombre:String? = null //"Phil Collins"

    println(nombre?.get(6) ?: "Tiene el valor null")
}