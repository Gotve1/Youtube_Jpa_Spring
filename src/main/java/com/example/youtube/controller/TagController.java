package com.example.youtube.controller;

import com.example.youtube.model.Playlist;
import com.example.youtube.model.Tag;
import com.example.youtube.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Tags")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tags", description = "the Tag API")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all tags", description = "Get all tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<?> getTag(@PathVariable UUID id) {
        return ResponseEntity.ok(tagService.getTagById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public Tag addTag(@RequestBody Tag tag) {
        return tagService.addTag(tag);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public HttpEntity<Tag> updateTag(@PathVariable UUID id, @RequestBody Tag tagDetails) {
        return ResponseEntity.ok(tagService.updateTag(id, tagDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public HttpEntity<Playlist> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
