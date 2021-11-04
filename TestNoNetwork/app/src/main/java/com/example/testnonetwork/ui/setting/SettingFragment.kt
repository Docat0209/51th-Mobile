package com.example.testnonetwork.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testnonetwork.databinding.FragmentSettingBinding
import com.example.testnonetwork.localData.LocalJson
import org.json.JSONObject
import java.time.LocalDate

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
            toolbarSetting.title.text = "設定"
            toolbarSetting.cancel.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
            switchNotification.setOnCheckedChangeListener { _, p1 ->
                LocalJson(requireContext()).write("switch", JSONObject().put("state",p1))
            }
            if (!LocalJson(requireContext()).read("switch").isNull("state"))
            {
                switchNotification.isChecked = LocalJson(requireContext()).read("switch").getBoolean("state")
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}