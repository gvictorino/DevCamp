package com.devcamp.data

import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("id")
    var movieID: Int?,
    @SerializedName("title")
    var movieTitle: String?,
    @SerializedName("date")
    var date : String?,
    @SerializedName("card_image")
    var cardImage : String?,
    @SerializedName("thumb_image")
    var thumbImage : String?,
    @SerializedName("synopsis")
    var movieDescription : String?,
    @SerializedName("duration")
    var duration : String?,
    @SerializedName("yt_video_id")
    var youtubeID : String?,
    @SerializedName("categories")
    var categories : List<String>?
)