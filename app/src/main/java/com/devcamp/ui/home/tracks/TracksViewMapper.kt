package com.devcamp.ui.home.tracks

import com.devcamp.domain.Tracks
import com.devcamp.ui.home.movies.MoviesViewMapper
import com.devcamp.ui.home.movies.MoviesViewModel

class TracksViewMapper{
    companion object {
        fun from(tracks: Tracks) = TracksViewModel(
            trackTitle = tracks.trackTitle,
            movies = tracks.movies.map {
                MoviesViewMapper.from(it)
            } as MutableList<MoviesViewModel>)
    }
}