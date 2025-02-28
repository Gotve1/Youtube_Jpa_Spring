package com.example.youtube.controller;

import com.example.youtube.model.Comment;
import com.example.youtube.service.CommentService;
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
@RequestMapping("/comments")
@Tag(name = "Comment", description = "the Commentaries API")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all profiles", description = "Get all profiles")
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @GetMapping("/{id}")
    public HttpEntity<?> getCommentById(@PathVariable UUID id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PutMapping("/{id}")
    public HttpEntity<Comment> updateComment(@PathVariable UUID id, @RequestBody Comment commentDetails) {
        return ResponseEntity.ok(commentService.updateComment(id, commentDetails));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
