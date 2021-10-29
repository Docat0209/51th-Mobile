package com.example.covid19vaccineapp.ui.login

import android.annotation.SuppressLint

import android.app.PendingIntent

import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.covid19vaccineapp.databinding.FragmentLoginBinding
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.HttpGet
import org.json.JSONObject
import com.example.covid19vaccineapp.MainActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.NotificationCompat

import com.example.covid19vaccineapp.R

import android.app.NotificationChannel
import android.app.NotificationManager


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("Range", "UnspecifiedImmutableFlag")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textViewSignup.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_login_to_navigation_signup)
        }
        var count = 0
        binding.clear.setOnClickListener{
            count++
            val intent = Intent(requireContext(), MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(requireContext(), 0, intent, 0)

            val notificationManagerCompat = NotificationManagerCompat.from(requireContext())
            val mChannel = NotificationChannel("test", "123", NotificationManager.IMPORTANCE_LOW)
            notificationManagerCompat.createNotificationChannel(mChannel)

            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(requireContext(), "test")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("哈囉你好！$count")
                    .setContentText("跟你打個招呼啊～")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setContentIntent(pendingIntent)

            notificationManagerCompat.notify(1, builder.build())
        }

        binding.buttonLogin.setOnClickListener{
            Thread{
                val jsonObject = JSONObject()
                jsonObject.put("email",binding.edittextEmail.text.toString())
                jsonObject.put("password",binding.editTextPassword.text.toString())

                if(HttpGet("account/login").httpPost(jsonObject).getBoolean("status")){
                    activity?.runOnUiThread {
                        Navigation.findNavController(it).navigate(R.id.action_navigation_login_to_navigation_home)
                    }
                } else {
                    activity?.runOnUiThread {
                        Toast.makeText(requireContext(),"Login Fail",Toast.LENGTH_LONG).show()

                    }
                }
            }.start()
        }

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = (requireActivity() as MainActivity).intent.getIntExtra("index",-1)

        if (index != -1)
        {
            val bundle = Bundle().apply {
                putInt("index",index)
            }

            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_login_to_navigation_news_detail,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}