package com.example.musicplayer_project.data


data class Song(
    val img:Int?,
    val id : Int,
    val title : String,
    val duration : String,
    val artist : Artist,
    val album : Album?,
    val genre : Genre
) {
}