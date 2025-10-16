package com.example.lab6.activity

import com.example.lab6.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etRegisterName)
        val etEmail = findViewById<EditText>(R.id.etRegisterEmail)
        val etPassword = findViewById<EditText>(R.id.etRegisterPassword)
        val etConfirm = findViewById<EditText>(R.id.etRegisterConfirm)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnGoToLogin = findViewById<Button>(R.id.btnGoToLogin)
        val tvError = findViewById<TextView>(R.id.tvRegisterError)

        btnGoToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirm = etConfirm.text.toString()

            when {
                name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty() -> {
                    tvError.text = "Будь ласка, заповніть всі поля"
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvError.text = "Некоректний формат email"
                }
                password.length < 6 -> {
                    tvError.text = "Пароль повинен містити щонайменше 6 символів"
                }
                password != confirm -> {
                    tvError.text = "Паролі не співпадають"
                }
                else -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.putExtra("userName", name)
                    intent.putExtra("userEmail", email)
                    intent.putExtra("userPassword", password)
                    startActivity(intent)
                }
            }
        }
    }
}
