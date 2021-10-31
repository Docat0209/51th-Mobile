package com.example.a51_mobile_design.local_data

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context) : SQLiteOpenHelper(context,"data.db",null,5){
    override fun onCreate(p0: SQLiteDatabase) {
        val sqlCommand = "create table if not exists TempRec(id integer primary key autoincrement , time text , tempNum text)"
        p0.execSQL(sqlCommand)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0.execSQL("drop table if exists TempRec")
        onCreate(p0)
    }

    fun sqlData(sqlCommand : String): Cursor {
        return readableDatabase.rawQuery(sqlCommand,null)
    }

    fun sql(sqlCommand: String){
        writableDatabase.execSQL(sqlCommand)
    }

}