package com.example.covid19vaccineapp.ui.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentReserveBinding

class ReserveFragment : Fragment() {

    private var _binding: FragmentReserveBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentReserveBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarReserve.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarReserve.toolbarTitle.text = resources.getString(R.string.title_eduinfo)
        binding.toolbarReserve.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }

        binding.buttonReserve.setOnClickListener{
            Toast.makeText(context,"Reserve Successfully", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}