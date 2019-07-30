package com.devcamp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TracksAPIClient {
    private val apiService: TracksAPIService

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        this.apiService = retrofit.create<TracksAPIService>(TracksAPIService::class.java)
    }

    fun getTracksList(callback: TracksAPICallback) {
        apiService.getTracksList().enqueue(object : Callback<TracksAPIResponse> {
            override fun onResponse(call: Call<TracksAPIResponse>, response: Response<TracksAPIResponse>) {
                if (response.isSuccessful && response.body() != null)
                    callback.onResponse(response.body() as TracksAPIResponse)
                else
                    callback.onFailure(Throwable("Não completou requisição ou body nulo"))
            }
            override fun onFailure(call: Call<TracksAPIResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    companion object {
        private val BASE_URL = "https://private-aa6a00-devcamp2019.apiary-mock.com/"
    }
}