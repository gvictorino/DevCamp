package com.devcamp.ui.home.tracks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.devcamp.ui.home.movies.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_recycler_home_tracks.view.*

class TracksAdapter() : RecyclerView.Adapter<TracksAdapter.ViewHolder>(){
    private val tracks : MutableList<TracksViewModel> = mutableListOf()

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_home_tracks,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = tracks[position]
        holder.textView.text = track.trackTitle
        holder.recyclerView.apply {
            setRecycledViewPool(viewPool)
            layoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            adapter = MoviesAdapter()
            (adapter as MoviesAdapter).update(track.movies)

        }
    }

    fun update(tracksList: MutableList<TracksViewModel>){
        this.tracks.clear()
        this.tracks.addAll(tracksList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.tracksList
        val textView: TextView = itemView.categoryName
    }
}