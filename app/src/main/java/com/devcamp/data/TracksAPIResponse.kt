package com.devcamp.data

import com.google.gson.annotations.SerializedName

class TracksAPIResponse {
    @SerializedName("tracks")
    var trackList: List<TrackModel> = listOf()
}
