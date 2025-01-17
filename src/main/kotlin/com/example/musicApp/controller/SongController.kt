package com.example.musicApp.controller

import com.example.musicApp.dataclasss.Song
import com.example.musicApp.repository.SongRepository
import com.example.musicApp.service.ServiceSong
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
class SongController(private val songService: ServiceSong) {

    @PostMapping
    fun addSong(@RequestBody product: Song): ResponseEntity<Song> {
        val saveSong = songService.ajouterSong(product)
        return ResponseEntity.ok(saveSong)
    }

    @GetMapping
    fun getAlSongs(): ResponseEntity<List<Song>> {
        val songs = songService.getAllSongs()
        return ResponseEntity.ok(songs)
    }

    @GetMapping("/{id}")
    fun finSongById(@PathVariable id: Int): ResponseEntity<Song> {
        val song = songService.findSongById(id)
        return ResponseEntity.ok(song)
    }

    @DeleteMapping("/{id}")
    fun deletSongById(@PathVariable id: Int): ResponseEntity<Void> {
        songService.deleteSongById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateSongById(@PathVariable id: Int, @RequestBody newSong: Song): ResponseEntity<Song> {
        val new = songService.updateSongById(id, newSong)
        return ResponseEntity.ok(new)
    }
}

