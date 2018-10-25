package io.neolution.weatherme.Injector

import android.app.Application
import io.neolution.weatherme.ViewModel.ViewModelFactory

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
object FactoryInjector {

    fun getFatcoryInjector(application: Application): ViewModelFactory{
        return ViewModelFactory(application)
    }

}