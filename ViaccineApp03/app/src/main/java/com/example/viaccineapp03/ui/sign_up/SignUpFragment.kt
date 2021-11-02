package com.example.viaccineapp03.ui.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.viaccineapp03.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var signUpViewModel: SignUpViewModel
    private var _binding: FragmentSignUpBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        signUpViewModel = ViewModelProvider(requireActivity())[SignUpViewModel::class.java]

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            toolbarSignUp.apply {
                title.text = "會員註冊"
                cancel.setOnClickListener{
                    Navigation.findNavController(root).popBackStack()
                }
            }
            signUpViewModel.apply {
                userId.observe(viewLifecycleOwner,{
                    signId.setText(it)
                })
                email.observe(viewLifecycleOwner,{
                    signEmail.setText(it)
                })
                password.observe(viewLifecycleOwner,{
                    signPassword.setText(it)
                })
                passwordAgain.observe(viewLifecycleOwner,{
                    signPasswordAgain.setText(it)
                })
                userName.observe(viewLifecycleOwner,{
                    signName.setText(it)
                })
                phone.observe(viewLifecycleOwner,{
                    signPhone.setText(it)
                })
                address.observe(viewLifecycleOwner,{
                    signAddress.setText(it)
                })
            }
            buttonSignUp.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.apply {
            signUpViewModel.apply {
                userId.value = signId.text.toString()
                email.value = signEmail.text.toString()
                password.value = signPassword.text.toString()
                passwordAgain.value = signPasswordAgain.text.toString()
                userName.value = signName.text.toString()
                phone.value = signPhone.text.toString()
                address.value = signAddress.text.toString()
            }
        }
        _binding = null
    }
}