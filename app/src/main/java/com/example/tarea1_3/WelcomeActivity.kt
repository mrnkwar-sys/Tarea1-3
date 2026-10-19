package com.example.tarea1_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("usuario") ?: ""

        val welcomeTextView = findViewById<TextView>(R.id.welcomeText)
        welcomeTextView.text = "Bienvenido $username"

        val continueButton = findViewById<Button>(R.id.continueButton);
//        var acceso = Intent(this, WelcomeActivity::class.java)

        continueButton.setOnClickListener {
            val acceso = Intent(this, AccesosActivity::class.java)
            startActivity(acceso)
        }
    }
}