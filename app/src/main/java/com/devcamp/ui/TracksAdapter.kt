package com.devcamp.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler_home_tracks.view.*
import kotlinx.android.synthetic.main.item_track.view.*

class TracksAdapter(private var playlists: MutableList<Playlist>, private val context: Context) : RecyclerView.Adapter<TracksViewHolder>()  {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_home_tracks, parent, false)
        view.trackItemsList.setRecycledViewPool(viewPool)
        return TracksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.bindView(playlist, viewPool)
    }

    fun update(playlists: MutableList<Playlist>){
        this.playlists.clear()
        this.playlists.addAll(playlists)
        notifyDataSetChanged()
    }
}

class TracksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(tracks: Playlist, viewPool: RecyclerView.RecycledViewPool) {
        val title = itemView.categoryName
        title.text = tracks.playlistName

        val tracksItemlayoutManager = LinearLayoutManager(itemView.context, LinearLayout.HORIZONTAL, false)
        tracksItemlayoutManager.initialPrefetchItemCount = 4

        itemView.trackItemsList.apply {
            layoutManager = tracksItemlayoutManager
            adapter = TrackItemsAdapter(mutableListOf(), itemView.context)
            setRecycledViewPool(viewPool)
        }
    }
}

class TrackItemsAdapter(private var videos: MutableList<Int>,
                      private val context: Context) : RecyclerView.Adapter<TrackItemsListViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackItemsListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_track, parent, false)
        return TrackItemsListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: TrackItemsListViewHolder, position: Int) {
        val video = videos[position]
        holder.bindView(video)
    }

    fun update(videos: MutableList<Int>){
        this.videos.clear()
        this.videos.addAll(videos)
        notifyDataSetChanged()
    }
}

class TrackItemsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(video: Int) {
        val title = itemView.categoryName
        val poster = itemView.itemCardImage

        title.text = video.toString()
        poster.load("", ContextCompat.getDrawable(itemView.context, R.drawable.placeholder_track_item))
    }
}

fun ImageView.load(url: String?, placeholder: Drawable?) =
    placeholder?.apply {
        Picasso.with(context)
            .load(if (url?.isNotEmpty() == true) url else null)
            .placeholder(placeholder)
            .error(placeholder)
            .into(this@load)
    }

