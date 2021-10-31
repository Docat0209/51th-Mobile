package com.example.a51_mobile_design.ui.reserve

import android.app.SearchManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.a51_mobile_design.databinding.FragmentReserveBinding
import com.example.a51_mobile_design.local_data.JsonLocalData
import org.json.JSONObject

class ReserveFragment : Fragment() {

    private var _binding: FragmentReserveBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReserveBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            toolbarReserve.title.text = "設定"
            toolbarReserve.cancel.setOnClickListener{
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