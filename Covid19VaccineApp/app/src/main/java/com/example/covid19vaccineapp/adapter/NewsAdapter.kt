package com.example.covid19vaccineapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ViewNewsBinding
import com.example.covid19vaccineapp.model.News

class NewsAdapter(private val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_news, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return this.newsList.count()
    }

    inner class ViewHolder(v: View) :RecyclerView.ViewHolder(v){
        val binding = ViewNewsBinding.bind(v)
    }
}