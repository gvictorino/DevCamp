package com.devcamp.builders

import com.devcamp.domain.TracksUseCase
import com.devcamp.data.TracksManager

object TracksBuilder{
    fun create() : TracksUseCase {
        return TracksUseCase(TracksManager())
    }
}