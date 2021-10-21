package com.example.covid19vaccineapp.ui.home

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarHome.toolbarSetting.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_setting)
        }

        binding.buttonEduinfo.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_eduinfo)
        }
        binding.buttonNews.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_news)
        }
        binding.buttonTemprec.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_temprec)
        }
        binding.buttonReserve.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_reserve)
        }






        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}