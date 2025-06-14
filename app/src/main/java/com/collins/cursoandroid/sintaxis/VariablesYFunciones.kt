package com.collins.cursoandroid.sintaxis

val  intEjemplo:Int = 30

fun main(){
    variablesNumericas()
    variablesAlfaNumericas()
    variablesBoolean()
    mostrarMiNombre()
    mostrarMiEdad(29)
    mostrarMiEdad2()
    suma(15,12)
    val miResta = resta(15,12)
    println(miResta)
    val miRestaSimplificada = restaSimplificada(20,15)
    println(miRestaSimplificada)
}

fun variablesNumericas(){
    // VARIABLES NUMÉRICAS

    // int  -2.147.4883.647 a 2.147.4883.647
    var intEjemplo2:Int = 30
    intEjemplo2 = 35

    // long  -9.223.372.036.854.775.807 a 9.223.372.036.854.775.807
    val longEjemplo:Long = 100

    // float
    val floatEjemplo:Float = 25.6f

    // double
    val doubleEjemplo:Double = 25.1354847

// Operaciones con variables numéricas

    println("Sumar:")
    println(intEjemplo + intEjemplo2)

    println("Restar:")
    println(intEjemplo2 - intEjemplo)

    println("Multiplicar:")
    println(intEjemplo * intEjemplo2)

    println("Dividir:")
    println(intEjemplo2 / intEjemplo)

    println("Módulo:")
    println(intEjemplo2 % intEjemplo)

    var ejemploSuma = intEjemplo + floatEjemplo
    println(ejemploSuma)
}

fun variablesAlfaNumericas(){
    // VARIABLES ALFANUMÉRICAS

    // char
    val charEjemplo1: Char = 'a'
    val charEjemplo2: Char = '7'
    val charEjemplo3: Char = '@'

    // string
    val stringEjemplo:String = "Collins saludos"
    val stringEjemplo2:String = "Collins"
    val stringEjemplo3:String = "4"

    // Operaciones con variables alfanuméricas
    var stringConcatenado:String = "Hola me llamo $stringEjemplo2 y tengo $intEjemplo años"
    println(stringConcatenado)
}

fun variablesBoolean(){
    // VARIABLES BOOLEANAS

    // boolean
    val booleanEjemplo1: Boolean = true
    val booleanEjemplo2: Boolean = false
    val booleanEjemplo3 = false
}

fun mostrarMiNombre(){
    println("Me llamo Collins")
}

fun mostrarMiEdad(edad:Int){
    println("Tengo $edad años")
}

fun mostrarMiEdad2(edad:Int = 30){
    println("Tengo $edad años")
}

fun suma(primero:Int, segundo:Int){
    println(primero + segundo)
}

fun resta(primero:Int, segundo:Int):Int{
    return primero - segundo
}

fun restaSimplificada(primero:Int, segundo:Int) = primero - segundo