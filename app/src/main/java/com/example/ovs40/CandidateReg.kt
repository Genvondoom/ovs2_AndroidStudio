package com.example.ovs40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.ovs.output
import com.example.ovs.send
import com.google.android.material.textfield.TextInputEditText

class CandidateReg : AppCompatActivity() {
    lateinit var candidateName: TextInputEditText
    lateinit var candidatePosition: TextInputEditText
    lateinit var candidateBio: TextInputEditText
    lateinit var candidateMission: TextInputEditText
    lateinit var candidateManefesto: TextInputEditText
    lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_reg)
        candidateName = findViewById(R.id.candidatename)
        candidatePosition = findViewById(R.id.position)
        candidateBio = findViewById(R.id.bio)
        candidateMission = findViewById(R.id.missionStatement)
        candidateManefesto = findViewById(R.id.manefesto)
        submitButton = findViewById(R.id.candidateReg)
        submitButton.setOnClickListener {
            val response = send(
                output,
                "join election candidate,${candidatePosition.text},${candidateManefesto.text},${candidateBio.text},${candidateMission.text}"
            )
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
        }
    }
}