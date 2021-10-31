package com.example.a51_mobile_design.ui.epidemic_info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a51_mobile_design.R

class EpidemicInfoFragment : Fragment() {

    companion object {
        fun newInstance() = EpidemicInfoFragment()
    }

    private lateinit var viewModel: EpidemicInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_epidemic_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpidemicInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}