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
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.covid19vaccineapp.databinding.AlertLabelEditorBinding
import java.text.SimpleDateFormat
import java.util.*


class TemprecFragment : Fragment() {

    private var _binding: FragmentTemprecBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SimpleDateFormat")
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

        //dialog
        binding.toolbarTemprec.toolbarAdd.setOnClickListener {

            val dialogBuilder = Builder(context)
            val dialogView = layoutInflater.inflate(R.layout.alert_label_editor, null)
            dialogBuilder.setView(dialogView)
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val bind = AlertLabelEditorBinding.inflate(inflater)
            alertDialog.setContentView(bind.root)

            //SeekBar
            val seekBar = bind.seekProgress
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                    val textView = bind.bar
                    textView.text = (progress/10f).toString() + "°c"
                    textView.x = seekBar.thumb.bounds.exactCenterX()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })

            //Date Picker
            val datePickerView = bind.datePicker
            val dateText = bind.dateText

            val c = Calendar.getInstance()
            val yearNow = c.get(Calendar.YEAR)
            val monthNow = c.get(Calendar.MONTH)
            val dayNow = c.get(Calendar.DAY_OF_MONTH)
            val hourNow = c.get(Calendar.HOUR)
            val minuteNow = c.get(Calendar.MINUTE)
            val amPmNow = c.get(Calendar.AM_PM)

            var monthName:String
            var format:String

            monthName = SimpleDateFormat("MMM").format(monthNow)
            format = "$monthName $dayNow , $yearNow"
            dateText.text = format

            datePickerView.setOnClickListener{
                DatePickerDialog(requireContext(), { _, year, month, day ->
                    monthName = SimpleDateFormat("MMM").format(month)
                    format = "$monthName $day , $year"
                    dateText.text = format
                }, yearNow, monthNow, dayNow).show()
            }//date picker end


            val rd = bind.rdGroup
            val hourText = bind.hour
            val minuteText = bind.minute
            val buttonAM = bind.buttonAM
            val buttonPM = bind.buttonPM

            hourText.text = hourNow.toString()
            minuteText.text = minuteNow.toString()


            rd.setOnCheckedChangeListener { _, p1 ->

                if (p1 == R.id.button_AM){
                    buttonAM.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_200))
                    buttonPM.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
                    buttonAM.setTextColor(ContextCompat.getColor(requireContext(),R.color.purple_500))
                    buttonPM.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                } else {
                    buttonAM.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
                    buttonPM.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.purple_200))
                    buttonAM.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                    buttonPM.setTextColor(ContextCompat.getColor(requireContext(),R.color.purple_500))
                }
            }

            if (amPmNow == 1){
                rd.check(R.id.button_PM)
            }
            else{
                rd.check(R.id.button_AM)
            }

            //time picker
            val timePicker = bind.timePicker
            timePicker.setOnClickListener{
                TimePickerDialog(requireContext(),{_ , hour , minute ->
                    if(hour >= 12){
                        hourText.text = (hour - 12).toString()
                        rd.check(R.id.button_PM)
                    } else {
                        hourText.text = hour.toString()
                        rd.check(R.id.button_AM)
                    }
                    minuteText.text = minute.toString()
                },c.get(Calendar.HOUR_OF_DAY),minuteNow,false).show()
            }

            val buttonCancel = bind.buttonAlertCancel
            val buttonAdd = bind.buttonAlertAdd

            buttonCancel.setOnClickListener{
                alertDialog.hide()
            }

            buttonAdd.setOnClickListener{
                alertDialog.hide()
                Toast.makeText(requireContext(),"新增成功",Toast.LENGTH_LONG).show()
            }


        }//dialog end


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}