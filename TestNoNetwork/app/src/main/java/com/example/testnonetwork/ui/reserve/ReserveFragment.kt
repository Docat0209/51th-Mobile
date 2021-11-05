package com.example.testnonetwork.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.testnonetwork.databinding.FragmentReserveBinding

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
            toolbarReserve.title.text = "疫苗預約"
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