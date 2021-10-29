package com.example.covid19vaccineapp.ui.news

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19vaccineapp.HttpGet
import com.example.covid19vaccineapp.adapter.NewsAdapter
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentNewsBinding
import com.example.covid19vaccineapp.model.News
import com.google.api.Http
import org.json.JSONObject

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarNews.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarNews.toolbarTitle.text = resources.getString(R.string.title_eduinfo)
        binding.toolbarNews.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.navigation_home)
        }
        reload()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("Range", "SimpleDateFormat")
    fun reload()
    {
        val progressDialog = ProgressDialog.show(requireContext(),"","Loading....")

        val newsList = mutableListOf<News>()
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        Thread{
            val jsonData = HttpGet("information/health").get()
            val jsonObject = JSONObject(jsonData)

            val jsonArray = jsonObject.getJSONObject("message").getJSONArray("items")

            for (i in 0 until jsonArray.length()) {

                val data = jsonArray.getJSONObject(i).getJSONObject("snippet")
                val title = data.getString("title")
                val month = data.getString("publishedAt").substring(0,7)
                val day = data.getString("publishedAt").substring(8,10)
                newsList.add(News(month, day, title))
            }

            activity?.runOnUiThread {
                binding.newsRecyclerView.adapter = NewsAdapter(requireContext(),newsList)
                binding.newsRecyclerView
            }
            progressDialog.dismiss()
        }.start()

    }
}