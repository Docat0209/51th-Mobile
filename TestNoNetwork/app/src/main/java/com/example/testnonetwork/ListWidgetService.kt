package com.example.testnonetwork

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.testnonetwork.model.EpidemicInfo

class ListWidgetService:RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return ListWidgetFactory(applicationContext)
    }
    inner class ListWidgetFactory(val context: Context):RemoteViewsFactory{
        val itemCount = 5
        val list:MutableList<EpidemicInfo> = ArrayList()
        override fun onCreate() {
            list.add(EpidemicInfo(null,"test01","time","asdfasdfd"))
            list.add(EpidemicInfo(null,"test01","time","asdfasdfd"))
            list.add(EpidemicInfo(null,"test01","time","asdfasdfd"))
            list.add(EpidemicInfo(null,"test01","time","asdfasdfd"))
            list.add(EpidemicInfo(null,"test01","time","asdfasdfd"))
        }

        override fun onDataSetChanged() {
        }

        override fun onDestroy() {
            list.clear()
        }

        override fun getCount(): Int {
            return itemCount
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val remoteViews  = RemoteViews(context.packageName,R.layout.list_widget_item)
            println(p0)
            remoteViews.setTextViewText(R.id.widget_item_title,list[p0].text)
            val fillIntent = Intent()
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