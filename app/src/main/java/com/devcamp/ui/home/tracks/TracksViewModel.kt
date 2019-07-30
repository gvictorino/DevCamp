package com.devcamp.ui.home.tracks

import com.devcamp.domain.Movies
import com.devcamp.ui.home.movies.MoviesViewModel

data class TracksViewModel(var trackTitle : String = "", var movies : MutableList<MoviesViewModel>)