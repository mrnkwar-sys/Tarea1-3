package com.example.tarea1_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AccesosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_accesos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val searchText = findViewById<EditText>(R.id.searchTextInput)
        val navButton = findViewById<Button>(R.id.navButton)
        val phoneButton = findViewById<Button>(R.id.phoneButton)
        val messageButton = findViewById<Button>(R.id.messageButton)
        val shareButton = findViewById<Button>(R.id.shareButton)
        val backButton = findViewById<Button>(R.id.backButton)

        navButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=${searchText.text}")
            startActivity(intent)
        }

        phoneButton.setOnClickListener {
            val phoneNumber = searchText.text.toString().trim()

            if (phoneNumber.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phoneNumber")
                }
                startActivity(intent)
            }
        }

        messageButton.setOnClickListener {
            val number = searchText.text.toString().trim()
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("smsto:" + number) // número escrito en el EditText
            smsIntent.putExtra("sms_body", "Hola desde mi app") // texto opcional
            startActivity(smsIntent)
        }

        shareButton.setOnClickListener {
            val textIntroduced = searchText.text.toString().trim()
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, textIntroduced) // texto escrito en el EditText
            startActivity(Intent.createChooser(shareIntent, "Compartir con..."))
        }

        backButton.setOnClickListener {
            finish()
        }
    }

}