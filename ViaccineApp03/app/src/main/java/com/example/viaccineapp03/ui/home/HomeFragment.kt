package com.example.viaccineapp03.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            toolbarHome.apply {
                setting.setOnClickListener{
                    Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_setting)
                }
            }
            buttonToEduInfo.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_edu_info)
            }
            buttonToEpidemicInfo.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_epidemic_info)
            }
            buttonToReserve.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_reserve)
            }
            buttonToTempRec.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_temp_rec)
            }


        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}