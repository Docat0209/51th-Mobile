package com.example.a51_mobile_design.ui.setting

import android.app.SearchManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a51_mobile_design.databinding.FragmentSettingBinding
import com.example.a51_mobile_design.local_data.JsonLocalData
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
        val jsonLocalData = JsonLocalData(requireActivity(),"Switch")

        binding.apply {
            toolbarSetting.title.text = "設定"
            if(jsonLocalData.getLocalData().getBoolean("state")){
                switchNotification.isChecked = jsonLocalData.getLocalData().getBoolean("switch")
            }
            toolbarSetting.cancel.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
            switchNotification.setOnCheckedChangeListener { _, p1 ->
                val jsonObject = JSONObject()
                jsonObject.put("switch",p1)
                jsonLocalData.saveLocalData(jsonObject)
            }
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}