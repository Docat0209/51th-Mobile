package com.example.a51_mobile_design.local_data

import android.app.Activity
import android.content.Context
import org.json.JSONObject

class JsonLocalData(private val activity: Activity, private val key:String) {

    fun getLocalData(): JSONObject{
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        val json = sharedPref.getString(key,"")
        if(json.toString().isNotEmpty()) {
            return JSONObject(json.toString()).put("state",true)
        }
        return JSONObject().put("state",false)
    }

    fun saveLocalData(body: JSONObject){
        activity.getPreferences(Context.MODE_PRIVATE)
            .edit()
            .putString(key, body.toString())
            .apply()
    }
}