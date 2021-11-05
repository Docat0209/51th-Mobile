package com.example.testnonetwork

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class ListWidget : AppWidgetProvider() {
    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        for(i in appWidgetIds.indices){
            val intent = Intent(context,ListWidgetService::class.java)

            val remoteViews = RemoteViews(context.packageName, R.layout.list_widget)
            remoteViews.setRemoteAdapter(R.id.list_widget_view, intent)

            val clickIntent = Intent(context , ListWidget::class.java)
            clickIntent.action = "click"

            val clickPendingIntent = PendingIntent.getBroadcast(context , 0 , clickIntent , PendingIntent.FLAG_UPDATE_CURRENT)

            remoteViews.setPendingIntentTemplate(R.id.list_widget_view , clickPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetIds,remoteViews)
        }
    }

    override fun onReceive(context: Context?, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == "click"){

        }
    }
}
