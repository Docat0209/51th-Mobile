package com.example.covid19vaccineapp

import com.google.api.Context
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class HttpGet(urlInput: String) {

    private val url = "http://54.234.67.26/taiwancovid19information/$urlInput"

    fun httpPost(body: JSONObject):JSONObject{
        with(URL(url).openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            doOutput = true

            addRequestProperty("Content-Type", "application/json")

            outputStream.write(body.toString().toByteArray())

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                disconnect()
                return JSONObject(response.toString())
            }
        }
    }

    fun get(): String {

        return URL(url).readText()

    }



}