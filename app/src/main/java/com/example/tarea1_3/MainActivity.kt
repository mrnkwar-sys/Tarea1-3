package com.example.tarea1_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val correctUser = "admin";
    private val correctPassword = "1234";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUser = findViewById<EditText>(R.id.editTextText)
        val etPassword = findViewById<EditText>(R.id.editTextPassword)
        val botonAcceder = findViewById<Button>(R.id.botonAcceder)

        botonAcceder.setOnClickListener{
            val userIntroduced = etUser.text.toString()
            val passIntroduced = etPassword.text.toString()

            if (userIntroduced == correctUser && passIntroduced == correctPassword){
                val acceso = Intent(this, WelcomeActivity::class.java)
                acceso.putExtra("usuario", userIntroduced)
                startActivity(acceso)
            } else {
                val acceso = Intent(this, ErrorActivity::class.java)
                startActivity(acceso)
            }

//            finish()
//            startActivity(acceso)
            Log.d(":::tag","Todo OK")
        }
    }
}