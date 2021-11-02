package com.example.a51_mobile_design.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.databinding.FragmentHomeBinding
import android.content.Intent
import android.net.Uri


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
            toolbarHome.setting.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_setting)
                val uri= Uri.parse("https://mnya.tw")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
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