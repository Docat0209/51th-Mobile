package com.example.covid19vaccineapp.listwidget

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.model.WidgetItem
import java.util.ArrayList

class ListWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return ListRemoteViewsFactory(
            applicationContext, intent
        )
    }

    internal inner class ListRemoteViewsFactory(private val mContext: Context, intent: Intent) :
        RemoteViewsFactory {
        private val mCount = 10
        private val mWidgetItems: MutableList<WidgetItem> = ArrayList<WidgetItem>()
        private val mAppWidgetId: Int = intent.getIntExtra(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        )

        override fun onCreate() {
            println("onCreate() is called for $mAppWidgetId")

            for (i in 1..mCount) {
                mWidgetItems.add(WidgetItem("Item$i"))
            }

            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        override fun onDestroy() {
            println("onDestroy() is called for $mAppWidgetId")

            mWidgetItems.clear()
        }

        override fun getCount(): Int {
            println("WidgetId $mAppWidgetId")
            return mCount
        }

        @SuppressLint("RemoteViewLayout")
        override fun getViewAt(position: Int): RemoteViews {
            println("getViewAt() is called for $mAppWidgetId")

            val rv = RemoteViews(mContext.packageName, R.layout.widget_item)
            rv.setTextViewText(R.id.item_text, mWidgetItems[position].text)


            val extras = Bundle()

            extras.putInt(ListWidgetProvider.EXTRA_ITEM, position)

            val fillInIntent = Intent()

            fillInIntent.putExtras(extras)

            rv.setOnClickFillInIntent(R.id.widget_item, fillInIntent)

            try {
                println("Loading view $position")
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return rv
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun onDataSetChanged() {
        }

    }
}