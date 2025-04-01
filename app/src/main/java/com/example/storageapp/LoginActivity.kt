package com.example.storageapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var btnLogin: Button

    private val sharedPrefFile = "user_credentials"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edUsername = findViewById(R.id.ed_username)
        edPassword = findViewById(R.id.ed_password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val inputUsername = edUsername.text.toString()
            val inputPassword = edPassword.text.toString()

            val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
            val savedUsername = sharedPreferences.getString("username", null)
            val savedPassword = sharedPreferences.getString("password", null)

            if (inputUsername == savedUsername && inputPassword == savedPassword) {
                Toast.makeText(this, "Успешный вход", Toast.LENGTH_SHORT).show()

                // 🔄 Переход в FileActivity
                val intent = Intent(this, FileActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}