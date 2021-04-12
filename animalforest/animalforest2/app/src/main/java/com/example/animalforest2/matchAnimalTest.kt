package com.example.animalforest2

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.animalforest2.R
import com.example.project_animalforest.DBHelper
import kotlinx.android.synthetic.main.activity_match_animal_test.*
import kotlin.check

class matchAnimalTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_animal_test)

        var database: SQLiteDatabase? = null            // 데이터베이스 선언
        val helper = DBHelper(this)             // 전체 주민 데이터베이스 헬퍼
        database = helper.writableDatabase //데이터베이스 읽기

        fun dbInsert(
            tableName: String,
            id:Int,
            name: String,
            charac: String,
            birth: String,
            hobby: String,
            sex: String,
            kind: String,
            style: String
        ) {
            var contentValues = ContentValues()
            contentValues.put("NAME", name)
            contentValues.put("ID", id)
            contentValues.put("CHARAC", charac)
            contentValues.put("BIRTH", birth)
            contentValues.put("HOBBY", hobby)
            contentValues.put("SEX", sex)
            contentValues.put("KIND", kind)
            contentValues.put("STYLE", style)
            database!!.insert(tableName, null, contentValues)
        }

        dbInsert("animal1", 1,"1호", "운동광", "8/1", "운동", "남", "고양이","심플")
        dbInsert("animal1", 2,"2호", "아이돌", "7/2", "운동", "여", "다람쥐","심플")
        dbInsert("animal1", 3,"3호", "먹보", "10/3", "놀이", "남", "코끼리","심플")
        dbInsert("animal1", 4,"4호", "단순활발", "4/14", "운동", "여", "고릴라","쿨")
        dbInsert("animal1", 5,"가복희", "무뚝뚝", "11/29", "음악", "남", "고양이","심플")
        dbInsert("animal1", 6,"가위", "아이돌", "1/13", "패션", "여", "개구리","큐트")
        dbInsert("animal1", 7,"갈가리", "무뚝뚝", "9/14", "교육", "남", "다람쥐","쿨")
        dbInsert("animal1", 8,"개군", "자연", "6/6", "자연", "남", "개구리","엘레강스")
        dbInsert("animal1", 9,"거무틱", "무뚝뚝", "10/23", "음악", "남", "큰곰","쿨")
        dbInsert("animal1", 10,"건태", "운동광", "10/4", "운동", "남", "닭","심플")
        dbInsert("animal1", 11,"곰도로스", "느끼함", "3/31", "교육","남", "큰곰", "심플")
        dbInsert("animal1", 12,"곰비", "무뚝뚝", "8/2", "놀이", "여", "큰곰","쿨")
        dbInsert("animal1", 13,"곰시", "먹보", "3/2", "놀이", "남", "아기곰","쿨")
        dbInsert("animal1", 14,"곱슬이", "친절함", "4/3", "패션", "여", "양","엘레강스")
        dbInsert("animal1", 15,"관록", "무뚝뚝", "4/24", "운동", "남", "캥거루","쿨")
        dbInsert("animal1", 16,"구리구리", "운동광", "2/8", "운동", "남", "개구리","심플")
        dbInsert("animal1", 17,"귀오미", "친절함", "3/7", "자연", "여", "오리","큐트")
        dbInsert("animal1", 18,"그리미", "아이돌", "7/19", "패션", "여", "다람쥐","큐트")
        dbInsert("animal1", 19,"근성", "무뚝뚝", "10/13", "자연", "남", "코알라","쿨")
        dbInsert("animal1", 20,"근엄", "무뚝뚝", "12/7", "자연", "남", "독수리","심플")

        var cnt = Array<Int>(20,{ i->0})
        var index = 0
        fun DBHobbyYes(tableName: String, hobby: String) {
            //var namegethobby = arrayListOf<String>()
            var cursor:Cursor = database.query(tableName,null, null, null, null, null, null)
            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Hobby = cursor.getString(cursor.getColumnIndex("HOBBY"))
                if(Hobby.equals(hobby)){
                    //namegethobby.add(id)
                    index = id.toInt() -1
                    cnt[index]+=6
                }
            }
        }

        fun DBHobbyYesOther(tableName: String, hobby: String) {
            //var namegethobby = arrayListOf<String>()
            var cursor: Cursor = database.query(tableName, null, null, null, null, null, null)
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Hobby = cursor.getString(cursor.getColumnIndex("HOBBY"))
                if (Hobby != hobby) {
                    index = id.toInt() - 1
                    if (cnt[index] > 0) {
                        cnt[index]-=2
                    }
                }
            }
        }

        fun DBHobbyNo(tableName: String, hobby: String){
            var cursor: Cursor = database.query(tableName, null, null, null, null, null, null)
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Hobby = cursor.getString(cursor.getColumnIndex("HOBBY"))
                if(Hobby.equals(hobby)){
                    index = id.toInt() - 1
                    cnt[index]-=2
                }
            }
        }

        fun DBCharacSearch(tableName: String, charac: String) {
            //var namegetcharac = arrayListOf<String>()
            var cursor:Cursor = database.query(tableName,null, null, null, null, null, null)
            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Charac = cursor.getString(cursor.getColumnIndex("CHARAC"))
                if(Charac.equals(charac)){
                    //namegetcharac.add(id)
                    index = id.toInt() -1
                    cnt[index]+=7
                }
            }



        }

        fun DBStyleSearch(tableName: String, charac: String) {
            //var namegetstyle = arrayListOf<String>()
            var cursor:Cursor = database.query(tableName,null, null, null, null, null, null)
            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val Style = cursor.getString(cursor.getColumnIndex("STYLE"))
                if(Style.equals(charac)){
                    //namegetcolor.add(id)
                    index = id.toInt() -1
                    cnt[index]+=6
                }
            }
            //Toast.makeText(this,"${namegetcolor.get(0)}",Toast.LENGTH_SHORT).show()
        }

        var namelist = arrayListOf<String>()
        var idlist = arrayListOf<String>()
        var max = 0
        var dbid = 0
        fun findMaxCntAnimal(tableName: String): Unit{


            var cursor:Cursor = database.query(tableName,null, null, null, null, null, null)
//            for(i in cnt.indices){
//                if(cnt[index]>max) {
//                    max = cnt[index]
//                }
//            }
//            var dbid = index + 1



            for(i in cnt.indices){
                if(cnt[i] > max) {
                    max = cnt[i]
                    dbid = i + 1
                }
            }

            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex("ID"))
                val name = cursor.getString(cursor.getColumnIndex("NAME"))

                if(dbid.toString().equals(id)){
                    namelist.add(name)
                    idlist.add(id)
                }
            }
