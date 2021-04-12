package com.example.animalforest2

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.animalforest2.R
import com.example.project_animalforest.DBHelper
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setTitle("최고의 궁합 동물")
        var bundle = intent.getBundleExtra("bundle") ?: null
        var namelist = bundle?.getSerializable("namelist") as ArrayList<String>
        var idlist = bundle?.getSerializable("idlist") as ArrayList<String>

        val imageField = arrayListOf<Int>(
            R.drawable.ani1,
            R.drawable.ani2,
            R.drawable.ani3,
            R.drawable.ani4,
            R.drawable.ani5,
            R.drawable.ani6,
            R.drawable.ani7,
            R.drawable.ani8,
            R.drawable.ani9,
            R.drawable.ani10,
            R.drawable.ani11,
            R.drawable.ani12,
            R.drawable.ani13,
            R.drawable.ani14,
            R.drawable.ani15,
            R.drawable.ani16,
            R.drawable.ani17,
            R.drawable.ani18,
            R.drawable.ani19,
            R.drawable.ani20
        )

        var id = idlist.get(0)
        var database: SQLiteDatabase? = null            // 데이터베이스 선언
        val helper = DBHelper(this)             // 전체 주민 데이터베이스 헬퍼
        database = helper.writableDatabase //데이터베이스 읽기

        fun getInfo(tableName: String, Id: String) {
            //var namegethobby = arrayListOf<String>()
            var cursor: Cursor = database.query(tableName,null, null, null, null, null, null)
            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Hobby = cursor.getString(cursor.getColumnIndex("HOBBY"))
                val Birth = cursor.getString(cursor.getColumnIndex("BIRTH"))
                val Charac = cursor.getString(cursor.getColumnIndex("CHARAC"))
                val Sex = cursor.getString(cursor.getColumnIndex("SEX"))
                val Kind = cursor.getString(cursor.getColumnIndex("KIND"))
                val Style = cursor.getString(cursor.getColumnIndex("STYLE"))

                if(Id.equals(id)){
                    hobby.text = Hobby
                    birth.text = Birth
                    charac.text = Charac
                    sex.text = Sex
                    kind.text = Kind
                    style.text = Style
                }
            }
        }

        getInfo("animal1", id)

        for((index, value) in imageField.withIndex()){
            if(idlist[0] == (index+1).toString()){
                bestAnimalImg.setImageResource(value)

            }
        }
        BestAnimal.text = namelist[0]



        Toast.makeText(this,"${namelist.get(0)}", Toast.LENGTH_SHORT).show()

    }
}