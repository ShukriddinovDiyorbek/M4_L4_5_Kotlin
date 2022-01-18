package com.example.intent_kotlin_task4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textView = findViewById(R.id.text_main)
        button = findViewById(R.id.btn_main)
        button.setOnClickListener {
            val user = User("Android", "12")
            openSecondActivity(user)
        }
    }

    private fun openSecondActivity(user: User) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        response.launch(intent)
    }

    private var response = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { res ->
        if (res.resultCode == Activity.RESULT_OK) {
            val data = res.data
            textView.text = data!!.getParcelableExtra<Member>("member").toString()
        }
    }
}