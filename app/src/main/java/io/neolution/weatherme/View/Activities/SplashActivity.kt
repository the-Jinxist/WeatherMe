package io.neolution.weatherme.View.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import io.neolution.weatherme.R
import org.jetbrains.anko.intentFor

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
                {
                    startActivity(intentFor<MainActivity>("id" to 5))
                },
                2000
        )
    }
}
