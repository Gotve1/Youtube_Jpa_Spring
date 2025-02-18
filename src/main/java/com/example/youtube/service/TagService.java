package com.example.youtube.service;

import com.example.youtube.model.Tag;
import com.example.youtube.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(UUID id) {
        return tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(UUID id, Tag tagDetails) {
        Tag tag = getTagById(id);
        tag.setName(tagDetails.getName());
        tag.setId(tag.getId());
        tag.setCreatedDate(tagDetails.getCreatedDate());
        return tagRepository.save(tag);
    }

    public void deleteTag(UUID id) {
        tagRepository.deleteById(id);
    }
}
