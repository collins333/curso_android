package com.collins.cursoandroid.sintaxis

fun main(){
    listaInmutable()
    listaMutable()
}

fun listaInmutable(){
    val semestre:List<String> = listOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio")

    println(semestre.size)
    println(semestre)
    println(semestre[1])
    println(semestre.last())
    println(semestre.first())

    //filtrar
    val ejemplo = semestre.filter{ it.contains("a") }

    println(ejemplo)

    //iterar
    semestre.forEach{ mes -> println(mes) }

    semestre.forEach{ println(it) }
}

fun listaMutable(){
    val semestre:MutableList<String> = mutableListOf("Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

    //añadir nuevo elemento
    semestre.add(3,"Siembre")

    println(semestre)

    if(semestre.isEmpty()){
        //No imprimo nada porque está vacío
    }else {
        semestre.forEach { println(it) }
    }

    if(semestre.isNotEmpty()){
        semestre.forEach { println(it) }
    }

    println(semestre.last())

    //iteración
    for(mes in semestre){
        println(mes)
    }

    semestre.forEach { println(it) }
}