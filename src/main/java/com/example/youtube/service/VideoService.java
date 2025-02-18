package com.example.youtube.service;

import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public Video getVideoById(UUID id) {
        return videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video not found"));
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(UUID id, Video videoDetails){
        Video video = getVideoById(id);
        video.setType(videoDetails.getType());
        video.setId(video.getId());
        video.setCreatedDate(videoDetails.getCreatedDate());
        return videoRepository.save(video);
    }

    public void deleteVideo(UUID id) {
        videoRepository.deleteById(id);
    }
}
