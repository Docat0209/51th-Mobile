package com.example.viaccineapp03.ui.reserve

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viaccineapp03.R

class ReserveFragment : Fragment() {

    companion object {
        fun newInstance() = ReserveFragment()
    }

    private lateinit var viewModel: ReserveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reserve, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReserveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}