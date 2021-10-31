package com.example.a51_mobile_design.widget

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.model.WidgetItem

class ListWidgetService :RemoteViewsService(){
    override fun onGetViewFactory(p0: Intent): RemoteViewsFactory {
        return ListWidgetFactory(applicationContext,p0)
    }

    internal inner class ListWidgetFactory(val context: Context,intent: Intent):
        RemoteViewsFactory{

        private val count = 10
        private val widgetItem: MutableList<WidgetItem> = ArrayList<WidgetItem>()

        override fun onCreate() {
            for(i in 1 until count){
                widgetItem.add(WidgetItem())
            }
        }

        override fun onDataSetChanged() {
        }


        override fun onDestroy() {
            widgetItem.clear()
        }

        override fun getCount(): Int {
            return count
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val remoteViews = RemoteViews(context.packageName, R.layout.widget_item)

            remoteViews.setTextViewText(R.id.widget_text,p0.toString())

            val extras = Bundle()
            extras.putInt("0",p0)

            val fillIntent = Intent()
            fillIntent.putExtras(extras)

            remoteViews.setOnClickFillInIntent(R.id.widget_item,fillIntent)

            return remoteViews
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

    }
}