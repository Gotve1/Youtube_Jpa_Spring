package com.example.youtube.controller;

import com.example.youtube.model.Playlist;
import com.example.youtube.service.PlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlists")
@Tag(name = "Playlists", description = "the Playlist API")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<Playlist> getPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get playlist by ID", description = "Get playlist by ID")
    public HttpEntity<Playlist> getPlaylistById(@PathVariable UUID id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Create playlist", description = "Create playlist")
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Update playlist", description = "Update playlist")
    public HttpEntity<Playlist> updatePlaylist(@PathVariable UUID id, @RequestBody Playlist playlistDetails) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlistDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete playlist", description = "Delete playlist")
    public HttpEntity<Void> deletePlaylist(@PathVariable UUID id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}