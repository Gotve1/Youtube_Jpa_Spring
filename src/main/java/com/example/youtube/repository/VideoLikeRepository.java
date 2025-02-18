package com.example.youtube.repository;

import com.example.youtube.model.VideoLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoLikeRepository extends JpaRepository<VideoLike, UUID> {
}
