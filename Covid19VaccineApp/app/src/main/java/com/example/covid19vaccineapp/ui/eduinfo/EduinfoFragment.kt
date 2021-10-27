package com.example.covid19vaccineapp.ui.eduinfo

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19vaccineapp.adapter.EduInfoAdapter
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentEduinfoBinding
import com.example.covid19vaccineapp.model.EduInfo
import org.json.JSONObject
import java.io.InputStream
import java.net.URL

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
        reload()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("Range", "SimpleDateFormat")
    fun reload()
    {
        val eduinfoList = mutableListOf<EduInfo>()
        binding.eduinfoRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        Thread{
            val jsonData =
                URL("http://54.234.67.26/taiwancovid19information/information/health").readText()
            val jsonObject = JSONObject(jsonData)

            val jsonArray = jsonObject.getJSONObject("message").getJSONArray("items")

            for (i in 0 until jsonArray.length()) {

                val data = jsonArray.getJSONObject(i).getJSONObject("snippet")
                val title = data.getString("title")
                val image = data.getJSONObject("thumbnails").getJSONObject("medium").getString("url")
                eduinfoList.add(EduInfo(Drawable.createFromStream(URL(image).content as InputStream,"dick"),title))
            }

            activity?.runOnUiThread {
                binding.eduinfoRecyclerView.adapter = EduInfoAdapter(eduinfoList)
            }
        }.start()

    }
}