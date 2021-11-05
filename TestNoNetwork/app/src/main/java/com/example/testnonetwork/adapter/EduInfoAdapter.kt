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

import com.example.testnonetwork.databinding.ListItemEduInfoBinding
import com.example.testnonetwork.model.EduInfo


class EduInfoAdapter(val context: Context, private val eduInfoList :MutableList<EduInfo>): RecyclerView.Adapter<EduInfoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemEduInfoBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(eduInfo: EduInfo){
            binding.apply {
                itemImage.setImageDrawable(eduInfo.src)
                itemTitle.text = eduInfo.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_edu_info , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(eduInfoList[position])
        holder.binding.item.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse(eduInfoList[position].link))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eduInfoList.count()
    }

}