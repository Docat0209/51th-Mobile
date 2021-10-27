package com.example.covid19vaccineapp.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.covid19vaccineapp.databinding.FragmentLoginBinding
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.helper.SqlDataBaseHelper


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("Range")
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

        binding.clear.setOnClickListener{
            context?.deleteDatabase("test.db")
        }

        binding.buttonLogin.setOnClickListener{
            if(binding.edittextEmail.text.toString() == "admin" && binding.editTextPassword.text.toString() == "0000"){

                Navigation.findNavController(it).navigate(R.id.action_navigation_login_to_navigation_home)
            } else {
                Toast.makeText(requireContext(),"Login Fail",Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}