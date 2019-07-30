package com.devcamp

data class MovieViewModel(
    var movieID : Int = 0,
    var movieTitle : String = "",
    var movieDate: String = "",
    var cardImage : String = "",
    var thumbImage : String = "",
    var movieSinopse : String = "",
    var movieDuration : String = "",
    var youtubeID : Int = 0,
    var categories : List<String> = listOf())