package com.devcamp.data

interface TracksAPICallback {
    fun onResponse(response: TracksAPIResponse)
    fun onFailure(throwable: Throwable)
}
