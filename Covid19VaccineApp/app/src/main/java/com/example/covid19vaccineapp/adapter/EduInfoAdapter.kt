package com.example.covid19vaccineapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.model.EduInfo

class EduInfoAdapter(private val eduinfoList: List<EduInfo>) : RecyclerView.Adapter<EduInfoAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) :RecyclerView.ViewHolder(item){
        private val text: TextView = item.findViewById(R.id.edu_info_text)
        private val image: ImageView = item.findViewById(R.id.eduinfo_image)

        @SuppressLint("SetTextI18n")
        fun bind(eduinfo: EduInfo){
            image.setImageDrawable(eduinfo.pic)
            text.text = eduinfo.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_eduinfo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(eduinfoList[position])
    }

    override fun getItemCount(): Int {
        return this.eduinfoList.count()
    }


}