package com.example.youtube.controller;

import com.example.youtube.model.VideoTag;
import com.example.youtube.service.VideoTagService;
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
@RequestMapping("/video-tags")
@Tag(name = "video-tags", description = "the Video Tag API")
public class VideoTagController {

    @Autowired
    private VideoTagService videoTagService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all video tags", description = "Get all video tags")
    public List<VideoTag> getAllVideoTags() {
        return videoTagService.getAllVideoTags();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<VideoTag> getVideoTagById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoTagService.getVideoTagById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public VideoTag addVideoTag(@RequestBody VideoTag videoTag) {
        return videoTagService.addVideoTag(videoTag);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public HttpEntity<VideoTag> updateVideoTag(@PathVariable UUID id, @RequestBody VideoTag videoTagDetails) {
        return ResponseEntity.ok(videoTagService.updateVideoTag(id, videoTagDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public HttpEntity<Void> deleteVideoTag(@PathVariable UUID id) {
        videoTagService.deleteVideoTag(id);
        return ResponseEntity.noContent().build();
    }
}