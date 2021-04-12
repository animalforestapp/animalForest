package com.example.animalforest2

import android.app.AlertDialog
import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fifth.*
import kotlin.math.round

class fifth_9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_9)



        setTitle("호감도 확인")


        //이미지 인텐트
        var bundle = intent.getBundleExtra("bundle") ?: null
        var image = bundle?.getSerializable("img") as Int
        var idx = bundle?.getSerializable("idx") as Int


        img.setImageResource(image)


        var cnt = Array<Int>(16, { i -> 0 })
        val plusId = arrayListOf<ImageButton>(
            plus1,
            plus2,
            plus3,
            plus4,
            plus5,
            plus6,
            plus7,
            plus8,
            plus9,
            plus10,
            plus11,
            plus12,
            plus13,
            plus14,
            plus15,
            plus16
        )
        val minusId = arrayListOf<ImageButton>(
            minus1,
            minus2,
            minus3,
            minus4,
            minus5,
            minus6,
            minus7,
            minus8,
            minus9,
            minus10,
            minus11,
            minus12,
            minus13,
            minus14,
            minus15,
            minus16
        )
        val editId = arrayListOf<EditText>(
            edt1,
            edt2,
            edt3,
            edt4,
            edt5,
            edt6,
            edt7,
            edt8,
            edt9,
            edt10,
            edt11,
            edt12,
            edt13,
            edt14,
            edt15,
            edt16
        )

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        //edittext값 저장하는 함수
        fun saveData(
            num1: Int,
            num2: Int,
            num3: Int,
            num4: Int,
            num5: Int,
            num6: Int,
            num7: Int,
            num8: Int,
            num9: Int,
            num10: Int,
            num11: Int,
            num12: Int,
            num13: Int,
            num14: Int,
            num15: Int,
            num16: Int
        ) {
            val pref = this.getPreferences(0)
            val editor = pref.edit()
            // 키와 밸류를 쌍으로 저장하고 apply한다
            editor.putInt("KEY_NUM1", num1).apply()
            editor.putInt("KEY_NUM2", num2).apply()
            editor.putInt("KEY_NUM3", num3).apply()
            editor.putInt("KEY_NUM4", num4).apply()
            editor.putInt("KEY_NUM5", num5).apply()
            editor.putInt("KEY_NUM6", num6).apply()
            editor.putInt("KEY_NUM7", num7).apply()
            editor.putInt("KEY_NUM8", num8).apply()
            editor.putInt("KEY_NUM9", num9).apply()
            editor.putInt("KEY_NUM10", num10).apply()
            editor.putInt("KEY_NUM11", num11).apply()
            editor.putInt("KEY_NUM12", num12).apply()
            editor.putInt("KEY_NUM13", num13).apply()
            editor.putInt("KEY_NUM14", num14).apply()
            editor.putInt("KEY_NUM15", num15).apply()
            editor.putInt("KEY_NUM16", num16).apply()

        }

        //edittext값 불러오는 함수
        fun loadData() {
            val pref = this.getPreferences(0)
            // 키에 해당되는 밸류를 가져오는데 저장된 값이 없으면 0을 가져온다
            val num1 = pref.getInt("KEY_NUM1", 0)
            val num2 = pref.getInt("KEY_NUM2", 0)
            val num3 = pref.getInt("KEY_NUM3", 0)
            val num4 = pref.getInt("KEY_NUM4", 0)
            val num5 = pref.getInt("KEY_NUM5", 0)
            val num6 = pref.getInt("KEY_NUM6", 0)
            val num7 = pref.getInt("KEY_NUM7", 0)
            val num8 = pref.getInt("KEY_NUM8", 0)
            val num9 = pref.getInt("KEY_NUM9", 0)
            val num10 = pref.getInt("KEY_NUM10", 0)
            val num11 = pref.getInt("KEY_NUM11", 0)
            val num12 = pref.getInt("KEY_NUM12", 0)
            val num13 = pref.getInt("KEY_NUM13", 0)
            val num14 = pref.getInt("KEY_NUM14", 0)
            val num15 = pref.getInt("KEY_NUM15", 0)
            val num16 = pref.getInt("KEY_NUM16", 0)
            if (num1 != 0 || num2 != 0 || num3 != 0 || num4 != 0 || num5 != 0 || num6 != 0 || num7 != 0 || num8 != 0 || num9 != 0 || num10 != 0 || num11 != 0 || num12 != 0 || num13 != 0 || num14 != 0 || num15 != 0 || num16 != 0) {
                edt1.setText(num1.toString())
                edt2.setText(num2.toString())
                edt3.setText(num3.toString())
                edt4.setText(num4.toString())
                edt5.setText(num5.toString())
                edt6.setText(num6.toString())
                edt7.setText(num7.toString())
                edt8.setText(num8.toString())
                edt9.setText(num9.toString())
                edt10.setText(num10.toString())
                edt11.setText(num11.toString())
                edt12.setText(num12.toString())
                edt13.setText(num13.toString())
                edt14.setText(num14.toString())
                edt15.setText(num15.toString())
                edt16.setText(num16.toString())

            } else {
                edt1.setText(0.toString())
                edt2.setText(0.toString())
                edt3.setText(0.toString())
                edt4.setText(0.toString())
                edt5.setText(0.toString())
                edt6.setText(0.toString())
                edt7.setText(0.toString())
                edt8.setText(0.toString())
                edt9.setText(0.toString())
                edt10.setText(0.toString())
                edt11.setText(0.toString())
                edt12.setText(0.toString())
                edt13.setText(0.toString())
                edt14.setText(0.toString())
                edt15.setText(0.toString())
                edt16.setText(0.toString())
            }
        }

        //result 값 저장하는 함수
        fun saveRes(Key: String, Value: Int) {
            val pref = getSharedPreferences("result9", Context.MODE_PRIVATE)
            val ed = pref.edit()
            ed.putInt(Key, Value)
            ed.apply()
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //초기값
        var result: Int = 25
        val pref = getSharedPreferences("result9", Context.MODE_PRIVATE)
        result = pref.getInt("result9", 25)

        perc.text = (round(((result.toDouble() / 255 * 100) * 10) / 10)).toString() + "%"
        rate.rating = 1.toFloat()

        //데이터 불러오기
        loadData()

        //레이팅바를 직접 터치하여 조작하는 동작 잠금시키기
        rate.setOnTouchListener(View.OnTouchListener { view, event -> // 터치 이벤트 제거
            true
        })

        //레이팅 바 증감시키기
        if (result <= 0.0) {
            rate.rating = 0.toFloat()
        } else if (0.0 < result && result <= 29.0) {
            rate.rating = 1.toFloat()
        } else if (29.0 < result && result <= 59.0) {
            rate.rating = 2.toFloat()
        } else if (59.0 < result && result <= 99.0) {
            rate.rating = 3.toFloat()
        } else if (99.0 < result && result <= 149.0) {
            rate.rating = 4.toFloat()
        } else if (149.0 < result && result <= 199.0) {
            rate.rating = 5.toFloat()
        } else if (199.0 < result) {
            rate.rating = 6.toFloat()
        }

        //플러스버튼 클릭 시 에디트 텍스트 숫자 증가
        var i = 0
        for (ImageButton in plusId) {
            var j = i
            ImageButton.setOnClickListener() {
                cnt[j] = editId[j].text.toString().toInt()
                cnt[j]++
                //증가된 값을 에디트텍스트에 전달
                editId[j].setText(cnt[j].toString())

                //각 호감도 수치정도에 따라 결과값 반영
                if (j == 0 || j == 1) {                              //1 증가
                    result += 1
                } else if (j == 7 || j == 9 || j == 12) {                 //2 증가
                    result += 2
                } else if (j == 8 || j == 13 || j == 14) {                //3 증가
                    result += 3
                } else if (j == 2 || j == 10 || j == 15) {                //4 증가
                    result += 4
                } else if (j == 6) {                              //2 감소
                    result -= 2
                } else if (j == 3 || j == 4 || j == 5) {                  //3 감소
                    result -= 3
                } else if (j == 11) {                             //5 감소
                    result -= 5
                }
                perc.text = (round(((result.toDouble() / 255 * 100) * 10) / 10)).toString() + "%"
                Toast.makeText(this, "호감도 수치는 총 ${result}", Toast.LENGTH_SHORT).show()

                //레이팅 바 증감시키기
                if (result <= 0.0) {
                    rate.rating = 0.toFloat()
                } else if (0.0 < result && result <= 29.0) {
                    rate.rating = 1.toFloat()
                } else if (29.0 < result && result <= 59.0) {
                    rate.rating = 2.toFloat()
                } else if (59.0 < result && result <= 99.0) {
                    rate.rating = 3.toFloat()
                } else if (99.0 < result && result <= 149.0) {
                    rate.rating = 4.toFloat()
                } else if (149.0 < result && result <= 199.0) {
                    rate.rating = 5.toFloat()
                } else if (199.0 < result) {
                    rate.rating = 6.toFloat()
                }
            }
            i++
        }

        //마이너스버튼 클릭 시 에디트 텍스트 숫자 증가
        i = 0
        for (ImageButton in minusId) {
            var j = i
            ImageButton.setOnClickListener() {
                cnt[j] = editId[j].text.toString().toInt()
                cnt[j]--
                //증가된 값을 에디트텍스트에 전달
                editId[j].setText(cnt[j].toString())

                //각 호감도 수치정도에 따라 결과값 반영
                if (j == 0 || j == 1) {                              //1 감소
                    result -= 1
                } else if (j == 7 || j == 9 || j == 12) {                 //2 감소
                    result -= 2
                } else if (j == 8 || j == 13 || j == 14) {                //3 감소
                    result -= 3
                } else if (j == 2 || j == 10 || j == 15) {                //4 감소
                    result -= 4
                } else if (j == 6) {                              //2 증가
                    result += 2
                } else if (j == 3 || j == 4 || j == 5) {                  //3 증가
                    result += 3
                } else if (j == 11) {                             //5 증가
                    result += 5
                }
                perc.text = (round(((result.toDouble() / 255 * 100) * 10) / 10)).toString() + "%"
                Toast.makeText(this, "호감도 수치는 총 ${result}", Toast.LENGTH_SHORT).show()


                //레이팅 바 증감시키기
                if (result <= 0.0) {
                    rate.rating = 0.toFloat()
                } else if (0.0 < result && result <= 29.0) {
                    rate.rating = 1.toFloat()
                } else if (29.0 < result && result <= 59.0) {
                    rate.rating = 2.toFloat()
                } else if (59.0 < result && result <= 99.0) {
                    rate.rating = 3.toFloat()
                } else if (99.0 < result && result <= 149.0) {
                    rate.rating = 4.toFloat()
                } else if (149.0 < result && result <= 199.0) {
                    rate.rating = 5.toFloat()
                } else if (199.0 < result) {
                    rate.rating = 6.toFloat()
                }
            }
            i++
        }

        btn.setOnClickListener {
            val n1 = Integer.parseInt(edt1.getText().toString())
            val n2 = Integer.parseInt(edt2.getText().toString())
            val n3 = Integer.parseInt(edt3.getText().toString())
            val n4 = Integer.parseInt(edt4.getText().toString())
            val n5 = Integer.parseInt(edt5.getText().toString())
            val n6 = Integer.parseInt(edt6.getText().toString())
            val n7 = Integer.parseInt(edt7.getText().toString())
            val n8 = Integer.parseInt(edt8.getText().toString())
            val n9 = Integer.parseInt(edt9.getText().toString())
            val n10 = Integer.parseInt(edt10.getText().toString())
            val n11 = Integer.parseInt(edt11.getText().toString())
            val n12 = Integer.parseInt(edt12.getText().toString())
            val n13 = Integer.parseInt(edt13.getText().toString())
            val n14 = Integer.parseInt(edt14.getText().toString())
            val n15 = Integer.parseInt(edt15.getText().toString())
            val n16 = Integer.parseInt(edt16.getText().toString())

            saveData(   //데이터 저장
                n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16
            )
            saveRes("result9", result)
            finish()    //액티비티 종료 함수
        }

        reset.setOnClickListener {
            val dlgView = layoutInflater.inflate(R.layout.reset, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setView(dlgView)

            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
                //대화상자의 확인 버튼 누르면 메인액티비티에 반영
                edt1.setText(0.toString())
                edt2.setText(0.toString())
                edt3.setText(0.toString())
                edt4.setText(0.toString())
                edt5.setText(0.toString())
                edt6.setText(0.toString())
                edt7.setText(0.toString())
                edt8.setText(0.toString())
                edt9.setText(0.toString())
                edt10.setText(0.toString())
                edt11.setText(0.toString())
                edt12.setText(0.toString())
                edt13.setText(0.toString())
                edt14.setText(0.toString())
                edt15.setText(0.toString())
                edt16.setText(0.toString())
                result=25
                rate.rating = 1.toFloat()
                perc.text = (round(((result.toDouble() / 255 * 100) * 10) / 10)).toString() + "%"
            }.setNegativeButton("취소") { dialogInterface, i ->
            }.show()
        }
    }
}

