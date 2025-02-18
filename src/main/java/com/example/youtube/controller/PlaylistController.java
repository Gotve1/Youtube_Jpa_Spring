package com.example.youtube.controller;

import com.example.youtube.model.Playlist;
import com.example.youtube.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<Playlist> getPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public HttpEntity<Playlist> getPlaylistById(@PathVariable UUID id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    public HttpEntity<Playlist> updatePlaylist(@PathVariable UUID id, @RequestBody Playlist playlistDetails) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlistDetails));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Playlist> deletePlaylist(@PathVariable UUID id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}
