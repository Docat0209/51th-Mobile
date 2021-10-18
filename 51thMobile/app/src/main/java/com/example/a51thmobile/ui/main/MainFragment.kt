package com.example.a51thmobile.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a51thmobile.SignupActivity
import com.example.a51thmobile.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding:MainFragmentBinding?= null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSignup = binding.buttonSignUp
        buttonSignup.setOnClickListener{
            startActivity(Intent(context,SignupActivity::class.java))
        }
    }

}