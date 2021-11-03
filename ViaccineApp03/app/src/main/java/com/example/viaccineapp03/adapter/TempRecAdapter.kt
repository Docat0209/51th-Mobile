package com.example.viaccineapp03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.ListItemTempRecBinding
import com.example.viaccineapp03.model.TempRec

class TempRecAdapter(val context: Context , val tempRecList : MutableList<TempRec>): RecyclerView.Adapter<TempRecAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemTempRecBinding.bind(view)
        fun bind(tempRec: TempRec){
            binding.apply {
                itemTime.text = tempRec.time
                itemTemp.text = tempRec.temp
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_temp_rec,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tempRecList[position])

        holder.binding.apply {

        }
    }

    override fun getItemCount(): Int {
        return this.tempRecList.count()
    }

}