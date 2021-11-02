package com.example.a51_mobile_design.ui.temp_rec

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.SearchView
import android.widget.SeekBar
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.adapter.TempRecAdapter
import com.example.a51_mobile_design.databinding.DialogTempRecAddBinding
import com.example.a51_mobile_design.databinding.FragmentTempRecBinding
import com.example.a51_mobile_design.local_data.SqliteHelper
import com.example.a51_mobile_design.model.TempRec
import java.text.SimpleDateFormat
import java.util.*


class TempRecFragment : Fragment(){

    private var _binding: FragmentTempRecBinding? = null

    private val binding get() = _binding!!

    @SuppressLint("Range")
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
                title.text = "體溫紀錄"
                add.setOnClickListener{
                    alertDialog()
                }
            }
            listReload(binding.searchTempRec.query.toString())

            searchTempRec.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String): Boolean {
                    listReload(p0)
                    return true
                }

            })
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("Range")
    fun listReload(like:String){
        val sqliteHelper = SqliteHelper(requireContext())
        val tempRecList = mutableListOf<TempRec>()

        val cursor = sqliteHelper.sqlData("select * from TempRec where time like '%$like%'")
        cursor.apply {
            while (moveToNext()){
                tempRecList.add(TempRec(getInt(getColumnIndex("id")),getString(getColumnIndex("time")),getString(getColumnIndex("tempNum"))))
            }
        }
        binding.listTempRec.layoutManager = LinearLayoutManager(requireContext())
        binding.listTempRec.adapter = TempRecAdapter(requireContext(),tempRecList)
    }

    @SuppressLint("SimpleDateFormat")
    fun alertDialog(){
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.dialog_temp_rec_add,null)
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val alertBinding = DialogTempRecAddBinding.bind(dialogView)

        alertBinding.apply {
            seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    textTemp.x = seekBar.thumb.bounds.exactCenterX()
                    textTemp.text = (seekBar.progress/10.0f).toString() + "°C"
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })

            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            if (hour>12) {
                textHour.text = (hour-12).toString()
                buttonPm.isChecked = true
            }
            else{
                textHour.text = hour.toString()
                buttonAm.isChecked = true
            }

            textMinute.text = minute.toString()

            textDate.text = SimpleDateFormat("MMM dd, 20 yy",Locale.US).format(calendar.time)

            layoutDate.setOnClickListener{
                DatePickerDialog(requireContext(),{ _: DatePicker, i: Int, i1: Int, i2: Int ->
                    calendar.set(i,i1,i2)
                    textDate.text = SimpleDateFormat("MMM dd, 20 yy",Locale.US).format(calendar.time)
                },year,month,day).show()
            }

            layoutTime.setOnClickListener{
                TimePickerDialog(requireContext(),2,{ _: TimePicker, i: Int, i1: Int ->
                    if (i>12) {
                        textHour.text = (i-12).toString()
                        buttonPm.isChecked = true
                    }
                    else{
                        textHour.text = i.toString()
                        buttonAm.isChecked = true
                    }

                    textMinute.text = i1.toString()
                },hour,minute,false).show()
            }

            buttonCancel.setOnClickListener{
                alertDialog.dismiss()
            }
            buttonAdd.setOnClickListener{
                val sqliteHelper = SqliteHelper(requireContext())
                val dateFormat = SimpleDateFormat("yyyy年MM月dd日 EE aa hh mm",Locale.TAIWAN).format(calendar.time)
                val temp = textTemp.text.toString()
                sqliteHelper.sql("insert into TempRec values(null,'$dateFormat','$temp')")
                listReload(binding.searchTempRec.query.toString())
                alertDialog.dismiss()
            }

        }
    }
}