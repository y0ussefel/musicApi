package com.example.musicApp.service

import com.example.musicApp.dataclasss.Song
import com.example.musicApp.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class ServiceSong(private val songoRepository: SongRepository) {

    fun ajouterSong(product: Song): Song {
        return songoRepository.save(product)
    }

    fun getAllSongs(): List<Song> {
        return songoRepository.findAll()
    }

    fun findSongById(id: Int): Song {
        return songoRepository.findById(id.toLong())
            .orElseThrow { RuntimeException("Song avec ID $id introuvable") }
    }

    fun deleteSongById(id: Int) {
        if (!songoRepository.existsById(id.toLong())) {
            throw RuntimeException("Song avec ID $id introuvable")
        }
        songoRepository.deleteById(id.toLong())
    }

    fun updateSongById(id: Int, updatedSong: Song): Song {
        val SongById = songoRepository.findById(id.toLong())
            .orElseThrow { RuntimeException("Song avec ID $id introuvable") }
        val ProduitModifier = SongById.copy(
            title = updatedSong.title,
            artist = updatedSong.artist,
            album = updatedSong.album,
            duration = updatedSong.duration,
            coverImage = updatedSong.coverImage,
            genre = updatedSong.genre,
            releaseDate = updatedSong.releaseDate,
            isFavorite = updatedSong.isFavorite
        )
        return songoRepository.save(ProduitModifier)
    }
}