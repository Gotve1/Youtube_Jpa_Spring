package com.example.youtube.controller;

import com.example.youtube.model.PlaylistVideo;
import com.example.youtube.service.VideoPlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlist-videos")
public class PlaylistVideoController {

    @Autowired
    private VideoPlaylistService videoPlaylistService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Get all playlist videos", description = "Get all playlist videos")
    public List<PlaylistVideo> getAllPlaylistVideos() {
        return videoPlaylistService.getAllPlaylistVideos();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Create playlist video", description = "Create playlist video")
    public PlaylistVideo createPlaylistVideo(@RequestBody PlaylistVideo playlistVideo) {
        return videoPlaylistService.createPlaylistVideo(playlistVideo);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get playlist video by ID", description = "Get playlist video by ID")
    public HttpEntity<PlaylistVideo> getPlaylistVideoById(@PathVariable Integer id) {
        return ResponseEntity.ok(VideoPlaylistService.getPlaylistVideoById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Update playlist video", description = "Update playlist video")
    public HttpEntity<PlaylistVideo> updatePlaylistVideo(@PathVariable Integer id, @RequestBody PlaylistVideo playlistVideoDetails) {
        return ResponseEntity.ok(videoPlaylistService.updatePlaylistVideo(id, playlistVideoDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete playlist video", description = "Delete playlist video")
    public HttpEntity<Void> deletePlaylistVideo(@PathVariable Integer id){
        videoPlaylistService.deletePlaylistVideo(id);
        return ResponseEntity.noContent().build();
    }

}
