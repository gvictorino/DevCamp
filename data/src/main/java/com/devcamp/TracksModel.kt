package com.devcamp

import com.devcamp.domain.Movies
import com.google.gson.annotations.SerializedName


data class TracksModel(
    @SerializedName("id")
    var tracksID: Int,
    @SerializedName("title")
    var trackTitle: String,
    @SerializedName("movies")
    var movies: List<Movies>)