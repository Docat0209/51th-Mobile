package com.example.viaccineapp03.local_data

import android.app.Activity
import android.content.Context
import org.json.JSONObject

class LocalJson(val context: Context) {
    fun getData(key:String): JSONObject {
        val data = (context as Activity).getPreferences(Context.MODE_PRIVATE).getString(key,"{}")
        return JSONObject(data.toString())
    }
    fun putData(key: String , jsonObject: JSONObject){
        context.getSharedPreferences(key,Context.MODE_PRIVATE)
            .edit()
            .putString(key,jsonObject.toString())
            .apply()
    }
}