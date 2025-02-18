package com.example.youtube.service;

import com.example.youtube.model.VideoLike;
import com.example.youtube.repository.VideoLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoLikeService {

    @Autowired
    private VideoLikeRepository videoLikeRepository;

    public List<VideoLike> getAllVideoLikes() {
        return videoLikeRepository.findAll();
    }

    public VideoLike getVideoLikeById(UUID id) {
        return videoLikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Video Like not found"));
    }

    public VideoLike createVideoLike(VideoLike videoLike) {
        return videoLikeRepository.save(videoLike);
    }

    public void deleteVideoLike(UUID id) {
        videoLikeRepository.deleteById(id);
    }
}
