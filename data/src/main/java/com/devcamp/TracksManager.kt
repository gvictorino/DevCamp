package com.devcamp

import com.devcamp.domain.Tracks
import com.devcamp.domain.TracksCallback
import com.devcamp.domain.TracksContract

class TracksManager(private val apiClient: TracksAPIClient) : TracksContract{
    private lateinit var tracksCallback: TracksCallback

    override fun getTracks(callback: TracksCallback) {
        this.tracksCallback = callback
        apiClient.getTracksList(object : TracksAPICallback {
            override fun onResponse(response: TracksAPIResponse) {
                val tracksList = mutableListOf<Tracks>()
                for(track in response.tracksList)
                    tracksList.add(TracksModelMapper.from(track))
                callback.onSuccess(tracksList)
            }

            override fun onFailure(throwable: Throwable) {
                callback.onFailure(throwable)
            }
        })

    }
    companion object {
        private val TAG = "TracksManager"
    }
}
