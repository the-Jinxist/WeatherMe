package io.neolution.weatherme.View.Widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

import io.neolution.weatherme.R
import io.neolution.weatherme.Repository.Repository
import io.neolution.weatherme.Utils.Common

/**
 * Implementation of App Widget functionality.
 */
class WetherMeWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created

    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager,
                                     appWidgetId: Int) {

            val response = Repository(context).getCacheResponse(Common.WEATHER_RESPONSE_CACHE_NAME)
            val weather_temp = response.main!!.temp.toString()
            val weather_place = response.name!!

            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.wether_me_widget)
//            views.setTextViewText(R.id.appwidget_text, widgetText)
            views.setTextViewText(R.id.weather_widget_place, weather_place)
            views.setTextViewText(R.id.weather_widget_temp, weather_temp)
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

