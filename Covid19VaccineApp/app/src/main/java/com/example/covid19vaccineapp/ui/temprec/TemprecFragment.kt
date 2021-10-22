package com.example.covid19vaccineapp.ui.temprec

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.FragmentTemprecBinding
import android.app.AlertDialog.Builder
import android.graphics.Canvas
import android.widget.SeekBar
import android.widget.TextView


class TemprecFragment : Fragment() {

    private var _binding: FragmentTemprecBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTemprecBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // tool bar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarTemprec.toolbar)
        val toolbar = (activity as AppCompatActivity).supportActionBar
        toolbar!!.setDisplayShowTitleEnabled(false)
        binding.toolbarTemprec.toolbarTitle.text = resources.getString(R.string.title_temprec)
        binding.toolbarTemprec.toolbarCancel.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }
        binding.toolbarTemprec.toolbarAdd.setOnClickListener {
            val dialogBuilder = Builder(context)
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.alert_label_editor, null)
            dialogBuilder.setView(dialogView)
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val seekBar = dialogView.findViewById<SeekBar>(R.id.seek_progress)
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                    val textView = dialogView.findViewById<TextView>(R.id.bar)
                    textView.text = "$progress°c"
                    textView.x = seekBar.x
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}