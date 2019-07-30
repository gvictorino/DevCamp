package com.devcamp.ui

import com.devcamp.MovieViewModel
import com.devcamp.domain.Movies

class MovieMapper{
    companion object {
        fun from(movies: Movies) = MovieViewModel(
            movieID = movies.movieID,
            movieTitle = movies.movieTitle,
            movieDuration = movies.movieDuration,
            movieSinopse = movies.movieSinopse,
            movieDate = movies.movieDate,
            cardImage = movies.cardImage,
            thumbImage = movies.thumbImage,
            youtubeID = movies.youtubeID,
            categories = movies.categories)
    }
}