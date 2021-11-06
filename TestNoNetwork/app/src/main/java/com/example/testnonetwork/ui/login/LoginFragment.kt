package com.example.testnonetwork.ui.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testnonetwork.HttpRequest
import com.example.testnonetwork.R
import com.example.testnonetwork.databinding.FragmentLoginBinding
import org.json.JSONObject
import java.net.URL

class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            buttonLogin.setOnClickListener {
                val jsonObject = JSONObject()
                jsonObject.put("email","admin@admin.com")
                jsonObject.put("password","0000")
                HttpRequest("http://54.234.67.26/taiwancovid19information/account/login").httpPost(jsonObject){
                    println(it.toString())
                }
                Navigation.findNavController(root).navigate(R.id.action_navigation_login_to_navigation_home)
            }
            buttonToSignUp.setOnClickListener {
                Navigation.findNavController(root).navigate(R.id.action_navigation_login_to_navigation_sign_up)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}