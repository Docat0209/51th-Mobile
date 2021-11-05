package com.example.testnonetwork.ui.epidemicInfo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testnonetwork.R
import com.example.testnonetwork.adapter.EpidemicInfoAdapter
import com.example.testnonetwork.databinding.FragmentEpidemicInfoBinding
import com.example.testnonetwork.model.EpidemicInfo
import java.util.ArrayList

class EpidemicInfoFragment : Fragment() {


    private var _binding: FragmentEpidemicInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpidemicInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            toolbarEpidemicInfo.title.text = "疫情資訊"
            toolbarEpidemicInfo.cancel.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("InflateParams")
    fun update(context: Context){
        val eduInfoList = ArrayList<EpidemicInfo>()

        eduInfoList.add(EpidemicInfo(null,"test01","",""))
        val adapter = EpidemicInfoAdapter(context,eduInfoList)

        val listViewEpidemicInfo = (context as Activity).findViewById<RecyclerView>(R.id.listView_epidemic_info)
        listViewEpidemicInfo.adapter = adapter
        listViewEpidemicInfo.layoutManager = LinearLayoutManager(context)
    }
}