package com.collins.cursoandroid.heroes

import com.google.gson.annotations.SerializedName

data class RespuestaDatos(
    @SerializedName("response") val respuesta: String,
    @SerializedName("results") val heroes: List<ItemRespuestaHeroes>
)

data class ItemRespuestaHeroes(
    @SerializedName("id") val heroeId: String,
    @SerializedName("name") val heroeNombre: String,
    @SerializedName("image") val heroeImagen: ImagenRespuestaHeroe
)

data class ImagenRespuestaHeroe(@SerializedName("url") val url: String)