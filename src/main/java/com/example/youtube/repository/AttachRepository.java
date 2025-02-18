package com.example.youtube.repository;

import com.example.youtube.model.Attach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachRepository extends JpaRepository<Attach, UUID> {
}
