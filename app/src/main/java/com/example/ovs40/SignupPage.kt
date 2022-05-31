package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import com.example.ovs.output
import com.example.ovs.send
import com.google.android.material.textfield.TextInputEditText

class SignupPage : AppCompatActivity() {
    lateinit var matric: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var confirmPassword: TextInputEditText
    lateinit var signup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        matric = findViewById(R.id.matricNumber)
        email = findViewById(R.id.email)
        password = findViewById(R.id.signupPassword)
        confirmPassword = findViewById(R.id.signupPasword2)
        signup = findViewById(R.id.signupBtn)
        signup.setOnClickListener {
            if (password.text.toString() == confirmPassword.text.toString()) {
                send(output, "signup,${matric.text},${email.text},${password.text}")
                val nextPage = Intent(this, LoginPage::class.java)
                startActivity(nextPage)
            }
            else{
                Toast.makeText(this,"${password.text.toString()}${confirmPassword.text.toString()}",Toast.LENGTH_SHORT).show()

            }

        }
    }
}