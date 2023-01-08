package com.example.myquizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val text: TextView = findViewById(R.id.name)
        val button: Button = findViewById(R.id.finalbutton)
        val content: TextView = findViewById(R.id.description)

        text.text= intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val totalquestion = intent.getIntExtra(Constants.TOTAL_QUESTION,0)

        content.text = "Your Score is ${score} form ${totalquestion}"

        button.setOnClickListener {
            Toast.makeText(this,"Quiz End", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}