package com.example.youtube.controller;

import com.example.youtube.model.PlaylistVideo;
import com.example.youtube.service.VideoPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlist-videos")
public class PlaylistVideoController {

    @Autowired
    private VideoPlaylistService videoPlaylistService;

    @GetMapping
    public List<PlaylistVideo> getAllPlaylistVideos() {
        return videoPlaylistService.getAllPlaylistVideos();
    }

    @GetMapping("/{id}")
    public HttpEntity<PlaylistVideo> getPlaylistVideoById(@PathVariable Integer id) {
        return ResponseEntity.ok(VideoPlaylistService.getPlaylistVideoById(id));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deletePlaylistVideo(@PathVariable Integer id){
        videoPlaylistService.deletePlaylistVideo(id);
        return ResponseEntity.noContent().build();
    }

}
