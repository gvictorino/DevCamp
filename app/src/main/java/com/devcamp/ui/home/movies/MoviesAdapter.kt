package com.devcamp.ui.home.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R

class MoviesAdapter(private var movies: MutableList<MoviesViewModel>,
                    private val context: Context) : RecyclerView.Adapter<MoviesViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindView(movie)
    }

    fun update(movies: MutableList<MoviesViewModel>){
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}