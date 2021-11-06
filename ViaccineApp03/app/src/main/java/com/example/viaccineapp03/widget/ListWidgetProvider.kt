package com.example.viaccineapp03.widget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.viaccineapp03.R

class ListWidgetProvider:AppWidgetProvider() {
    override fun onReceive(context: Context?, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == "click"){
            println(intent.getStringExtra("0"))

        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (i in appWidgetIds.indices){
            val remoteAdapter = Intent(context,ListRemoteViewsService::class.java)
            val remoteViews = RemoteViews(context.packageName, R.layout.)
            remoteViews.setRemoteAdapter(R.id.,remoteAdapter)

            val intent = Intent(context,ListWidgetProvider::class.java)
            intent.action = "click"
            val pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            remoteViews.setPendingIntentTemplate(R.id.,pendingIntent)
            appWidgetManager.updateAppWidget(appWidgetIds,remoteViews)
        }
    }

}