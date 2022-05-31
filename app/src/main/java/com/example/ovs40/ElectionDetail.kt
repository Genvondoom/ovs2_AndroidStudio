package com.example.ovs40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.ovs.output
import com.example.ovs.send
import com.example.ovs.send2
import com.example.ovs3.electDetail
import com.example.ovs3.positions
import com.example.ovs3.positions2
import java.util.*

class ElectionDetail : AppCompatActivity() {
    lateinit var electionName: TextView
    lateinit var electionId: TextView
    lateinit var electionSchool: TextView
    lateinit var electionDate: TextView
    lateinit var startTime: TextView
    lateinit var stopTime: TextView
    lateinit var duration: TextView
    lateinit var status: TextView
    lateinit var voter: Button
    lateinit var regCandidate: Button
    lateinit var regVoter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election_detail)
        electionName = findViewById(R.id.electName)
        electionId = findViewById(R.id.electcode)
        electionSchool = findViewById(R.id.school)
        electionDate = findViewById(R.id.date)
        startTime = findViewById(R.id.startTime)
        stopTime= findViewById(R.id.stopTime)
        duration= findViewById(R.id.duration)
        status= findViewById(R.id.status)
        voter = findViewById(R.id.vote)
        regVoter = findViewById(R.id.regvoter)
        regCandidate = findViewById(R.id.regcandidate)

        electionName.text = electDetail[1].uppercase()
        electionId.text = "Election ID: ${electDetail[0]}"
        electionSchool.text = "School: ${electDetail[2].uppercase()}"
        electionDate.text = "Date: ${electDetail[3]}"
        startTime.text ="Start Time: ${electDetail[4].uppercase(Locale.getDefault())}"
        stopTime.text ="Stop Time:${electDetail[5].uppercase(Locale.getDefault())}"
        status.text ="Status: ${electDetail[6].uppercase(Locale.getDefault())}"

        voter.setOnClickListener {
            val next1 = Intent(this, vote::class.java)
            startActivity(next1)
        }
        regVoter.setOnClickListener {
            val response = send(output,"join election voter")
            Toast.makeText(this,response,Toast.LENGTH_SHORT).show()
        }
        regCandidate.setOnClickListener {
            val nextPage = Intent(this, CandidateReg::class.java)
            startActivity(nextPage)
        }
    }

}