//            Toast.makeText(this,"${max}",Toast.LENGTH_LONG).show()
        }

        check.setOnClickListener {
            val intentResult = Intent(this,Result::class.java)

            if (ans1_1.isChecked) {
                DBCharacSearch("animal1","친절함")
                DBCharacSearch("animal1","아이돌")
                DBCharacSearch("animal1","운동광")
                DBCharacSearch("animal1","자연")

            }

            if (ans1_2.isChecked) {
                DBCharacSearch("animal1","무뚝뚝")
                DBCharacSearch("animal1","먹보")
            }
            if(ans2_1.isChecked){
                DBStyleSearch("animal1", "심플")
            }
            if(ans2_2.isChecked){
                DBStyleSearch("animal1", "쿨")
            }
            if(ans2_3.isChecked){
                DBStyleSearch("animal1", "큐트")
            }
            if(ans2_4.isChecked){
                DBStyleSearch("animal1", "엘레강스")
            }
            if(ans3_1.isChecked){
                DBHobbyYes("animal1", "교육")
                DBHobbyYesOther("animal1", "교육")
            }
            if(ans3_2.isChecked){
                DBHobbyNo("animal1", "교육")
            }
            if(ans4_1.isChecked){
                DBHobbyYes("animal1", "교육")
                DBHobbyYesOther("animal1", "교육")
            }
            if(ans4_2.isChecked){
                DBHobbyNo("animal1", "교육")
            }
            if(ans5_1.isChecked){
                DBHobbyYes("animal1", "패션")
                DBHobbyYesOther("animal1", "패션")
            }
            if(ans5_2.isChecked){
                DBHobbyNo("animal1", "패션")
            }
            if(ans6_1.isChecked){
                DBHobbyYes("animal1", "운동")
                DBCharacSearch("animal1","운동광")
                DBHobbyYesOther("animal1", "운동")
            }
            if(ans6_2.isChecked){
                DBHobbyNo("animal1", "운동")
            }
            if(ans7_1.isChecked){
                DBHobbyYes("animal1", "음악")
                DBHobbyYesOther("animal1", "음악")
            }
            if(ans7_2.isChecked){
                DBHobbyNo("animal1", "음악")
            }
            if(ans8_1.isChecked){
                DBHobbyYes("animal1", "자연")
                DBCharacSearch("animal1","자연")
                DBHobbyYesOther("animal1", "자연")
            }
            if(ans8_2.isChecked){
                DBHobbyNo("animal1", "자연")
            }
            if(ans9_1.isChecked){
                DBHobbyYes("animal1", "놀이")
                DBHobbyYesOther("animal1","놀이")
            }
            if(ans9_2.isChecked){
                DBHobbyNo("animal1", "놀이")
            }
//            Toast.makeText(this,"${cnt.get(0)},${cnt.get(1)},${cnt.get(2)},${cnt.get(3)},${cnt.get(4)},${cnt.get(5)},${cnt.get(6)},${cnt.get(7)},${cnt.get(8)},${cnt.get(9)},${cnt.get(10)},${cnt.get(11)},${cnt.get(12)},${cnt.get(13)},${cnt.get(14)},${cnt.get(15)},${cnt.get(16)},${cnt.get(17)},${cnt.get(18)},${cnt.get(19)}",Toast.LENGTH_LONG).show()

            findMaxCntAnimal("animal1")

            var bundle = Bundle()

            bundle.putSerializable("namelist",namelist)
            bundle.putSerializable("idlist",idlist)
            intentResult.putExtra("bundle",bundle)
            startActivity(intentResult)
        }

    }
    //뒤로가기 버튼 이벤트
    private final var FINISH_INTERVAL_TIME: Long = 2000
    private var backPressedTime: Long = 0
    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) {
            var tempTime = System.currentTimeMillis();
            var intervalTime = tempTime - backPressedTime;
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
            } else {
                backPressedTime = tempTime;
                Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
                return
            }
        }
        super.onBackPressed();
    }
}