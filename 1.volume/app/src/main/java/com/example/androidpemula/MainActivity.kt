package com.example.androidpemula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity (), View.OnClickListener{
    private lateinit var edtwidth: EditText
    private lateinit var edtheight: EditText
    private lateinit var edtlenght: EditText
    private lateinit var btncalculate: Button
    private lateinit var tvresult: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState:Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvresult.text.toString())
    }

    override fun onCreate(savedInstanceStat: Bundle?){
        super.onCreate(savedInstanceStat)
        setContentView(R.layout.activity_main)

        edtheight=findViewById(R.id.edt_height)
        edtlenght=findViewById(R.id.edt_length)
        edtwidth=findViewById(R.id.edt_width)
        btncalculate=findViewById(R.id.btn_calculate)
        tvresult=findViewById(R.id.tv_result)
        btncalculate.setOnClickListener(this)

        if (savedInstanceStat != null){
            val result = savedInstanceStat.getString(STATE_RESULT) as String
            tvresult.text = result
        }
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }


    override fun onClick(v: View?) {
        if (v!!.id == R.id.btn_calculate){
            val inputlenght=edtlenght.text.toString().trim()
            val inputheight=edtheight.text.toString().trim()
            val inputwidth=edtwidth.text.toString().trim()

            var isEmptyFields=false
            var isInvalidDouble=false

            if (inputlenght.isEmpty()){
                isEmptyFields=true
                edtlenght.error="Fiedl ini wajib di isi ya !!!"
            }
            if (inputheight.isEmpty()){
                isEmptyFields=true
                edtheight.error="Filed ini wajib di isi ya !!!"
            }
            if (inputwidth.isEmpty()){
                isEmptyFields=true
                edtwidth.error="Field ini wajib di isi ya !!!"
            }

            val lenght = toDouble(inputlenght)
            val width = toDouble(inputwidth)
            val height = toDouble(inputheight)

            if (lenght==null){
                isInvalidDouble=true
                edtlenght.error=("Field ini harus di isi dengan nomor yang valid")
            }
            if (width==null){
                isInvalidDouble=true
                edtwidth.error=("Field ini harus di isi dengan nomor yang valid")
            }
            if (height==null){
                isInvalidDouble=true
                edtheight.error=("Filed ini harus di isi dengan nomro yang valid")
            }
            if (!isEmptyFields && !isInvalidDouble){
                val volume=lenght as Double*width as Double*height as Double
                tvresult.text=volume.toString()
            }
        }
    }
}

