package com.example.musicplayer_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer_project.R
import com.example.musicplayer_project.data.Song

class SongAdapter (private val songs:List<Song>): RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    class SongViewHolder(item:View):RecyclerView.ViewHolder(item){
        val title = item.findViewById<TextView>(R.id.songTitle)
        val artist = item.findViewById<TextView>(R.id.songArtist)
        val duration = item.findViewById<TextView>(R.id.SongDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_info,parent,false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.title.text = song.title
        holder.artist.text = song.artist.fullName
        holder.duration.text = song.duration
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "song select ${song.title}", Toast.LENGTH_SHORT).show()
        }
    }

}