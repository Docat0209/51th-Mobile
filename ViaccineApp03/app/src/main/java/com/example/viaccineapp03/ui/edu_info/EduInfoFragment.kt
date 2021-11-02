package com.example.viaccineapp03.ui.edu_info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viaccineapp03.R

class EduInfoFragment : Fragment() {

    companion object {
        fun newInstance() = EduInfoFragment()
    }

    private lateinit var viewModel: EduInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edu_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EduInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}