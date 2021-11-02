package com.example.viaccineapp03.local_data

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlCommand(context: Context,val string: String):SQLiteOpenHelper(context,"test.db",null,4) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL("create table if not exists TempRec ( id integer primary key autoincrement , timeRecord text , tempRecord text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun run(){
        writableDatabase.execSQL(string)
    }

    fun getData(): Cursor {
        return readableDatabase.rawQuery(string,null)
    }
}