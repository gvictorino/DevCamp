package com.devcamp.ui.home

import com.devcamp.ui.home.tracks.TracksViewModel

interface HomeView {
fun addTracks(tracksList : MutableList<TracksViewModel>)
fun showError()
fun showLoad()
fun removeLoad()
}