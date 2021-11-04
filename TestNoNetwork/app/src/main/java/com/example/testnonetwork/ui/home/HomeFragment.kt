package com.example.testnonetwork.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.testnonetwork.R
import com.example.testnonetwork.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

//    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            toolbarHome.setting.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_setting)
            }
            buttonToEduInfo.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_edu_info)
            }
            buttonToTempRec.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_temp_rec)
            }
            buttonToEpidemicInfo.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_epidemic_info)
            }
            buttonToReserve.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_reserve)
            }
        }

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}