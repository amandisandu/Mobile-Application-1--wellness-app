package com.example.myapplication

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.RemoteViews
import com.example.myapplication.db.HabitPreference

class HabitWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {

        Log.d("MyTest","Working...")

        if (appWidgetManager != null && appWidgetIds != null && context != null) {
            for(appWidgetId in appWidgetIds){

                var habitPreference = HabitPreference(context)

                val view = RemoteViews(context.packageName,R.layout.widget_layout)
                view.setTextViewText(R.id.precentageView,"${habitPreference.getTodayCompletionPercentage()}%")

                appWidgetManager.updateAppWidget(appWidgetId,view)

            }
        }
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
    }

}