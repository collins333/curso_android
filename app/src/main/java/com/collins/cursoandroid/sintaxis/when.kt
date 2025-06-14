package com.collins.cursoandroid.sintaxis

fun main(){
    saberMes(19)
    saberTrimestre(3)
    saberSemestre(27)
    result("ke cosa")
}

fun result(valor:Any){
    when(valor){
        is Int -> println(valor + valor)
        is String -> println(valor)
        is Boolean -> if(valor) println("hola caracola")
    }
}

fun saberSemestre(mes:Int) = when(mes){
    in 1..6 -> println("Primer semestre")
    in 7..12 -> println("Segundo semestre")
    !in 1..12 -> println("Semestre no válido")
    else -> println("cualquier string")
}

fun saberTrimestre(mes:Int){
    when(mes){
        1, 2, 3 -> println("Primer trimestre")
        4, 5, 6 -> println("Segundo trimestre")
        7, 8, 9 -> println("Tercer trimestre")
        10, 11, 12 -> println("Cuarto trimestre")
        else -> println("Trimestre no válido")
    }
}

fun saberMes(mes:Int){
    when(mes){
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("No es un mes válido")
    }
}