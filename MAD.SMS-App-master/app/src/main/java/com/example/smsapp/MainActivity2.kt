package com.example.smsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()

        val num:EditText = findViewById(R.id.txt11)
        val msg:EditText = findViewById(R.id.txt12)
        val btn:Button = findViewById(R.id.send_button)
        val rst:TextView = findViewById(R.id.textView2)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS),10)

        btn.setOnClickListener {
            val number = num.text.toString()
            val message = msg.text.toString()
            val smsManager:SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(number,null,message,null,null)
            Toast.makeText(this, "Message send", Toast.LENGTH_SHORT).show()
        }

        rst.setOnClickListener {
            num.text = null
            msg.text = null
        }
    }
}