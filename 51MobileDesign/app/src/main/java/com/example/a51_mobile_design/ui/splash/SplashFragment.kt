package com.example.a51_mobile_design.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.databinding.FragmentSplashBinding

import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.NavOptions




class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireActivity().intent.getIntExtra("id",-1)

        Handler(Looper.getMainLooper()).postDelayed({
            if (id != -1)
            {

            }else
            {
                Navigation.findNavController(binding.root).navigate(R.id.action_navigation_splash_to_navigation_login)
            }
        },2000)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}