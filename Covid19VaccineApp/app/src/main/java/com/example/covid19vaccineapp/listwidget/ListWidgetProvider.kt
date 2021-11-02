package com.example.covid19vaccineapp.listwidget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import android.widget.Toast
import com.example.covid19vaccineapp.MainActivity
import com.example.covid19vaccineapp.R


/**
 * Implementation of App Widget functionality.
 */
class ListWidgetProvider : AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "click") {
            println(intent.getIntExtra("0", -1))
        }
        super.onReceive(context, intent)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        for (i in appWidgetIds.indices) {

            val intent = Intent(context, ListWidgetService::class.java)

            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            views.setRemoteAdapter(R.id.list_view, intent)
            views.setEmptyView(R.id.list_view,R.id.empty_view)

            val toastIntent = Intent(context, ListWidgetProvider::class.java)
            toastIntent.action = "click"

            val toastPendingIntent = PendingIntent.getBroadcast(
                context, 0, toastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            views.setPendingIntentTemplate(R.id.list_view, toastPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetIds, views)
        }
    }

}