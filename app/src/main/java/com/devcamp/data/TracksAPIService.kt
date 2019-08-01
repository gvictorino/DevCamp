package com.devcamp.data

import com.devcamp.data.TracksAPIResponse
import retrofit2.Call
import retrofit2.http.GET

interface TracksAPIService{
    @GET("home")
    fun getTracksList(): Call<TracksAPIResponse>
}
