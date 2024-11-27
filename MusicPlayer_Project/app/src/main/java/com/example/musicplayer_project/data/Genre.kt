package com.example.musicplayer_project.data

data class Genre(
    val id : Int,
    val name : String,
    val songs:MutableList<Song>

) {
}