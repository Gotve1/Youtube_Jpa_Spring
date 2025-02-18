package com.example.youtube.controller;


import com.example.youtube.model.Tag;
import com.example.youtube.model.Video;
import com.example.youtube.service.TagService;
import com.example.youtube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("Videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public HttpEntity<Video> getVideoById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoService.getVideoById(id));
    }

    @PostMapping
    public HttpEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.createVideo(video));
    }

    @PutMapping
    public HttpEntity<Video> updateVideo(@PathVariable UUID id ,@RequestBody Video videoDetails) {
        return ResponseEntity.ok(videoService.updateVideo(id, videoDetails));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteVideoById(@PathVariable UUID id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}
