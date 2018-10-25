package io.neolution.weatherme.ViewModel

import android.arch.lifecycle.ViewModel
import io.neolution.weatherme.Model.Response
import io.neolution.weatherme.Repository.Repository
import retrofit2.Call

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class CurrentLocationViewModel(private var repository: Repository): ViewModel() {



    fun getResponseCall(placeOrId: String, apiKey: String): Call<Response>{
        return repository.getResponse(placeOrId, apiKey)
    }

    fun cacheResponse(cacheName: String, response: Response){
        repository.cacheReponse(response, cacheName)
    }

    fun getCacheResponse(cacheName: String): Response{
        return repository.getCacheResponse(cacheName)
    }

}