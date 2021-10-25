package com.example.covid19vaccineapp

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class TempRecAdapter(val context: Context, val tempRecList: List<TempRec>) : RecyclerView.Adapter<TempRecAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) :RecyclerView.ViewHolder(item){
        private val time: TextView = item.findViewById(R.id.time)
        private val temp: TextView = item.findViewById(R.id.temp)

        @SuppressLint("SetTextI18n")
        fun bind(tempRec: TempRec){
            time.text = tempRec.time
            temp.text = tempRec.temp.toString() + "°C"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_temprec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tempRecList[position])
    }

    override fun getItemCount(): Int {
        return this.tempRecList.count()
    }


}