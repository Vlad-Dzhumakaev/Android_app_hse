package com.example.converter

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        var bool: Boolean = true;
        btn.setOnClickListener{
            if (bool == true){
                btn.text = "USD"
                btn1.text = "RUB"
                bool = false
            }
            else if (bool == false){
                btn1.text = "USD"
                btn.text = "RUB"
                bool = true
            }
        }
        btn1.setOnClickListener{
            if (bool == true){
                btn.text = "USD"
                btn1.text = "RUB"
                bool = false
            }
            else if (bool == false){
                btn1.text = "USD"
                btn.text = "RUB"
                bool = true
            }
        }
        btn_0.setOnClickListener {setTextFields("0")}
        btn_1.setOnClickListener {setTextFields("1")}
        btn_2.setOnClickListener {setTextFields("2")}
        btn_3.setOnClickListener {setTextFields("3")}
        btn_4.setOnClickListener {setTextFields("4")}
        btn_5.setOnClickListener {setTextFields("5")}
        btn_6.setOnClickListener {setTextFields("6")}
        btn_7.setOnClickListener {setTextFields("7")}
        btn_8.setOnClickListener {setTextFields("8")}
        btn_9.setOnClickListener {setTextFields("9")}
        btn_tochka.setOnClickListener {
            setTextFields(".")
        }

        btn_AC.setOnClickListener {
            math_operation_on.text=""
            result_text.text=""
        }
        btn_Back.setOnClickListener{
            val str = math_operation_on.text.toString()
            if(str.isNotEmpty())  math_operation_on.text=str.substring(0,str.length-1)
            result_text.text=""

        }
        btn_equal.setOnClickListener{
            try {
                val str: String = math_operation_on.text.toString()
                val value: Double = str.toDouble()
                val kurs = 74
                var valuta: Double = 0.0;
                if (btn.text =="RUB") valuta = value / kurs
                else if (btn.text =="USD") valuta = value * kurs
                result_text.text = valuta.toString()
            }catch(e:Exception){
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }
   
    fun setTextFields(str:String){
        math_operation_on.append(str)
    }
}