package com.example.youtube.controller;

import com.example.youtube.model.VideoLike;
import com.example.youtube.service.VideoLikeService;
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
@RequestMapping("/video-likes")
@Tag(name = "video-likes", description = "the Video Like API")
public class VideoLikeController {

    @Autowired
    private VideoLikeService videoLikeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all video likes", description = "Get all video likes")
    public List<VideoLike> getAllVideoLikes() {
        return videoLikeService.getAllVideoLikes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<?> getVideoLikeById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoLikeService.getVideoLikeById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public VideoLike createVideoLike(@RequestBody VideoLike videoLike) {
        return videoLikeService.createVideoLike(videoLike);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public HttpEntity<Void> deleteVideoLike(@PathVariable UUID id) {
        videoLikeService.deleteVideoLike(id);
        return ResponseEntity.noContent().build();
    }
}
