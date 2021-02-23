package com.example.recyclerviewapp

import android.service.autofill.Dataset
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class AppAdapter(private val dataSet: ArrayList<String>) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.myTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_textview, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.textView.setOnClickListener(View.OnClickListener {
            deleteItem(viewHolder.adapterPosition, view)
        })
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun deleteItem(position: Int, view: View) {
        val snackMessage = String.format("Deleted: %s at position %s", position, dataSet.get(position))
        var number = dataSet.get(position)

        val snackbar = Snackbar.make(view, snackMessage, 1000)
        snackbar.setAction("UNDO", View.OnClickListener {
            dataSet.add(position, number)
            notifyDataSetChanged()
        })
        snackbar.show()
        dataSet.removeAt(position)
        notifyDataSetChanged()
    }
}