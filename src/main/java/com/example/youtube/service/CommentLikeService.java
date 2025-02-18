package com.example.youtube.service;

import com.example.youtube.model.CommentLike;
import com.example.youtube.repository.CommentLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentLikeService {

    @Autowired
    private CommentLikeRepository commentLikeRepository;

    public List<CommentLike> getAllCommentLikes() {
        return commentLikeRepository.findAll();
    }

    public CommentLike getCommentLikeById(UUID id) {
        return commentLikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment Like not found"));
    }

    public CommentLike createCommentLike(CommentLike commentLike) {
        return commentLikeRepository.save(commentLike);
    }

    public void deleteCommentLike(UUID id) {
        commentLikeRepository.deleteById(id);
    }
}
