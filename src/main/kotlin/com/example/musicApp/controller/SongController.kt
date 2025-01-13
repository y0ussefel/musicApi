package com.example.musicApp.controller

import com.example.musicApp.dataclasss.Song
import com.example.musicApp.repository.SongRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
class SongController(private val songRepository: SongRepository){
    @GetMapping
    fun getSongs():List<Song>{
        return songRepository.findAll()
    }

    @PostMapping
    fun addSong(@RequestBody song: Song):Song{
        return songRepository.save(song)
    }

}

