package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Response {

    @SerializedName("coord")
    @Expose
    private val coord: Coord? = null

    @SerializedName("sys")
    @Expose
    private val sys: Sys? = null

    @SerializedName("weather")
    @Expose
     val weather: List<Weather>? = null

    @SerializedName("main")
    @Expose
    val main: Main? = null

    @SerializedName("wind")
    @Expose
    val wind: Wind? = null

    @SerializedName("rain")
    @Expose
    private val rain: Rain? = null

    @SerializedName("clouds")
    @Expose
    private val clouds: Clouds? = null

    @SerializedName("dt")
    @Expose
    private val dt: Long = 0

    @SerializedName("id")
    @Expose
    private val id: Long = 0

    @SerializedName("name")
    @Expose
     val name: String? = null

    @SerializedName("cod")
    @Expose
    val cod: Long = 0

}