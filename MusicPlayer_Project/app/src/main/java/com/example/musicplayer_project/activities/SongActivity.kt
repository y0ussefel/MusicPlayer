package com.example.musicplayer_project.activities

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
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
        val bar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(bar)



        dataSongs()
        recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)

         songAdapter = SongAdapter(listSongs)
        recycler.adapter = songAdapter


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val action = menu?.findItem(R.id.actionBar)
        val view = action?.actionView as SearchView

        view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    performSearch(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                performSearch(newText ?: "")
                return true
            }
        })
        return true
    }

    private fun performSearch(query:String){
        val s = if (query.isBlank()) {
            listSongs // Show all songs when query is empty
        } else {
            listSongs.filter { "${it.title} ${it.artist}".contains(query, ignoreCase = true) }
        }
        songAdapter = SongAdapter(s)
        recycler.adapter = songAdapter
    }

    private fun dataSongs(){
        val artist1 = Artist(id = 1,  fullName = "weld lhawat","slamo", album = null,)
        val artist2 = Artist(id = 1,  fullName = "Kamal","slamo", album = null,)
        val album1 = Album(id = 1, title = "had lila hlat","14-05-2005", cover = null,artist1)
        val genreRock = Genre(id = 1, name = "Rock",listSongs)
        listSongs.apply {
            add(Song(img = null, id = 121, title = "All my days", duration = "2:05", artist = artist1, album = album1, genre = genreRock))
            add(Song(img = null, id = 122, title = "Another Day", duration = "3:15", artist = artist1, album = album1, genre = genreRock))
            add(Song(img = null, id = 123, title = "Rock Anthem", duration = "4:20", artist = artist1, album = album1, genre = genreRock))
            add(Song(img = null, id = 123, title = "jomanji", duration = "4:20", artist = artist2, album = album1, genre = genreRock))
        }
    }
}

