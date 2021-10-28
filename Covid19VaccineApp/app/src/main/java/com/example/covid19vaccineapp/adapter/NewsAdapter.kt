package com.example.covid19vaccineapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ViewNewsBinding
import com.example.covid19vaccineapp.model.News
import com.example.covid19vaccineapp.ui.news.NewsDetailFragment
import com.example.covid19vaccineapp.ui.news.NewsFragment

class NewsAdapter(private val context: Context, private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_news, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.layout2.setOnClickListener{
            val bundle = Bundle().apply {
                putInt("index", position)
            }

            Navigation.findNavController(it).navigate(R.id.action_navigation_news_to_navigation_news_detail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return this.newsList.count()
    }

    inner class ViewHolder(v: View) :RecyclerView.ViewHolder(v){
        val binding = ViewNewsBinding.bind(v)
    }
}