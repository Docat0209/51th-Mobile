package com.example.viaccineapp03.widget

import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.viaccineapp03.R
import com.example.viaccineapp03.model.TempRec

class ListRemoteViewsService:RemoteViewsService() {

    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return ListRemoteViewsFactory()
    }
    inner class ListRemoteViewsFactory:RemoteViewsFactory{
        private val itemCount = 10
        private val itemList = ArrayList<TempRec>()
        override fun onCreate() {
            for (i in 0 until itemCount){
                itemList.add(TempRec("$i",""))
            }
        }

        override fun onDataSetChanged() {
        }

        override fun onDestroy() {
            itemList.clear()
        }

        override fun getCount(): Int {
            return itemCount
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val remoteViews = RemoteViews(applicationContext.packageName , R.layout.)
            remoteViews.setTextViewText(R.id.textView , "")

            val intent = Intent()
            intent.putExtra("0",0)
            remoteViews.setOnClickFillInIntent(R.id.textView,intent)


            return remoteViews
        }

        override fun getLoadingView(): RemoteViews? {
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