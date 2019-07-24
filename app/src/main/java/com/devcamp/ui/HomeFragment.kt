package com.devcamp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcamp.R

class HomeFragment : Fragment(){
    companion object {
        const val TAG = "home"
    }

    private var tracksAdapter : TracksAdapter? = null
    private var homePresenter : HomePresenter? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val context = activity as Context
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        tracksAdapter = TracksAdapter(mutableListOf(), context)

        val tracks = view.findViewById<RecyclerView>(R.id.homeTracks)
        tracks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        tracks.adapter = tracksAdapter

        homePresenter = HomePresenter()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homePresenter?.onViewCreated()
    }

    fun show(playlists: MutableList<Playlist>) {
        tracksAdapter?.update(playlists)
    }


}

class HomePresenter{
    private var mockedVideoID : MutableList<Int> = mutableListOf(1212, 1212, 121212, 121212, 1212, 1212, 121212, 121212, 1212, 1212, 121212, 121212, 1212, 1212, 121212, 121212)

    private var tracks: MutableList<Playlist> = mutableListOf(
        Playlist(1,"", "Comédia", mockedVideoID),
        Playlist(2,"", "Terror", mockedVideoID),
        Playlist(3,"", "Romance", mockedVideoID),
        Playlist(4,"", "Suspense", mockedVideoID),
        Playlist(5,"", "Aventura", mockedVideoID),
        Playlist(6,"", "Policial", mockedVideoID))


    fun onViewCreated() {
        HomeFragment().show(tracks)
    }
}