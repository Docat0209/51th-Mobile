package com.example.a51_mobile_design.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.a51_mobile_design.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var signUpViewModel: SignUpViewModel
    private var _binding: FragmentSignUpBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        signUpViewModel =
            ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root

        signUpViewModel.apply {
            binding.apply {
                userId.observe(viewLifecycleOwner,{
                    textId.setText(it)
                })
                password.observe(viewLifecycleOwner,{
                    textPassword.setText(it)
                })
                passwordAgain.observe(viewLifecycleOwner,{
                    textPasswordAgain.setText(it)
                })
                userName.observe(viewLifecycleOwner,{
                    textName.setText(it)
                })
                phone.observe(viewLifecycleOwner,{
                    textPhone.setText(it)
                })
                address.observe(viewLifecycleOwner,{
                    textAddress.setText(it)
                })
            }
        }



        binding.apply {
            toolbarSignUp.title.text = "會員註冊"

            toolbarSignUp.cancel.setOnClickListener{
                signUpViewModel.apply {
                    userId.value = textId.text.toString()
                    password.value = textPassword.text.toString()
                    passwordAgain.value = textPasswordAgain.text.toString()
                    userName.value = textName.text.toString()
                    phone.value = textPhone.text.toString()
                    address.value = textAddress.text.toString()
                }

                Navigation.findNavController(root).popBackStack()
            }

            buttonSignUp.setOnClickListener{
                Toast.makeText(requireContext(),"註冊成功",Toast.LENGTH_LONG).show()
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