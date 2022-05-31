package com.example.ovs40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ovs40.Fragments.VIewElectionFragments

class Adapter(
    private val exampleList: List<ElectionAdapterDataClass>,
    private val listener: VIewElectionFragments
) :
    RecyclerView.Adapter<Adapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemViewer =
            LayoutInflater.from(parent.context).inflate(R.layout.election_template, parent, false)
        return viewHolder(itemViewer)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.text1
        holder.textView2.text = currentItem.text2

    }

    override fun getItemCount() = exampleList.size
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView: TextView = itemView.findViewById(R.id.text)
        val textView2: TextView = itemView.findViewById(R.id.text2)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val positon = adapterPosition
            if (positon != RecyclerView.NO_POSITION) {
                listener.onItemClick(positon)
            }
        }

    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }

}

