package com.example.youtube.controller;

import com.example.youtube.model.CommentLike;
import com.example.youtube.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment-likes")
public class CommentLikeController {

    @Autowired
    private CommentLikeService commentLikeService;

    @GetMapping
    public List<CommentLike> getAllCommentLikes() {
        return commentLikeService.getAllCommentLikes();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCommentLikeById(@PathVariable UUID id) {
        return ResponseEntity.ok(commentLikeService.getCommentLikeById(id));
    }

    @PostMapping
    public CommentLike createCommentLike(@RequestBody CommentLike commentLike) {
        return commentLikeService.createCommentLike(commentLike);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteCommentLike(@PathVariable UUID id) {
        commentLikeService.deleteCommentLike(id);
        return ResponseEntity.noContent().build();
    }
}
