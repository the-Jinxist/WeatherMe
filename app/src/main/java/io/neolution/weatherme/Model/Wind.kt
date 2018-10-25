package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Wind {

    @SerializedName("speed")
    @Expose
    val speed: Double = 0.toDouble()

    @SerializedName("deg")
    @Expose
    private val deg: Double = 0.toDouble()

}