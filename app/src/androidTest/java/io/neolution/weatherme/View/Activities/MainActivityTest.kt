package io.neolution.weatherme.View.Activities


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import io.neolution.weatherme.R
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */

@RunWith(JUnit4::class)
class MainActivityTest{

    lateinit var idlingResource: IdlingResource



    @Rule
//    public val activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)




    @Before
    public fun registerIdlingRes(){


    }

    @Test
    fun ifTextIsNotEmpty(){
        onView(withId(R.id.fancy_weather_desc)).check(matches(isDisplayed()))

    }
}