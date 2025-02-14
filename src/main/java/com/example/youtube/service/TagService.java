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

    public Tag getTagById(UUID id) throws Throwable {
        return (Tag) tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Tag Not Found"));
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(UUID id, Tag tagdetails) throws Throwable {
        Tag tag = getTagById(id);
        tag.setName(tagdetails.getName());
        tag.setId(tag.getId());
        tag.setCreatedDate(tagdetails.getCreatedDate());
        return tagRepository.save(tag);
    }

    public void deleteTag(UUID id) throws Throwable {
        tagRepository.deleteById(id);
    }
}
