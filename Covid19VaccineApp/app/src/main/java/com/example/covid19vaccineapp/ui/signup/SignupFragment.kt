package com.example.covid19vaccineapp.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbar.toolbarTitle.text = resources.getString(R.string.title_signup)
        binding.toolbar.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }
        //
        binding.buttonRegister.setOnClickListener{
            Toast.makeText(context,"Register Successfully",Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}