package io.neolution.weatherme.ViewModel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.neolution.weatherme.Injector.RepoInjector

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class ViewModelFactory(var application: Application): ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CurrentLocationViewModel::class.java)){
            return CurrentLocationViewModel(RepoInjector.getRepo(application.applicationContext)) as T
        }else{
            return super.create(modelClass)
        }
    }
}