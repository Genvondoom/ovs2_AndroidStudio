package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.ovs.output
import com.example.ovs.send
import com.example.ovs.send2
import com.example.ovs3.candidates
import com.example.ovs3.choice
import com.example.ovs3.positions
import com.example.ovs3.positions2

class vote : AppCompatActivity() {
    lateinit var sel1: TextView
    lateinit var sel2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)
        sel1 = findViewById(R.id.candidate1)
        sel2 = findViewById(R.id.candidate)

        sel1.setOnClickListener {
            choice.add(sel1.text.toString())
            val next = Intent(this, vote2::class.java)
            startActivity(next)

        }

        sel2.setOnClickListener {
            choice.add(sel2.text.toString())
            val next = Intent(this, vote2::class.java)
            startActivity(next)

        }


    }
}