package com.devcamp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.devcamp.builders.HomePresenterBuilder
import com.devcamp.ui.home.tracks.TracksAdapter
import com.devcamp.ui.home.tracks.TracksViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeView{
    private lateinit var presenter: HomePresenter
    private lateinit var listOfTracks : RecyclerView
    private lateinit var adapter: TracksAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenterBuilder.create(this)
        listOfTracks = homeTracks
        listOfTracks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        listOfTracks.setHasFixedSize(true)
        listOfTracks.adapter = adapter

        presenter.onCreateView()
    }

    override fun addTracks(tracksList: MutableList<TracksViewModel>) {
        adapter.update(tracksList)
    }

    override fun showError() {
        val alertDialog = AlertDialog.Builder(activity).create()
        alertDialog.setTitle("Ops.. Algo deu errado")
        alertDialog.setMessage("Verifique sua conexão")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tentar novamente"
        ) { dialog, which -> presenter.onClickTryAgain() }
        alertDialog.show()    }

    override fun showLoad() {
    }

    override fun removeLoad() {
    }

}