package com.collins.cursoandroid.heroes

import com.google.gson.annotations.SerializedName

data class RespuestaDetalles (
    @SerializedName("name") val nombre: String,
    @SerializedName("powerstats") val poderes: RespuestaPoderes,
    @SerializedName("image") val imagen: RespuestaImagenHeroe,
    @SerializedName("biography") val biografia: RespuestaBiografia
)

data class RespuestaPoderes (
    @SerializedName("intelligence") val inteligencia: String,
    @SerializedName("strength") val fortaleza: String,
    @SerializedName("speed") val velocidad: String,
    @SerializedName("durability") val durabilidad: String,
    @SerializedName("power") val poder: String,
    @SerializedName("combat") val combate: String
)

data class RespuestaImagenHeroe (
    @SerializedName("url") val url: String
)

data class RespuestaBiografia (
    @SerializedName("full-name") val nombreReal: String,
    @SerializedName("publisher") val editorial: String
)