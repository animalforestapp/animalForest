package com.example.project_animalforest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context,"db",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createQuery = "CREATE TABLE animal1"  +
                "( ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME, " +
                "CHARAC, " +
                "BIRTH," +
                "HOBBY," +
                "SEX," +
                "KIND," +
                "STYLE);"

        db?.execSQL(createQuery);

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE animal1")
        onCreate(db);
    }
}