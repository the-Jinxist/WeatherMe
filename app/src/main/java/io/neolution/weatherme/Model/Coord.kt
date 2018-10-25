package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Coord {

    @SerializedName("lon")
    @Expose
    private val lon: Double = 0.0

    @SerializedName("lat")
    @Expose
    private val lat: Double = 0.0

}