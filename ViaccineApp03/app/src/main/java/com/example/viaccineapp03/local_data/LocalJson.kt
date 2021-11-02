package com.example.viaccineapp03.local_data

import android.app.Activity
import android.content.Context
import org.json.JSONObject

class LocalJson(val context: Context) {
    fun getData(key:String):JSONObject{
        val json = (context as Activity).getPreferences(Context.MODE_PRIVATE).getString(key,"{}")
        return JSONObject(json.toString())
    }
    fun putData(key:String , value:JSONObject){
        (context as Activity).getPreferences(Context.MODE_PRIVATE).edit().putString(key,value.toString()).apply()
    }
}