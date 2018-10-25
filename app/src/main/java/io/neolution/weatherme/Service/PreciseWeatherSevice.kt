package io.neolution.weatherme.Service

import io.neolution.weatherme.Model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
interface PreciseWeatherSevice {

    @GET("/data/2.5/weather")
    fun getResponse(@Query("id") PlaceId: String,
                    @Query("APPID") ApiKey: String): Call<Response>
}