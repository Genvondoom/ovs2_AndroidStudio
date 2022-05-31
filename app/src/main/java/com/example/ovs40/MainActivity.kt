package com.example.ovs40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ovs40.Fragments.CreateElectionFragment
import com.example.ovs40.Fragments.DashBoardFragment
import com.example.ovs40.Fragments.VIewElectionFragments
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottom_navigation: BottomNavigationView
    private val dashboardFragment = DashBoardFragment()
    private val viewElection = VIewElectionFragments()
    private val addElection = CreateElectionFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(dashboardFragment)
        bottom_navigation = findViewById(R.id.bottomMenu)
        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dashboardMenu -> {
                    replaceFragment(dashboardFragment)
                    Toast.makeText(this,"Dashboard", Toast.LENGTH_SHORT).show()}
                R.id.viewElectionMenu -> {replaceFragment(viewElection)
                    Toast.makeText(this,"view election", Toast.LENGTH_SHORT).show()}
                R.id.addElectionMenu ->{replaceFragment(addElection)}
            }

            true
        }
//name, sch_dept, startingDate, startingtime, duration
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}