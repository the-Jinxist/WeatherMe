package io.neolution.weatherme.Injector

import android.content.Context
import io.neolution.weatherme.Repository.Repository

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
object RepoInjector {

    fun getRepo(context: Context): Repository{
        return Repository(context)
    }

}