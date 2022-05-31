package com.example.ovs40.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ovs.*
import com.example.ovs3.electDetail
import com.example.ovs3.mark
import com.example.ovs40.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VIewElectionFragments.newInstance] factory method to
 * create an instance of this fragment.
 */
class VIewElectionFragments : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_v_iew_election_fragments, container, false)


        mark = getElections(output)

        val exampleList = generateDummyList(mark as ArrayList<List<String>>)
        val adapter = Adapter(exampleList, this)
        var recycler_view = view?.findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view?.adapter = adapter
        recycler_view?.layoutManager = LinearLayoutManager(activity)
        recycler_view?.setHasFixedSize(true)

        // Inflate the layout for this fragment

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewElectionsFragment.
         */
        // TODO: Rename and change types and number of parameters

    }

    private fun generateDummyList(main: ArrayList<List<String>>): MutableList<ElectionAdapterDataClass> {
        val list = ArrayList<ElectionAdapterDataClass>()

        for (item in main) {
            list += ElectionAdapterDataClass(R.drawable.ic_baseline_ballot_24, item[0], item[1])
        } //daniel Emenahor
        return list
    }

    fun onItemClick(position: Int) {
        electDetail = selectElection(output, mark[position][0])[0].toList() as MutableList<String>

        val nextpage = Intent(activity, ElectionDetail::class.java)
        startActivity(nextpage)
    }
}