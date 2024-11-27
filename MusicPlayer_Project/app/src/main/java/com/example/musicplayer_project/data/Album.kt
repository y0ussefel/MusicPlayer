package com.example.musicplayer_project.data

data class Album(
    val id :Int,
    val title:String,
    val dataRelease : String?,
    val cover : Int?,
    val artist: Artist,
    val songs : MutableList<Song> = mutableListOf()

) {
}