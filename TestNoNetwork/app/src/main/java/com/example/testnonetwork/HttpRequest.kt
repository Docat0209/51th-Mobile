package com.example.testnonetwork

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpRequest(private val link:String) {
    fun httpGet(result:(JSONObject) -> Unit) {
        Thread {
            result(JSONObject(URL(link).readText()))
        }.start()
    }
    fun httpPost(jsonObject: JSONObject, result: (JSONObject) -> Unit){
        Thread{
            with(URL(link).openConnection() as HttpURLConnection){
                requestMethod = "POST"
                doOutput = true
                addRequestProperty("Content-Type","application/json")
                outputStream.write(jsonObject.toString().toByteArray())
                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()
                    var inputLine = it.readLine()
                    while (inputLine != null){
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    disconnect()
                    result(JSONObject(response.toString()))
                }
            }
        }.start()
    }
}