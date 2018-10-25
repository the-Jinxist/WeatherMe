package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Main {

    @SerializedName("temp")
    @Expose
    val temp: Double = 0.toDouble()

    @SerializedName("humidity")
    @Expose
    val humidity: Double = 0.0

    @SerializedName("pressure")
    @Expose
    private val pressure: Double = 0.0

    @SerializedName("temp_min")
    @Expose
    private val tempMin: Double = 0.toDouble()

    @SerializedName("temp_max")
    @Expose
    private val tempMax: Double = 0.toDouble()

}