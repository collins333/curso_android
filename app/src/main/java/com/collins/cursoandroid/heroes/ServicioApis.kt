package com.collins.cursoandroid.heroes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicioApis {
    @GET("/api/7e5b05267b23616ab16d752b65ef5c6b/search/{name}")
    suspend fun crearHeroes(@Path("name") heroeNombre: String): Response<RespuestaDatos>

    @GET("/api/7e5b05267b23616ab16d752b65ef5c6b/{id}")
    suspend fun crearDetalleHeroe(@Path("id") heroeId: String): Response<RespuestaDetalles>
}