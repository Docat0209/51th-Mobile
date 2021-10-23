package com.example.covid19vaccineapp.ui.eduinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentEduinfoBinding

class EduinfoFragment : Fragment() {

    private var _binding: FragmentEduinfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEduinfoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarEduinfo.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarEduinfo.toolbarTitle.text = resources.getString(R.string.title_eduinfo)
        binding.toolbarEduinfo.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}