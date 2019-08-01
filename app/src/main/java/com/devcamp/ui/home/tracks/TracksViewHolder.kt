package com.devcamp.ui.home.tracks

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.ui.home.movies.MoviesAdapter
import com.devcamp.ui.home.movies.MoviesViewMapper
import com.devcamp.ui.home.movies.MoviesViewModel
import kotlinx.android.synthetic.main.item_recycler_home_tracks.view.*

class TracksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(tracks: TracksViewModel, viewPool: RecyclerView.RecycledViewPool) {
        val title = itemView.categoryName
        title.text = tracks.trackTitle

        val playlistLayoutManager = LinearLayoutManager(itemView.context, LinearLayout.HORIZONTAL, false)
        playlistLayoutManager.initialPrefetchItemCount = 4

        itemView.tracksList.apply {
            layoutManager = playlistLayoutManager
            adapter = MoviesAdapter(tracks.movies)
            setRecycledViewPool(viewPool)
        }
    }
}