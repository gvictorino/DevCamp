package com.devcamp

import com.devcamp.domain.Tracks

class TracksModelMapper{
    companion object {
        fun from(model: TracksModel) = Tracks(
            trackID = model.tracksID,
            trackTitle = model.trackTitle,
            movies = model.movies)
    }
}