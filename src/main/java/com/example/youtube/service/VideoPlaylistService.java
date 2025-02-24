package com.example.youtube.service;

import com.example.youtube.model.PlaylistVideo;
import com.example.youtube.repository.PlaylistVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoPlaylistService {

    @Autowired
    private static PlaylistVideoRepository pvr;

    public List<PlaylistVideo> getAllPlaylistVideos() {
        return pvr.findAll();
    }

    public static PlaylistVideo getPlaylistVideoById(Integer id) {
        return pvr.findById(id).orElseThrow(() -> new RuntimeException("PlaylistVideo not found"));
    }

    public PlaylistVideo createPlaylistVideo(Integer id, PlaylistVideo playlistVideoDetails) {
        return pvr.save(playlistVideoDetails);
    }

    public PlaylistVideo updatePlaylistVideo(Integer id, PlaylistVideo playlistVideoDetails){
        PlaylistVideo playlistVideo = getPlaylistVideoById(id);
        playlistVideo.setId(playlistVideoDetails.getId());
        playlistVideo.setPlaylistId(playlistVideoDetails.getPlaylistId());
        playlistVideo.setVideoId(playlistVideoDetails.getVideoId());
        playlistVideo.setOrderNum(playlistVideoDetails.getOrderNum());
        return  pvr.save(playlistVideo);
    }

    public void deletePlaylistVideo(Integer id) {
        pvr.deleteById(id);
    }

}
