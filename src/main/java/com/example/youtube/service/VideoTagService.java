package com.example.youtube.service;

import com.example.youtube.model.VideoTag;
import com.example.youtube.repository.VideoTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoTagService {

    @Autowired
    private VideoTagRepository videoTagRepository;

    public List<VideoTag> getAllVideoTags() {
        return videoTagRepository.findAll();
    }

    public VideoTag getVideoTagById(UUID id) {
        return videoTagRepository.findById(id).orElseThrow(() -> new RuntimeException("VideoTag not found"));
    }

    public VideoTag addVideoTag(VideoTag videoTag) {
        return videoTagRepository.save(videoTag);
    }

    public VideoTag updateVideoTag(UUID id, VideoTag videoTagDetails) {
        VideoTag videoTag = getVideoTagById(id);
        videoTag.setVideoId(videoTagDetails.getVideoId());
        videoTag.setTagId(videoTagDetails.getTagId());
        videoTag.setCreatedDate(videoTagDetails.getCreatedDate());
        return videoTagRepository.save(videoTag);
    }

    public void deleteVideoTag(UUID id) {
        videoTagRepository.deleteById(id);
    }
}