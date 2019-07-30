package com.devcamp

import retrofit2.Call
import retrofit2.http.GET

interface TracksAPIService{
    @GET("home")
    fun getTracksList(): Call<TracksAPIResponse>
}
