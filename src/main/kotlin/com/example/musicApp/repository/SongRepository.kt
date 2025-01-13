package com.example.musicApp.repository

import com.example.musicApp.dataclasss.Song
import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<Song, Long>
