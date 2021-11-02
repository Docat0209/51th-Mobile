package com.example.viaccineapp03.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginViewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            loginViewModel.account.observe(viewLifecycleOwner,{
                loginEmail.setText(it)
            })
            buttonToSignUp.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_login_to_navigation_sing_up)
            }
            buttonToHome.setOnClickListener{
                Navigation.findNavController(root).navigate(R.id.action_navigation_login_to_navigation_home)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.account.postValue(binding.loginEmail.text.toString())
        _binding = null
    }
}