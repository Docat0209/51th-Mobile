package com.example.covid19vaccineapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentNewsDetailBinding
import org.json.JSONObject
import java.net.URL

class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarNewsDetail.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarNewsDetail.toolbarTitle.text = resources.getString(R.string.title_news)
        binding.toolbarNewsDetail.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.navigation_news)
        }
        //
        val index = arguments?.getInt("index")
        setData(index!!)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(i:Int)
    {

        Thread{

            val jsonData =
                URL("http://54.234.67.26/taiwancovid19information/information/health").readText()
            val jsonObject = JSONObject(jsonData)

            val jsonArray = jsonObject.getJSONObject("message").getJSONArray("items")

            val data = jsonArray.getJSONObject(i).getJSONObject("snippet")

            activity?.runOnUiThread {
                binding.detailTitle.text = data.getString("title")
            }

        }.start()
    }
}