package com.example.testnonetwork.ui.eduInfo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testnonetwork.MainActivity
import com.example.testnonetwork.R
import com.example.testnonetwork.adapter.EduInfoAdapter
import com.example.testnonetwork.databinding.FragmentEduInfoBinding
import com.example.testnonetwork.model.EduInfo
import java.util.ArrayList

class EduInfoFragment : Fragment() {


    private var _binding: FragmentEduInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEduInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            toolbarEduInfo.title.text = "衛教資訊"
            toolbarEduInfo.cancel.setOnClickListener{
                Navigation.findNavController(root).popBackStack()
            }
            searchEduInfo.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    update(requireContext(),ArrayList<EduInfo>())
                    return true
                }

            })
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update(requireContext(),ArrayList<EduInfo>())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("InflateParams")
    fun update(context: Context,list:ArrayList<EduInfo>){
        for (i in 0 until list.count()) {
            if ((context as MainActivity).findViewById<SearchView>(R.id.search_eduInfo).query.toString() in list[i].title) {
                list.add(list[i])
            }
        }
        val adapter = EduInfoAdapter(context, list)

        val listViewEduInfo = (context as Activity).findViewById<RecyclerView>(R.id.listView_eduInfo)
        listViewEduInfo.adapter = adapter
        listViewEduInfo.layoutManager = LinearLayoutManager(context)
    }
}