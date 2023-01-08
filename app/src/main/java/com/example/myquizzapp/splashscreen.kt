package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        var et: TextView = findViewById(R.id.et)
        var button: Button =findViewById(R.id.initialbutton)

        button.setOnClickListener {
            if(et.text.isEmpty()){
                Toast.makeText(this,"Enter Name!", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}