package com.example.youtube.service;

import com.example.youtube.model.VideoWatched;
import com.example.youtube.repository.VideoWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoWatchedService {

    @Autowired
    private VideoWatchedRepository videoWatchedRepository;

    public List<VideoWatched> getAllVideoWatched() {
        return videoWatchedRepository.findAll();
    }

    public VideoWatched getVideoWatchedById(UUID id) {
        return videoWatchedRepository.findById(id).orElseThrow(() -> new RuntimeException("Video Watched entry not found"));
    }

    public VideoWatched createVideoWatched(VideoWatched videoWatched) {
        return videoWatchedRepository.save(videoWatched);
    }

    public void deleteVideoWatched(UUID id) {
        videoWatchedRepository.deleteById(id);
    }
}
