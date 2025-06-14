package com.collins.cursoandroid.ejercicios

import android.annotation.SuppressLint

/**

Conversor de temperatura

En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que convierta una temperatura de una escala a otra con estas fórmulas:

De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
Kelvin a Celsius: °C = K - 273.15
De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15

Ten en cuenta que el método String.format("%.2f", /** medicion */ ) se usa para convertir un número en un tipo String con 2 decimales.

Completa la función main() para que llame a la función printFinalTemperature() e imprima las siguientes líneas. Debes pasar argumentos para la fórmula de conversión y temperatura. Sugerencia: Te recomendamos usar valores Double para evitar el truncamiento de Integer durante las operaciones de división.

27.0 grados Celsius son 80.60 grados Fahrenheit.
350.0 grados Kelvin son 76.85 grados Celsius.
10.0 grados Fahrenheit son 260.93 grados Kelvin.

*/

fun main() {

    imprimirTemperaturaFinal(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    imprimirTemperaturaFinal(350.0, "Kelvin", "Celsius") { it - 273.15 }
    imprimirTemperaturaFinal(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

//fun imprimirTemperaturaFinal(medicionInicial: Double, unidadInicial: String, unidadFinal: String, conversionFormula: (Double) -> Double) {
//    val medicionFinal = String.format("%.2f", conversionFormula(medicionInicial)) // two decimal places
//    println("$medicionInicial grados $unidadInicial son $medicionFinal grados $unidadFinal.")
//}

@SuppressLint("DefaultLocale")
fun imprimirTemperaturaFinal(medicionInicial: Double, unidadInicial: String, unidadFinal: String, conversionFormula: (Double) -> Double) {
    val medicionFinal = String.format("%.2f", conversionFormula(medicionInicial))
    println("$medicionInicial grados $unidadInicial son $medicionFinal grados $unidadFinal.")
}


