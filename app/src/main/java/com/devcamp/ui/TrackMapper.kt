package com.devcamp.ui

import com.devcamp.TrackViewModel
import com.devcamp.domain.Tracks

class TrackMapper{
    companion object {
        fun from(tracks: Tracks) = TrackViewModel(
            trackTitle = tracks.trackTitle,
            movies = tracks.movies
        )
    }
}