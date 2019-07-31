package com.devcamp.builders

import com.devcamp.ui.home.HomePresenter
import com.devcamp.ui.home.HomeView

object HomePresenterBuilder{
    fun create(view : HomeView) : HomePresenter{
        return HomePresenter(view,TracksBuilder.create())
    }
}