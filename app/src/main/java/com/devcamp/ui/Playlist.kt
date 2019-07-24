package com.devcamp.ui

data class Playlist (var playlistID : Int = 0,
                     var playlistGloboID : String = "",
                     var playlistName : String = "",
                     var playlistItems : MutableList<Int> = mutableListOf())