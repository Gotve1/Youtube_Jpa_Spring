package com.example.youtube.controller;

import com.example.youtube.model.Video;
import com.example.youtube.service.VideoService;
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
@RequestMapping("/videos")
@Tag(name = "videos", description = "the Video API")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all profiles", description = "Get all profiles")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @GetMapping("/{id}")
    public HttpEntity<Video> getVideoById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoService.getVideoById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PostMapping
    public HttpEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.createVideo(video));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PutMapping
    public HttpEntity<Video> updateVideo(@PathVariable UUID id ,@RequestBody Video videoDetails) {
        return ResponseEntity.ok(videoService.updateVideo(id, videoDetails));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteVideoById(@PathVariable UUID id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}
