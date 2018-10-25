package io.neolution.weatherme.Utils

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class Common {

    companion object {

        val APIKEY = "bb17b57d2169e6ff5bfdd0983ce673bd"
        val OPEN_WEATHER_MAP_BASE_URL ="http://api.openweathermap.org"
        val ICON_BASE_URL = "http://openweathermap.org/img/w/"
        val PIC_END = ".png"
        val WEATHER_RESPONSE_CACHE_NAME = "weather_cache"
        val fontDirectory = "fonts/regular.ttf"

        fun returnString(obj: Any): String{
            return obj.toString()
        }

    }

}