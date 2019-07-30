package com.devcamp.ui.home.movies

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.devcamp.load
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(movies: MoviesViewModel) {
        val title = itemView.itemName
        val poster = itemView.itemCardImage

        title.text = movies.toString()
        poster.load(movies.cardImage, ContextCompat.getDrawable(itemView.context, R.drawable.placeholder_track_item))
    }
}
