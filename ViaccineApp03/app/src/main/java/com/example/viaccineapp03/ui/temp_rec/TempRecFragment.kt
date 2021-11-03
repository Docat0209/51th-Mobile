package com.example.viaccineapp03.ui.temp_rec

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.viaccineapp03.R
import com.example.viaccineapp03.databinding.DialogAddTempRecBinding
import com.example.viaccineapp03.databinding.FragmentTempRecBinding
import com.example.viaccineapp03.local_data.LocalJson
import org.json.JSONObject

class TempRecFragment : Fragment() {

    private var _binding: FragmentTempRecBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTempRecBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            toolbarTempRec.apply {
                cancel.setOnClickListener{
                    Navigation.findNavController(root).popBackStack()
                }

                title.text = "溫度紀錄"

                add.setOnClickListener{
                    dialogAdd(requireContext())
                }
            }


        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("InflateParams")
    fun dialogAdd(context: Context){
        val dialogBuilder = AlertDialog.Builder(context)
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_temp_rec,null,false)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val dialogBinding = DialogAddTempRecBinding.bind(dialogView)
        dialogBinding.apply {

        }
    }
}






















