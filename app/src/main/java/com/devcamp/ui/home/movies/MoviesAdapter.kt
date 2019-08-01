package com.devcamp.ui.home.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.devcamp.data.MoviesModel
import com.devcamp.load
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val movies : MutableList<MoviesViewModel>)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.imageView.load(movie.cardImage, ContextCompat.getDrawable(holder.imageView.context, R.drawable.placeholder_track_item))
        holder.textView.text = movie.movieTitle
    }

    fun update(movies: MutableList<MoviesViewModel>){
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.itemName
        val imageView: ImageView = itemView.itemCardImage

    }
}