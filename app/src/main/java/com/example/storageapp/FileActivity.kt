package com.example.storageapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileActivity : AppCompatActivity() {

    private lateinit var edInput: EditText
    private lateinit var btnWrite: Button
    private lateinit var btnRead: Button
    private lateinit var tvOutput: TextView

    private val fileName = "test.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        edInput = findViewById(R.id.ed_input)
        btnWrite = findViewById(R.id.btn_write)
        btnRead = findViewById(R.id.btn_read)
        tvOutput = findViewById(R.id.tv_output)

        btnWrite.setOnClickListener {
            val data = edInput.text.toString()
            if (data.isNotBlank()) {
                val file = File(filesDir, fileName)
                FileOutputStream(file).use {
                    it.write(data.toByteArray())
                }
                Toast.makeText(this, "Текст записан", Toast.LENGTH_SHORT).show()
                edInput.text.clear()
            }
        }

        btnRead.setOnClickListener {
            val file = File(filesDir, fileName)
            if (file.exists()) {
                val text = FileInputStream(file).bufferedReader().use { it.readText() }
                tvOutput.text = text
            } else {
                Toast.makeText(this, "Файл не найден", Toast.LENGTH_SHORT).show()
            }
        }
    }
}