package com.example.intent_kotlin_task4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
        loadDates()
    }

    private fun initViews() {
        textView = findViewById(R.id.text_second)
        backButton = findViewById(R.id.btn_second)
        backButton.setOnClickListener {
            val member = Member("Kotlin", "Java")
            backToMain(member)
        }
    }

    private fun loadDates() {
        val user = intent.getParcelableExtra<User>("user")
        textView.text = user.toString()
    }

    private fun backToMain(member: Member) {
        val intent = Intent()
        intent.putExtra("member", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}