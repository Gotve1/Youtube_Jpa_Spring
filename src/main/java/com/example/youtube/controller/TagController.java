package com.example.youtube.controller;

import com.example.youtube.model.Playlist;
import com.example.youtube.model.Tag;
import com.example.youtube.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("{/id}")
    public HttpEntity<?> getTag(@PathVariable UUID id) {
        return ResponseEntity.ok(tagService.getTagById(id));
    }

    @PostMapping
    public Tag addTag(@RequestBody Tag tag) {
        return tagService.addTag(tag);
    }

    @PutMapping("/{id}")
    public HttpEntity<Tag> updateTag(@PathVariable UUID id, @RequestBody Tag tagDetails) {
        return ResponseEntity.ok(tagService.updateTag(id, tagDetails));
    }

    @DeleteMapping("{/id}")
    public HttpEntity<Playlist> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
