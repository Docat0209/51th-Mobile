package com.example.viaccineapp03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.ListItemTempRecBinding
import com.example.viaccineapp03.model.TempRec

class TempRecAdapter(private val context: Context, private val tempRecList: MutableList<TempRec>):RecyclerView.Adapter<TempRecAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = ListItemTempRecBinding.bind(view)
        fun bind(tempRec: TempRec){
            binding.apply {
                itemTemp.text = tempRec.temp
                itemTime.text = tempRec.time
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_temp_rec,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tempRecList[position])
    }

    override fun getItemCount(): Int {
        return tempRecList.count()
    }


}