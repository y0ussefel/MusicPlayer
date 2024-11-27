package com.example.musicplayer_project.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer_project.R
import com.example.musicplayer_project.adapters.SongAdapter
import com.example.musicplayer_project.data.Album
import com.example.musicplayer_project.data.Artist
import com.example.musicplayer_project.data.Genre
import com.example.musicplayer_project.data.Song

class SongActivity : AppCompatActivity() {
    private lateinit var  recycler:RecyclerView
   private lateinit var songAdapter : SongAdapter
   var listSongs = mutableListOf<Song>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.songs_list)
        dataSongs()
        recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)

         songAdapter = SongAdapter(listSongs)
        recycler.adapter = songAdapter
    }



    private fun dataSongs(){
        val artist1 = Artist(id = 1,  fullName = "weld lhawat","slamo", album = null,)
        val album1 = Album(id = 1, title = "had lila hlat","14-05-2005", cover = null,artist1)
        val genreRock = Genre(id = 1, name = "Rock",listSongs)
        listSongs.apply {
            add(Song(img = null, id = 121, title = "All my days", duration = "2:05", artist = artist1, album = album1, genre = genreRock))
            add(Song(img = null, id = 122, title = "Another Day", duration = "3:15", artist = artist1, album = album1, genre = genreRock))
            add(Song(img = null, id = 123, title = "Rock Anthem", duration = "4:20", artist = artist1, album = album1, genre = genreRock))
        }
    }
}

