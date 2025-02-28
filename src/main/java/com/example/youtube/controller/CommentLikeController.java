package com.example.youtube.controller;

import com.example.youtube.model.CommentLike;
import com.example.youtube.service.CommentLikeService;
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
@RequestMapping("/comment-likes")
@Tag(name = "CommentLikes", description = "the CommentLike API")
public class CommentLikeController {

    @Autowired
    private CommentLikeService commentLikeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<CommentLike> getAllCommentLikes() {
        return commentLikeService.getAllCommentLikes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get comment like by ID", description = "Get comment like by ID")
    public HttpEntity<?> getCommentLikeById(@PathVariable UUID id) {
        return ResponseEntity.ok(commentLikeService.getCommentLikeById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Create comment like", description = "Create comment like")
    public CommentLike createCommentLike(@RequestBody CommentLike commentLike) {
        return commentLikeService.createCommentLike(commentLike);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete comment like", description = "Delete comment like")
    public HttpEntity<Void> deleteCommentLike(@PathVariable UUID id) {
        commentLikeService.deleteCommentLike(id);
        return ResponseEntity.noContent().build();
    }
}