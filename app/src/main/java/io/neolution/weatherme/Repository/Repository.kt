package io.neolution.weatherme.Repository

import android.content.Context
import io.neolution.weatherme.Data.RetrofitClient
import io.neolution.weatherme.Model.Response
import io.paperdb.Paper
import retrofit2.Call

/**
* Created by Big-Nosed Developer on the Edge of Infinity.
*/
class Repository(context: Context) {


    init {
        Paper.init(context)
    }

    fun getResponse(placeOrId: String, apiKey: String): Call<Response> {

        return RetrofitClient.getWeatherService()
                .getResponse(placeOrId, apiKey)

    }

    fun cacheReponse(response: Response, cacheName: String){

        Paper.book().write(cacheName, response)
    }

    fun getCacheResponse(cacheName: String): Response{
        return Paper.book().read<Response>(cacheName)
    }

    init {
        Paper.init(context)
    }

}