package com.example.a51_mobile_design.widget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.a51_mobile_design.MainActivity
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.ui.temp_rec.TempRecFragment

class ListWidgetProvider:AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if(intent.action == "click"){

            val activityIntent = Intent(context,MainActivity::class.java)
            activityIntent.putExtra("id",intent.getIntExtra("0",-1))
            activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(activityIntent)

        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        for(i in appWidgetIds.indices){
            val intent = Intent(context,ListWidgetService::class.java)

            val remoteViews = RemoteViews(context.packageName, R.layout.widget_layout)
            remoteViews.setRemoteAdapter(R.id.widget_list_view , intent)

            val clickIntent = Intent(context , ListWidgetProvider::class.java)
            clickIntent.action = "click"

            val clickPendingIntent = PendingIntent.getBroadcast(context , 0 , clickIntent , PendingIntent.FLAG_UPDATE_CURRENT)

            remoteViews.setPendingIntentTemplate(R.id.widget_list_view , clickPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetIds,remoteViews)
        }
    }
}