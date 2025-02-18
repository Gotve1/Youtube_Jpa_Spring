package com.example.youtube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "video_like")
public class VideoLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Enumerated(EnumType.STRING)
    private LikeType type;

    public enum LikeType {
        LIKE,
        DISLIKE
    }
}
