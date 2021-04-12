package com.example.animalforest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_serve1.*

class serve1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serve1)

        back.setOnClickListener{
            finish()
        }
        up1.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.up1, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 +1")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        up2.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.up2, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 +2")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        up3.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.up3, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 +3")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        up4.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.up4, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 +4")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        down2.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.down2, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 -2")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        down3.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.down3, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 -3")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}
        down5.setOnClickListener{
            val dlgView = layoutInflater.inflate(R.layout.down5, null)
            val dlgBuilder = AlertDialog.Builder(this)
            dlgBuilder.setTitle("호감도 -5")
            dlgBuilder.setView(dlgView)
            dlgBuilder.setPositiveButton("확인") { dialogInterface, i ->
            }.show()}

    }
}
