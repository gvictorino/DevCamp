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

class HomeFragment : Fragment(), HomeView{
    private  var presenter: HomePresenter? = null
    private  var listOfTracks : RecyclerView? = null
    private  var adapter: TracksAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        presenter = HomePresenterBuilder.create(this)
        listOfTracks = view?.findViewById(R.id.home_tracks)
        listOfTracks?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listOfTracks?.setHasFixedSize(true)
        listOfTracks?.adapter = adapter

        presenter?.onCreateView()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun addTracks(tracksList: MutableList<TracksViewModel>) {
        adapter?.update(tracksList)

    }

    override fun showError() {
        val alertDialog = AlertDialog.Builder(activity).create()
        alertDialog.setTitle("Ops.. Algo deu errado")
        alertDialog.setMessage("Verifique sua conexão")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tentar novamente"
        ) { dialog, which -> presenter?.onClickTryAgain() }
        alertDialog.show()    }

    override fun showLoad() {
    }

    override fun removeLoad() {
    }

}