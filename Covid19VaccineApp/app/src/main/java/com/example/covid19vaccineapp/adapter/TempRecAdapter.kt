package com.example.covid19vaccineapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ViewTemprecBinding
import com.example.covid19vaccineapp.model.TempRec

class TempRecAdapter(val context: Context,val TempRecList:MutableList<TempRec>):RecyclerView.Adapter<TempRecAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ViewTemprecBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(tempRec: TempRec){
            binding.apply {
                temp.text = tempRec.temp.toString() + "度C"
                time.text = tempRec.time
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_temprec , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(TempRecList[position])
        
    }

    override fun getItemCount(): Int {
        return TempRecList.count()
    }


}