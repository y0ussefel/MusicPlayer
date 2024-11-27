package com.example.musicplayer_project.data

data class PlayList(
    val id : Int,
    val title : String,
    val songs:MutableList<Song> = mutableListOf()
) {
}