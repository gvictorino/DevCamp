package com.devcamp

interface TracksAPICallback {
    fun onResponse(response: TracksAPIResponse)
    fun onFailure(throwable: Throwable)
}
