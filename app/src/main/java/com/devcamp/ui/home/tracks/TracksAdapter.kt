package com.devcamp.ui.home.tracks

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R

class TracksAdapter(private var tracks: MutableList<TracksViewModel>,
                    private val context: Context) : RecyclerView.Adapter<TracksViewHolder>()  {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_home_tracks, parent, false)
        return TracksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        val tracksList = tracks[position]
        holder.bindView(tracksList, viewPool)
    }

    fun update(tracksList: MutableList<TracksViewModel>){
        this.tracks.clear()
        this.tracks.addAll(tracksList)
        notifyDataSetChanged()
    }
}