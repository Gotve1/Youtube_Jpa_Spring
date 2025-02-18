package com.example.youtube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID previewAttachId;
    private String title;
    private UUID categoryId;
    private UUID attachId;
    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;
    private String status;
    private String type;
    private Long viewCount;
    private Long sharedCount;
    private String description;
    private UUID channelId;
    private Long likeCount;
    private Long dislikeCount;
}