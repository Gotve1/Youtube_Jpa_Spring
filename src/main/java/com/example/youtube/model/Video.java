package com.example.youtube.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

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

    public Video() {
    }

    public Video(UUID id, UUID previewAttachId, String title, UUID categoryId, UUID attachId, LocalDateTime createdDate, LocalDateTime publishedDate, String status, String type, Long viewCount, Long sharedCount, String description, UUID channelId, Long likeCount, Long dislikeCount) {
        this.id = id;
        this.previewAttachId = previewAttachId;
        this.title = title;
        this.categoryId = categoryId;
        this.attachId = attachId;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.status = status;
        this.type = type;
        this.viewCount = viewCount;
        this.sharedCount = sharedCount;
        this.description = description;
        this.channelId = channelId;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPreviewAttachId() {
        return previewAttachId;
    }

    public void setPreviewAttachId(UUID previewAttachId) {
        this.previewAttachId = previewAttachId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getAttachId() {
        return attachId;
    }

    public void setAttachId(UUID attachId) {
        this.attachId = attachId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getSharedCount() {
        return sharedCount;
    }

    public void setSharedCount(Long sharedCount) {
        this.sharedCount = sharedCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public void setChannelId(UUID channelId) {
        this.channelId = channelId;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
}