package com.example.youtube.controller;

import com.example.youtube.model.VideoTag;
import com.example.youtube.service.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/video-tags")
public class VideoTagController {

    @Autowired
    private VideoTagService videoTagService;

    @GetMapping
    public List<VideoTag> getAllVideoTags() {
        return videoTagService.getAllVideoTags();
    }

    @GetMapping("/{id}")
    public HttpEntity<VideoTag> getVideoTagById(@PathVariable UUID id) {
        return ResponseEntity.ok(videoTagService.getVideoTagById(id));
    }

    @PostMapping
    public VideoTag addVideoTag(@RequestBody VideoTag videoTag) {
        return videoTagService.addVideoTag(videoTag);
    }

    @PutMapping("/{id}")
    public HttpEntity<VideoTag> updateVideoTag(@PathVariable UUID id, @RequestBody VideoTag videoTagDetails) {
        return ResponseEntity.ok(videoTagService.updateVideoTag(id, videoTagDetails));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteVideoTag(@PathVariable UUID id) {
        videoTagService.deleteVideoTag(id);
        return ResponseEntity.noContent().build();
    }
}