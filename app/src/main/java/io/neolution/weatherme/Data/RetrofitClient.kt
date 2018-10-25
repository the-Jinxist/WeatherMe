package io.neolution.weatherme.Data

import io.neolution.weatherme.Service.PreciseWeatherSevice
import io.neolution.weatherme.Utils.Common
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
object RetrofitClient {

    private fun getRetrofitClient(): Retrofit{
      return  Retrofit.Builder()
                .baseUrl(Common.OPEN_WEATHER_MAP_BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun getWeatherService(): PreciseWeatherSevice{
        return getRetrofitClient()
                .create(PreciseWeatherSevice::class.java)
    }

}