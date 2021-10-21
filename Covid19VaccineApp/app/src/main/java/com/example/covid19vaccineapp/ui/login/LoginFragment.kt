package com.example.covid19vaccineapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.covid19vaccineapp.databinding.FragmentLoginBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textViewSignup.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_login_to_navigation_signup)
        }
        binding.buttonLogin.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_login_to_navigation_home)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}