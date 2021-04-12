package com.example.animalforest2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val picId =
            arrayListOf<ImageButton>(
                pic1, pic2, pic3, pic4, pic5,
                pic6, pic7, pic8, pic9, pic10
            )

        val bundle = Bundle()
        val intent = Intent(this, third::class.java)
        var idx: Int

        for ((index, value) in picId!!.withIndex()) {
            value.setOnClickListener {
                idx = index
                bundle.putSerializable("idx", idx)
                intent.putExtra("bundle", bundle)
                startActivityForResult(intent, 0)
            }
        }
        val matchTest = Intent(this, matchAnimalTest::class.java)
        val intentSv = Intent(this, serve1::class.java)

        btn2.setOnClickListener{
            startActivity(matchTest)
        }

        btn4.setOnClickListener{
            startActivity(intentSv)
        }



    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val picId =
            arrayListOf<ImageButton>(
                pic1, pic2, pic3, pic4, pic5,
                pic6, pic7, pic8, pic9, pic10
            )
        var bundle = Bundle()
        var img: Int?
        var idx: Int?

        val intent1 = Intent(this, fifth_1::class.java)
        val intent2 = Intent(this, fifth_2::class.java)
        val intent3 = Intent(this, fifth_3::class.java)
        val intent4 = Intent(this, fifth_4::class.java)
        val intent5 = Intent(this, fifth_5::class.java)
        val intent6 = Intent(this, fifth_6::class.java)
        val intent7 = Intent(this, fifth_7::class.java)
        val intent8 = Intent(this, fifth_8::class.java)
        val intent9 = Intent(this, fifth_9::class.java)
        val intent10 = Intent(this, fifth_10::class.java)


        if (resultCode == Activity.RESULT_OK) {
            img = data!!.getIntExtra("img", 0)
            idx = data!!.getIntExtra("idx", 0)

            picId.get(idx).setImageResource(img!!)

//            fun saveImg(Key:String, Value:Int){
//                val pref = getSharedPreferences("image", Context.MODE_PRIVATE)
//                val ed = pref.edit()
//                ed.putInt(Key, Value)
//                ed.apply()
//            }
//
//            saveImg("image",img)

            heart1.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent1.putExtra("bundle", bundle)

                startActivity(intent1)
            }

            heart2.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent2.putExtra("bundle", bundle)
                startActivity(intent2)
            }

            heart3.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent3.putExtra("bundle", bundle)
                startActivity(intent3)
            }

            heart4.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent4.putExtra("bundle", bundle)
                startActivity(intent4)
            }

            heart5.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent5.putExtra("bundle", bundle)
                startActivity(intent5)
            }

            heart6.setOnClickListener {
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent6.putExtra("bundle", bundle)
                startActivity(intent6)
            }
            heart7.setOnClickListener{
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent7.putExtra("bundle", bundle)
                startActivity(intent7)
            }
            heart8.setOnClickListener{
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent8.putExtra("bundle", bundle)
                startActivity(intent8)
            }
            heart9.setOnClickListener{
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent9.putExtra("bundle", bundle)
                startActivity(intent9)
            }
            heart10.setOnClickListener{
                bundle.putSerializable("img", img)
                bundle.putSerializable("idx", idx)

                intent10.putExtra("bundle", bundle)
                startActivity(intent10)
            }

        }

    }
}
