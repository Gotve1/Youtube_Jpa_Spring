package com.example.youtube.service;

import com.example.youtube.model.Playlist;
import com.example.youtube.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(UUID id) {
        return playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(UUID id, Playlist playlistDetails) {
        Playlist playlist = getPlaylistById(id);
        playlist.setName(playlistDetails.getName());
        playlist.setDescription(playlistDetails.getDescription());
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(UUID id) {
        playlistRepository.deleteById(id);
    }
}
