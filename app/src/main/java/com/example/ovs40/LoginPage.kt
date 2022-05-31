package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import com.example.ovs.output
import com.google.android.material.textfield.TextInputEditText

class LoginPage : AppCompatActivity() {
    lateinit var matric: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        matric = findViewById(R.id.loginMatricNo)
        password = findViewById(R.id.loginPassword)
        login = findViewById(R.id.loginBtn)
        login.setOnClickListener {
            login()

        }

    }

    fun login() {
        var log = com.example.ovs.login(output, "${matric.text},${password.text}")
        Toast.makeText(this, log, Toast.LENGTH_SHORT).show()
        if (log == "logged in") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        } else {
            log = null.toString()
        }
    }
}