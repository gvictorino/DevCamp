package com.devcamp.tv.builders

import com.devcamp.tv.ui.home.HomePresenter
import com.devcamp.tv.ui.home.HomeView

object HomePresenterBuilder{
    fun create(view : HomeView) : HomePresenter{
        return HomePresenter(view, TracksBuilder.create())
    }
}