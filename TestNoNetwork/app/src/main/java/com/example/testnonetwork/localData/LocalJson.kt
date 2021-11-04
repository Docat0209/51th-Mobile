package com.example.testnonetwork.localData

import android.app.Activity
import android.content.Context
import org.json.JSONObject

class LocalJson(val context: Context) {
    fun read(key:String): JSONObject {
        val data = (context as Activity).getPreferences(Context.MODE_PRIVATE).getString(key,"{}").toString()
        return JSONObject(data)
    }
    fun write(key: String , jsonObject: JSONObject){
        (context as Activity).getPreferences(Context.MODE_PRIVATE).edit().putString(key,jsonObject.toString()).apply()
    }
}