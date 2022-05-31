package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.ovs.output
import com.example.ovs.send
import com.example.ovs3.choice

class vote2 : AppCompatActivity() {
    lateinit var sel1: TextView
    lateinit var sel2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote2)
        sel1 = findViewById(R.id.candidate3)
        sel2 = findViewById(R.id.candidate4)

        sel1.setOnClickListener {
            choice.add(sel2.text.toString())
            send(output,"vote,${choice.toString()}")

            val next = Intent(this, MainActivity::class.java)
            startActivity(next)

        }

        sel2.setOnClickListener {
            choice.add(sel2.text.toString())
            send(output,"vote,${choice.toString()}")

            val next = Intent(this, MainActivity::class.java)
            startActivity(next)

        }

    }
}