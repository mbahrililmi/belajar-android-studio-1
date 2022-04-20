package com.example.myintenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn1 ->{

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnmoveactivity: Button=findViewById(R.id.btn1)
        btn5.setOnClickListener(this)
    }
}

