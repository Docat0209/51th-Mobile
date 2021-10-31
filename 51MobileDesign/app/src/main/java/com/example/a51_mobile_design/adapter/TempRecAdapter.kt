package com.example.a51_mobile_design.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a51_mobile_design.R
import com.example.a51_mobile_design.databinding.DialogTempRecDeleteBinding
import com.example.a51_mobile_design.databinding.DialogTempRecUpdateBinding
import com.example.a51_mobile_design.databinding.ListItemTempRecBinding
import com.example.a51_mobile_design.local_data.SqliteHelper
import com.example.a51_mobile_design.model.TempRec
import java.text.SimpleDateFormat
import java.util.*


class TempRecAdapter(val context: Context, private val tempRecList:MutableList<TempRec>) :RecyclerView.Adapter<TempRecAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_temp_rec,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("Range", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tempRecList[position])

        holder.binding.item.setOnClickListener{
            alertDialog(tempRecList[position].id)
            notifyItemChanged(tempRecList[position].id)
        }

        holder.binding.item.setOnLongClickListener {
            val dialogBuilder = AlertDialog.Builder(context)
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_temp_rec_delete,null)
            dialogBuilder.setView(dialogView)
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val dialogBinding = DialogTempRecDeleteBinding.bind(dialogView)
            dialogBinding.apply {
                val id = tempRecList[position].id
                val calendar = Calendar.getInstance()
                val sqliteHelper = SqliteHelper(context)
                var cursor = sqliteHelper.sqlData("select * from TempRec where id = '$id'")
                cursor.moveToFirst()
                val date = cursor.getString(cursor.getColumnIndex("time"))
                val temp = cursor.getString(cursor.getColumnIndex("tempNum")).substring(0,4).toFloat()
                val time = SimpleDateFormat("yyyy年MM月dd日 EE aa hh mm", Locale.TAIWAN).parse(date)

                if (time != null) {
                    calendar.time = time
                }
                val dateFormat = SimpleDateFormat("yyyy年MM月dd日 EE aa hh mm",Locale.TAIWAN).format(calendar.time)
                deleteText.text = "是否刪除「$dateFormat $temp°C」該筆紀錄"
                buttonCancel.setOnClickListener{
                    alertDialog.dismiss()
                }
                buttonDelete.setOnClickListener{

                    sqliteHelper.sql("delete from TempRec where id = '$id'")
                    alertDialog.dismiss()
                    val tempRecList = mutableListOf<TempRec>()

                    val like = (context as Activity).findViewById<SearchView>(R.id.search_temp_rec).query

                    cursor = sqliteHelper.sqlData("select * from TempRec where time like '%$like%'")
                    cursor.apply {
                        while (moveToNext()){
                            tempRecList.add(TempRec(getInt(getColumnIndex("id")),getString(getColumnIndex("time")),getString(getColumnIndex("tempNum"))))
                        }
                    }
                    val listTempRec = context.findViewById<RecyclerView>(R.id.list_temp_rec)
                    listTempRec.layoutManager = LinearLayoutManager(context)
                    listTempRec.adapter = TempRecAdapter(context,tempRecList)

                }
            }

            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return this.tempRecList.count()
    }

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding = ListItemTempRecBinding.bind(view)
        fun bind(tempRec: TempRec){
            binding.apply {
                temp.text = tempRec.temp
                date.text = tempRec.date
            }
        }
    }


    @SuppressLint("SimpleDateFormat", "Range", "NotifyDataSetChanged")
    fun alertDialog(id:Int){
        val dialogBuilder = AlertDialog.Builder(context)
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_temp_rec_update,null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val dialogBinding = DialogTempRecUpdateBinding.bind(dialogView)

        dialogBinding.apply {
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
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

            val sqliteHelper = SqliteHelper(context)
            var cursor = sqliteHelper.sqlData("select * from TempRec where id = '$id'")
            cursor.moveToFirst()
            val date = cursor.getString(cursor.getColumnIndex("time"))
            val temp = cursor.getString(cursor.getColumnIndex("tempNum")).substring(0,4).toFloat()
            val time = SimpleDateFormat("yyyy年MM月dd日 EE aa hh mm", Locale.TAIWAN).parse(date)
            if (time != null) {
                calendar.time = time
            }

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            seekBar.progress = (temp * 10).toInt()

            if (hour>12) {
                textHour.text = (hour-12).toString()
                buttonPm.isChecked = true
            }
            else{
                textHour.text = hour.toString()
                buttonAm.isChecked = true
            }

            textMinute.text = minute.toString()

            textDate.text = SimpleDateFormat("MMM dd, 20 yy", Locale.US).format(calendar.time)

            layoutDate.setOnClickListener{
                DatePickerDialog(context,{ _: DatePicker, i: Int, i1: Int, i2: Int ->
                    calendar.set(i,i1,i2)
                    textDate.text = SimpleDateFormat("MMM dd, 20 yy", Locale.US).format(calendar.time)
                },year,month,day).show()
            }

            layoutTime.setOnClickListener{
                TimePickerDialog(context,2,{ _: TimePicker, i: Int, i1: Int ->
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
            buttonEdit.setOnClickListener{
                val dateFormat = SimpleDateFormat("yyyy年MM月dd日 EE aa hh mm",Locale.TAIWAN).format(calendar.time)
                val tempNew = textTemp.text.toString()
                sqliteHelper.sql("update TempRec set time = '$dateFormat' , tempNum = '$tempNew' where id = '$id'")
                alertDialog.dismiss()

                val tempRecList = mutableListOf<TempRec>()
                val like = (context as Activity).findViewById<SearchView>(R.id.search_temp_rec).query

                cursor = sqliteHelper.sqlData("select * from TempRec where time like '%$like%'")
                cursor.apply {
                    while (moveToNext()){
                        tempRecList.add(TempRec(getInt(getColumnIndex("id")),getString(getColumnIndex("time")),getString(getColumnIndex("tempNum"))))
                    }
                }
                val listTempRec = context.findViewById<RecyclerView>(R.id.list_temp_rec)
                listTempRec.layoutManager = LinearLayoutManager(context)
                listTempRec.adapter = TempRecAdapter(context,tempRecList)
            }

        }
    }
}