package es.etg.dam.pmdm13.gym.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface TiempoAPIService {

    @GET
    suspend fun getTiempo(@Url url: String): Response<TiempoResponse>

}