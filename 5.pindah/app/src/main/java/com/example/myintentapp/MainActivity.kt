package com.example.myintentapp

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btn1_btn1)
        btn1.setOnClickListener(this)

        val btn2: Button =findViewById(R.id.btn2_btn2)
        btn2.setOnClickListener(this)

        val btn3:Button =findViewById(R.id.btn3_btn3)
        btn3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1_btn1->{
                val moveIntent=Intent(this@MainActivity, Main2Activity::class.java)
                startActivity(moveIntent)
                }
            R.id.btn2_btn2->{
                val moveWithDataIntent=Intent(this@MainActivity, Main3Activity::class.java)
                moveWithDataIntent.putExtra(Main3Activity.EXTRA_NAME, "M. BAHRIL ILMI")
                moveWithDataIntent.putExtra(Main3Activity.EXTRA_AGE, 19)
                startActivity(moveWithDataIntent)
                }
            R.id.btn3_btn3->{
                val PN = "081350375976"
                val dialPhoneIntent=Intent(Intent(ACTION_DIAL, Uri.parse("tel:$PN")))
                startActivity(dialPhoneIntent)
            }
        }
    }
}
