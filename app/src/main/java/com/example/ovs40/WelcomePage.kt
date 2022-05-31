package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomePage : AppCompatActivity() {
    lateinit var loginPage: TextView
    lateinit var createAccount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
        //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        //StrictMode.setThreadPolicy(policy)
        loginPage = findViewById(R.id.login)
        createAccount = findViewById(R.id.createAccount)
        loginPage.setOnClickListener {
            val nextPage = Intent(this, LoginPage::class.java)
            startActivity(nextPage)
        }
        createAccount.setOnClickListener {
            val nextPage = Intent(this, SignupPage::class.java)
            startActivity(nextPage)
        }
    }
}