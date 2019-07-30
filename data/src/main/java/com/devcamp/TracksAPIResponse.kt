package com.devcamp

import com.google.gson.annotations.SerializedName

class TracksAPIResponse {
    @SerializedName("tracks")
    var tracksList: List<TracksModel> = listOf()
}
