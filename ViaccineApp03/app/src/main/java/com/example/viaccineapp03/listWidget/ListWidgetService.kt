package com.example.viaccineapp03.listWidget

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.viaccineapp03.R
import com.example.viaccineapp03.model.TempRec

class ListWidgetService: RemoteViewsService(){

    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return ListWidgetFactory(applicationContext)
    }
    class ListWidgetFactory(val context: Context):RemoteViewsFactory{
        private val count = 10
        val widgetItem = ArrayList<TempRec>()
        override fun onCreate() {
            for (i in 1..count){
                widgetItem.add(TempRec("$i",""))
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
            val remoteViews = RemoteViews(context.packageName, R.layout)

            val intent = Intent()
            intent.putExtra("a",0)
            remoteViews.setOnClickFillInIntent(R.id.sign_id , intent)

        }

        override fun getLoadingView(): RemoteViews?{
            return null
        }

        override fun getViewTypeCount(): Int {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

    }
}