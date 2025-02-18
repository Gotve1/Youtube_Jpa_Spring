package com.example.youtube.controller;

import com.example.youtube.model.VideoLike;
import com.example.youtube.service.VideoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/video-likes")
public class VideoLikeController {

    @Autowired
    private VideoLikeService videoLikeService;

    @GetMapping
    public List<VideoLike> getAllVideoLikes() {
        return videoLikeService.getAllVideoLikes();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getVideoLikeById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoLikeService.getVideoLikeById(id));
    }

    @PostMapping
    public VideoLike createVideoLike(@RequestBody VideoLike videoLike) {
        return videoLikeService.createVideoLike(videoLike);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteVideoLike(@PathVariable UUID id) {
        videoLikeService.deleteVideoLike(id);
        return ResponseEntity.noContent().build();
    }
}
