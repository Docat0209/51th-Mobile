package com.example.testnonetwork.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnonetwork.R

import com.example.testnonetwork.databinding.ListItemEpidemicInfoBinding
import com.example.testnonetwork.model.EpidemicInfo


class EpidemicInfoAdapter(val context: Context, private val epidemicInfoList :MutableList<EpidemicInfo>): RecyclerView.Adapter<EpidemicInfoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemEpidemicInfoBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(epidemicInfo: EpidemicInfo){
            binding.apply {
                itemDate.text = "測試時段"
                itemDay.text = "測試天"
                itemTitle.text = epidemicInfo.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_epidemic_info , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(epidemicInfoList[position])
        holder.binding.item.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return epidemicInfoList.count()
    }

}