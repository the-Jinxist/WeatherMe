package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Sys {

    @SerializedName("country")
    @Expose
    private val country: String? = null

    @SerializedName("sunrise")
    @Expose
    private val sunrise: Long = 0

    @SerializedName("sunset")
    @Expose
    private val sunset: Long = 0

}