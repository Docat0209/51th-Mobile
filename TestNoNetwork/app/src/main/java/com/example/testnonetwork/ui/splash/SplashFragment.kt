package com.example.testnonetwork.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testnonetwork.R
import com.example.testnonetwork.databinding.FragmentSplashBinding

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

        Handler(Looper.getMainLooper()).postDelayed({
            Navigation.findNavController(root).navigate(R.id.action_navigation_splash_to_navigation_login)
        },2000)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}