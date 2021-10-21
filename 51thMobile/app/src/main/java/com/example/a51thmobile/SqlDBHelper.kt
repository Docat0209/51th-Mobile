package com.example.a51thmobile

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class SqlDBHelper(context:Context) :SQLiteOpenHelper(context,"user.db",null,4) {

    private val tableName: String = "user.db"
    override fun onCreate(db: SQLiteDatabase) {
        val SQLTable = "CREATE TABLE IF NOT EXISTS  $tableName ( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Phone TEXT," +
                "Hobby TEXT," +
                "ElseInfo TEXT" +
                ");"
        db.execSQL(SQLTable)
        db.close()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


    fun sql(string: String): Cursor? {
        val db = readableDatabase
        val c = db.rawQuery(string,null)
        db.close()
        return c
    }


}