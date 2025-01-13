package com.example.musicApp.dataclasss
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Song(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val artist: String, // Allows for collaborations
    val album: String?,
    val duration: Int, // In seconds
    val coverImage: Int, // URL or local resource
    val genre: String?,
    val releaseDate: String?, // Optional release date
    var isFavorite : Boolean= false
){
    constructor() : this(0, "", "", "", 0, 0, "", "", false)
}
