package com.example.storageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignUp: Button
    private lateinit var btnLogin: Button
    private lateinit var btnFile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btn_sign_up)
        btnLogin = findViewById(R.id.btn_login)
        btnFile = findViewById(R.id.btn_file)

        btnSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnFile.setOnClickListener {
            startActivity(Intent(this, FileActivity::class.java))
        }
    }
}