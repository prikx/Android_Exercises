package com.example.gliderapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AppAdapter(private val context : Context) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView
        init {
            imageView = view.findViewById(R.id.imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imageview_layout, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = String.format("https://picsum.photos/500/500?image=%d", position)
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return 50
    }
}