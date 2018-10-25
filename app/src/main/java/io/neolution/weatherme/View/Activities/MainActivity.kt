package io.neolution.weatherme.View.Activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import io.neolution.weatherme.Injector.FactoryInjector
import io.neolution.weatherme.Model.Response
import io.neolution.weatherme.R
import io.neolution.weatherme.Utils.Common
import io.neolution.weatherme.Utils.Common.Companion.fontDirectory
import io.neolution.weatherme.ViewModel.CurrentLocationViewModel
import io.neolution.weatherme.databinding.ActivityMainBinding

import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: CurrentLocationViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var fancy_place_name: TextView
    private lateinit var fancy_weather_desc: TextView
    private lateinit var fancy_weather_temp: TextView
    private lateinit var fancy_weather_icon: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        floatingActionButton = findViewById(R.id.floatingActionButton)
        fancy_place_name = findViewById(R.id.fancy_place_name)
        fancy_weather_desc = findViewById(R.id.fancy_weather_desc)
        fancy_weather_temp = findViewById(R.id.fancy_weather_temp)
        fancy_weather_icon = findViewById(R.id.fancy_weather_icon)


         viewmodel = ViewModelProviders.of(this, FactoryInjector.getFatcoryInjector(application))
                .get(CurrentLocationViewModel::class.java)

        val response =viewmodel.getResponseCall("2350841", Common.APIKEY)

        if(isConnected()){
            loadResponseFromServer(response)
        }else{
            loadFromCache()
        }



        floatingActionButton.setOnClickListener{
            if(isConnected()) {
                toast("Reloading")
                loadResponseFromServer(response)

            }else{
                toast("You're not connected. Please try again")
            }

        }
        fancy_place_name.setFont(Common.fontDirectory)
        fancy_weather_temp.setFont(fontDirectory)
        fancy_weather_desc.setFont(Common.fontDirectory)

    }

    private fun isConnected(): Boolean{

        val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       val network = manager.activeNetworkInfo

        return network != null && network.isConnectedOrConnecting

    }

    private fun loadResponseFromServer(response: Call<Response>){

        response.enqueue(object: Callback<Response> {
            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {

                if(response!!.isSuccessful) {
                    revealViews()
                    viewmodel.cacheResponse(Common.WEATHER_RESPONSE_CACHE_NAME, response.body()!!)
                   loadInfoIntoViews(response.body()!!)

                }

                else {
                    longToast("Response was unsuccessful. Please check your connection!")

                }
            }

            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                longToast(t!!.message!!)
                Log.d("Retrofit Exception: ", t.message)
            }

        })

    }

    private fun loadFromCache(){


        val response = viewmodel.getCacheResponse(Common.WEATHER_RESPONSE_CACHE_NAME)

        revealViews()
        loadInfoIntoViews(response)
    }

    private fun revealViews(){

//        weather_PLace.reveal()
//        weather_description.reveal()
//        temp.reveal()
//        humidity.reveal()
//        wind_speed.reveal()

    }

    private fun TextView.setFont(fontDirectory: String){
        this.typeface = android.graphics.Typeface.createFromAsset(assets, fontDirectory)
    }

    private  fun loadInfoIntoViews(response: Response){

        fancy_weather_desc.text = response.weather!![0].description

        val string = response.main!!.temp.toString() + " C"
        fancy_weather_temp.text = string

        val weatherIco = response.weather[0].icon
        val weatherIcoUrl = Common.ICON_BASE_URL + weatherIco + Common.PIC_END

        Picasso.get()
                .load(weatherIcoUrl)
                .placeholder(R.drawable.weather)
                .into(fancy_weather_icon)
    }

}
