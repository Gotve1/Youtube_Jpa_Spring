package com.example.youtube.repository;

import com.example.youtube.model.VideoTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoTagRepository extends JpaRepository<VideoTag, UUID> {
}