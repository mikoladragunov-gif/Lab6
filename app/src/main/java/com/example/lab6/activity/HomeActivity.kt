package com.example.lab6.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.adapter.ItemAdapter
import com.example.lab6.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var welcomeText: TextView
    private lateinit var bottomNav: BottomNavigationView

    private val items = listOf(
        "🍕 Піца Маргарита",
        "🍔 Бургер BBQ",
        "🥗 Салат Цезар",
        "🍣 Суші з лососем",
        "🍩 Пончик із шоколадом",
        "🍜 Рамен японський",
        "🍹 Мохіто безалкогольний",
        "🍟 Картопля фрі"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userName = intent.getStringExtra("userName")
        val userEmail = intent.getStringExtra("userEmail")

        welcomeText = findViewById(R.id.tvWelcome)
        welcomeText.text = "Привіт, ${userName ?: "користувач"}!"

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(items) { pos, title ->
            Toast.makeText(this, "Натиснуто: $title", Toast.LENGTH_SHORT).show()
        }

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    Toast.makeText(this, "Головна", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_theme -> {
                    toggleTheme()
                    true
                }
                R.id.menu_profile -> {
                    Toast.makeText(this, "Профіль: ${userEmail ?: "-"}", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun toggleTheme() {
        val mode = AppCompatDelegate.getDefaultNightMode()
        AppCompatDelegate.setDefaultNightMode(
            if (mode == AppCompatDelegate.MODE_NIGHT_YES)
                AppCompatDelegate.MODE_NIGHT_NO
            else
                AppCompatDelegate.MODE_NIGHT_YES
        )
        recreate()
    }
}
