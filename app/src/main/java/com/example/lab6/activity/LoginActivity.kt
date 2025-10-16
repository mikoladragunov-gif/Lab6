package com.example.lab6.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.R

class LoginActivity : AppCompatActivity() {

    private var registeredName: String? = null
    private var registeredEmail: String? = null
    private var registeredPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etLoginEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etLoginPassword = findViewById<EditText>(R.id.etLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvLoginError = findViewById<TextView>(R.id.tvLoginError)

        // Get passed data (if any)
        registeredName = intent.getStringExtra("userName")
        registeredEmail = intent.getStringExtra("userEmail")
        registeredPassword = intent.getStringExtra("userPassword")

        btnLogin.setOnClickListener {
            val inputEmail = etLoginEmail.text.toString().trim()
            val inputPassword = etLoginPassword.text.toString()

            if (inputEmail == registeredEmail && inputPassword == registeredPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userName", registeredName)
                intent.putExtra("userEmail", registeredEmail)
                startActivity(intent)
            } else {
                tvLoginError.text = "Невірний email або пароль"
            }
        }
    }
}
