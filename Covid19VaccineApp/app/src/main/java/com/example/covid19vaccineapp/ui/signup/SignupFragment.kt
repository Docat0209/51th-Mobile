package com.example.covid19vaccineapp.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.SqlDataBaseHelper
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
        val sql = SqlDataBaseHelper(requireContext())
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
            if (binding.textInputLayoutPassword.text.toString() == binding.textInputLayoutPasswordAgain.text.toString()) {
                try {
                    sql.query(
                        "insert into User values(NULL," +
                                "'${binding.textInputLayoutEmail.text.toString()}'," +
                                "'${binding.textInputLayoutPassword.text.toString()}'," +
                                "'${binding.textInputLayoutName.text.toString()}'," +
                                "'${binding.textInputLayoutPhonenumber.text.toString()}'," +
                                "'${binding.textInputLayoutAddress.text.toString()}')"
                    )
                    Toast.makeText(context, "Register Successful", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(it).popBackStack()
                } catch (e: Exception) {
                    Toast.makeText(context, "Register Fail", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context,"密碼不一致",Toast.LENGTH_LONG).show()
            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}