package com.example.musicplayer_project.data

data class Artist(
    val id :Int,
    val fullName:String,
    val bio : String,
    val album: Album?,
    val songs:MutableList<Song> = mutableListOf()

) {
}