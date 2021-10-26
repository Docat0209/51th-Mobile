package com.example.covid19vaccineapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.model.News

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(item: View) :RecyclerView.ViewHolder(item){
        private val month: TextView = item.findViewById(R.id.news_time_month)
        private val day: TextView = item.findViewById(R.id.news_time_day)
        private val title: TextView = item.findViewById(R.id.news_title)

        @SuppressLint("SetTextI18n")
        fun bind(news: News){
            month.text = news.month
            day.text = news.day
            title.text = news.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return this.newsList.count()
    }


}