package com.devcamp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R
import com.devcamp.builders.HomePresenterBuilder
import com.devcamp.ui.home.tracks.TracksAdapter
import com.devcamp.ui.home.tracks.TracksViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_recycler_home_tracks.*

class HomeFragment : Fragment(), HomeView{
    private  var presenter: HomePresenter? = null
    private  var listOfTracks : RecyclerView? = null
    private  var adapter: TracksAdapter? = null
    private  var progressBar : ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenterBuilder.create(this)
        listOfTracks = view.findViewById(R.id.home_tracks)
        listOfTracks?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listOfTracks?.setHasFixedSize(true)
        adapter = context?.let { TracksAdapter(it) }
        listOfTracks?.adapter = adapter

        progressBar = progressBarHome

        presenter?.onCreateView()

    }

    override fun addTracks(tracksList: MutableList<TracksViewModel>) {
        adapter?.update(tracksList)

    }

    override fun showError() {
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("Ops.. Algo deu errado")
        alertDialog.setMessage("Verifique sua conexão")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tentar novamente"
        ) { dialog, which -> presenter?.onClickTryAgain() }
        alertDialog.show()    }

    override fun showLoad() {
        tracksList?.visibility = View.INVISIBLE
        progressBar?.visibility = View.VISIBLE
    }

    override fun removeLoad() {
        tracksList?.visibility = View.VISIBLE
        progressBar?.visibility = View.GONE
    }

}