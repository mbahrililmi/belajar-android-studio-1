package com.example.pahlawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


data class Hero(
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
