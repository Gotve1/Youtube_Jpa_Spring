package com.example.youtube.controller;

import com.example.youtube.model.VideoWatched;
import com.example.youtube.service.VideoWatchedService;
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
@RequestMapping("/video-watched")
@Tag(name = "Video Watched", description = "The Video Watched API")
public class VideoWatchedController {

    @Autowired
    private VideoWatchedService videoWatchedService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Get all video watched", description = "Get all video watched")
    public List<VideoWatched> getAllVideoWatched() {
        return videoWatchedService.getAllVideoWatched();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<?> getVideoWatchedById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoWatchedService.getVideoWatchedById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public VideoWatched createVideoWatched(@RequestBody VideoWatched videoWatched) {
        return videoWatchedService.createVideoWatched(videoWatched);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<Void> deleteVideoWatched(@PathVariable UUID id) {
        videoWatchedService.deleteVideoWatched(id);
        return ResponseEntity.noContent().build();
    }
}
