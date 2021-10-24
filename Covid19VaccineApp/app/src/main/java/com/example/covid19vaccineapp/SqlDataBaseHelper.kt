package com.example.covid19vaccineapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlDataBaseHelper(context:Context):SQLiteOpenHelper(context,"test.db",null,4) {

    override fun onCreate(p0: SQLiteDatabase) {
        val sql = "CREATE TABLE if not exists user ( id integer PRIMARY KEY autoincrement, email text UNIQUE, password text , name text , phone text , address text)"
        println("Table Create")
        p0.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun query(sqlString:String) {
        writableDatabase.execSQL(sqlString)
    }

    fun getDate(sqlString: String):Cursor{
        return readableDatabase.rawQuery(sqlString,null)
    }



}