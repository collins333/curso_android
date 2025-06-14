package com.collins.cursoandroid.ejercicios

/**
Notificaciones móviles

Por lo general, el teléfono te proporciona un resumen de las notificaciones.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste. El mensaje debe incluir lo siguiente:

La cantidad exacta de notificaciones cuando haya menos de 100
99+ como cantidad de notificaciones cuando haya 100 o más

Completa la función printNotificationSummary() para que el programa imprima estas líneas:

- Tu tienes 51 notificaciones
- Tu móvil está explotando! Tu tienes 99+ notificaciones.
 */


fun main() {
    val matinalNotificaciones = 51
    val vespertinaNotificaciones = 135

    imprimirSumaNotificaciones(matinalNotificaciones)
    imprimirSumaNotificaciones(vespertinaNotificaciones)
}


fun imprimirSumaNotificaciones(numeroDeMensajes: Int) {
    if (numeroDeMensajes < 100) {
        println("Tu tienes $numeroDeMensajes notificaciones")
    } else  {
        println("Tu móvil está explotando! Tu tienes 99+ notificaciones.")
    }
}

