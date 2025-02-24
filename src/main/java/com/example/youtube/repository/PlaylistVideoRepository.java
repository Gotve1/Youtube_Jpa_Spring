package com.example.youtube.repository;

import com.example.youtube.model.PlaylistVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaylistVideoRepository extends JpaRepository<PlaylistVideo, Integer> {
}
