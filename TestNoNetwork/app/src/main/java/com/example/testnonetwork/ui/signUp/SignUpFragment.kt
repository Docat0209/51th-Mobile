package com.example.testnonetwork.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testnonetwork.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {


    private var _binding: FragmentSignUpBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            toolbarSignUp.title.text = "會員註冊"
            toolbarSignUp.cancel.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
            buttonSignUp.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}