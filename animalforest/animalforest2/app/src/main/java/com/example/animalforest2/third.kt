package com.example.animalforest2



import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.icu.text.DateTimePatternGenerator.PatternInfo.OK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.animalforest2.R
import kotlinx.android.synthetic.main.activity_third.*

class third : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val bundle = intent.getBundleExtra("bundle") ?: null

        //메인액티비티로 부터 값을 받아옴
        val idx = bundle?.getSerializable("idx") as Int


        val imageField = arrayListOf<Int>(R.drawable.ani1, R.drawable.ani2, R.drawable.ani3, R.drawable.ani4, R.drawable.ani5, R.drawable.ani6,R.drawable.ani7, R.drawable.ani8, R.drawable.ani9, R.drawable.ani10)
        val checkBtn = arrayListOf<ImageButton>(check, check2,check3,check4,check5,check6,check7,check8,check9,check10)


        for((index,check) in checkBtn.withIndex()){
            check.setOnClickListener(){
                val img = imageField[index]
                //        val aniIdx = index
                val rIntent = Intent(this, second::class.java)

                rIntent.putExtra("img", img)
                rIntent.putExtra("idx", idx)
                //        rIntent.putExtra("aniIdx",aniIdx)


                setResult(Activity.RESULT_OK, rIntent)
                finish()

            }
        }




    }


}