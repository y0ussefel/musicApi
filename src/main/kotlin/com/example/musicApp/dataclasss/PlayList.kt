package com.example.musicApp.dataclasss

data class PlayList(
    var id: String,
    val name: String,
    val description: String,
    val coverImage: Int,
    val songs: MutableList<Song>
)
