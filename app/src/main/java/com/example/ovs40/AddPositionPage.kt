package com.example.ovs40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.ovs3.positions
import com.google.android.material.textfield.TextInputEditText

class AddPositionPage : AppCompatActivity() {
    lateinit var preset: TextView
    lateinit var custom: TextView
    lateinit var btn: Button
    lateinit var arrayAdapter: ArrayAdapter<*>

    // access the listView from xml file
    lateinit var mListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_position_page)
        preset = findViewById(R.id.custom_positions)
        custom = findViewById(R.id.preset)
        btn = findViewById(R.id.addPosition)
        mListView = findViewById(R.id.userlist)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, positions
        )
        mListView.adapter = arrayAdapter

        custom.setOnClickListener {
            val mDialog2 = LayoutInflater.from(this).inflate(R.layout.positions, null)
            val alertDialog = AlertDialog.Builder(this)
            val checkbox1 = mDialog2.findViewById<CheckBox>(R.id.checkBox)
            val checkbox2 = mDialog2.findViewById<CheckBox>(R.id.checkBox2)
            val checkbox3 = mDialog2.findViewById<CheckBox>(R.id.checkBox3)
            val checkbox4 = mDialog2.findViewById<CheckBox>(R.id.checkBox4)
            val checkbox5 = mDialog2.findViewById<CheckBox>(R.id.checkBox5)
            alertDialog.apply {
                setView(mDialog2)
                setTitle("Add Custom position")
                setPositiveButton("Update") { _, _ ->
                    if (checkbox1.isChecked == true) {
                        positions.add("checkbox1.text.toString()")

                    }
                    if (checkbox2.isChecked == true) {
                        positions.add(checkbox1.text.toString())

                    }
                    if (checkbox3.isChecked == true) {
                        positions.add(checkbox1.text.toString())

                    }
                    if (checkbox4.isChecked == true) {
                        positions.add("checkbox1.text.toString()")

                    }
                    if (checkbox5.isChecked == true) {
                        positions.add(checkbox1.text.toString())


                    }

                    arrayAdapter.notifyDataSetChanged()

                }

            }

            alertDialog.show()

        }

        preset.setOnClickListener {
            val mDialog = LayoutInflater.from(this).inflate(R.layout.test, null)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.apply {
                setView(mDialog)
                setTitle("Add position")
                setPositiveButton("Update") { _, _ ->
                    val test = mDialog.findViewById<TextInputEditText>(R.id.position).text
                    if (test.toString().isNotBlank()) {
                        positions.add(test.toString())
                        arrayAdapter.notifyDataSetChanged()

                    }


                }

                alertDialog.show()
            }






            mListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, index, _ ->
                val updateDialog = LayoutInflater.from(this).inflate(R.layout.test, null)
                val alertDialog4 = AlertDialog.Builder(this)
                alertDialog4.apply {
                    setView(updateDialog)
                    setTitle("Add position")
                    setPositiveButton("Update") { _, _ ->
                        val test = updateDialog.findViewById<TextInputEditText>(R.id.position).text
                        if (test.toString().isNotBlank()) {
                            positions[index] = test.toString()
                            arrayAdapter.notifyDataSetChanged()

                        }


                    }

                    alertDialog4.show()
                }



                mListView.onItemLongClickListener =
                    AdapterView.OnItemLongClickListener { _, _, index, _ ->
                        Toast.makeText(
                            applicationContext,
                            "Long clicked on ${positions[index]}",
                            Toast.LENGTH_SHORT
                        ).show()


                        val alertDialog5 = AlertDialog.Builder(this)
                        alertDialog5.apply {
                            alertDialog5.apply {
                                //setIcon(R.drawable.ic_hello)
                                setTitle("Hello")
                                setMessage("Do you want to delete this position")
                                setPositiveButton("Yes") { _, _ ->
                                    positions.removeAt(index)
                                    arrayAdapter.notifyDataSetChanged()
                                }
                                setNegativeButton("No") { _, _ ->

                                }
                                setNeutralButton("Cancel") { _, _ ->

                                }
                            }.create().show()


                        }
                        true


                    }


            }

        }


    }
}
