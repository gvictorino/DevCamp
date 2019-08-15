package com.devcamp.tv.ui.details

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.devcamp.tv.ImageLoader
import com.devcamp.tv.R
import com.devcamp.tv.builders.DetailsPresenterBuilder
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : Activity(), DetailsView{
    private lateinit var thumbBackground : ImageView
    private lateinit var title : TextView
    private lateinit var sinopse : TextView
    private lateinit var duration : TextView
    private lateinit var buttonWatchTrailer : Button
    private lateinit var presenter : DetailsPresenter

    companion object {
        val MOVIE_TITLE = "MovieTitle"
        val MOVIE_THUMB = "MovieThumb"
        val MOVIE_DURATION = "MovieDuration"
        val MOVIE_SINOPSE = "MovieSinopse"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        thumbBackground = movieDetailsBackground
        title = movieTitleTextView
        sinopse = movieDurationTextView
        duration = movieSinopseTextview
        buttonWatchTrailer = watchTrailerButton
        presenter = DetailsPresenterBuilder.create(this)

        presenter.onCreate()

        buttonWatchTrailer.setOnClickListener{
            Toast.makeText(this,"CLICOU",Toast.LENGTH_LONG).show()
        }
    }

    override fun addMovieDetails() {
        val extras = intent.extras
        val thumbImage = extras.getString(MOVIE_THUMB)
        val movieTitle = extras.getString(MOVIE_TITLE)
        val movieDuration = extras.getString(MOVIE_DURATION)
        val movieDescription = extras.getString(MOVIE_SINOPSE)

        ImageLoader.loadFitCenter(this,thumbImage, R.drawable.mosaic_pattern,thumbBackground)
        title.text = movieTitle
        duration.text = movieDuration
        sinopse.text = movieDescription
    }

}