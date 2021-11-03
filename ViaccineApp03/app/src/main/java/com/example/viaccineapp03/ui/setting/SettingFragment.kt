package com.example.viaccineapp03.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.FragmentSettingBinding
import com.example.viaccineapp03.local_data.LocalJson
import org.json.JSONObject

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            toolbarSetting.apply {
                cancel.setOnClickListener{
                    Navigation.findNavController(root).popBackStack()
                }
                title.text = "設定"
            }
            val json = LocalJson(requireContext()).getData("switch")
            if (!json.isNull("switch")){
                switchNotification.isChecked = json.getBoolean("switch")
            }
            switchNotification.setOnCheckedChangeListener { _, p1 ->
                val jsonObject = JSONObject()
                jsonObject.put("switch",p1)
                LocalJson(requireContext()).putData("switch",jsonObject)
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}