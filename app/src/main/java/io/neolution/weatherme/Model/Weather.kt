package io.neolution.weatherme.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Weather {

    @SerializedName("id")
    @Expose
    private val id: Long = 0

    @SerializedName("main")
    @Expose
    private val main: String? = null

    @SerializedName("description")
    @Expose
    val description: String? = null

    @SerializedName("icon")
    @Expose
    val icon: String? = null

}