package com.example.covid19vaccineapp.local_data

import android.app.Activity
import android.content.Context
import org.json.JSONObject

class JsonLocalData(val activity: Activity) {

    private fun getLocalData(): JSONObject {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        val json = sharedPref.getString("LocalData","")

        return JSONObject(json.toString())
    }

    private fun saveLocalData(body: JSONObject){
        activity.getPreferences(Context.MODE_PRIVATE)
            .edit()
            .putString("LocalData", body.toString())
            .apply()
    }
}