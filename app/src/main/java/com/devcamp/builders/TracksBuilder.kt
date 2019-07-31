package com.devcamp.builders

import com.devcamp.domain.TracksUseCase
import com.devcamp.network.TracksManager

object TracksBuilder{
    fun create() : TracksUseCase {
        return TracksUseCase(TracksManager())
    }
}