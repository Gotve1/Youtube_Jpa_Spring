package com.example.youtube.controller;

import com.example.youtube.model.VideoWatched;
import com.example.youtube.service.VideoWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/video-watched")
public class VideoWatchedController {

    @Autowired
    private VideoWatchedService videoWatchedService;

    @GetMapping
    public List<VideoWatched> getAllVideoWatched() {
        return videoWatchedService.getAllVideoWatched();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getVideoWatchedById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoWatchedService.getVideoWatchedById(id));
    }

    @PostMapping
    public VideoWatched createVideoWatched(@RequestBody VideoWatched videoWatched) {
        return videoWatchedService.createVideoWatched(videoWatched);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteVideoWatched(@PathVariable UUID id) {
        videoWatchedService.deleteVideoWatched(id);
        return ResponseEntity.noContent().build();
    }
}
