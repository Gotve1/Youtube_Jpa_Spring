package com.example.youtube.service;

import com.example.youtube.model.Attach;
import com.example.youtube.repository.AttachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttachService {

    @Autowired
    private AttachRepository attachRepository;

    public List<Attach> getAllAttaches() {
        return attachRepository.findAll();
    }

    public Attach getAttachById(UUID id) {
        return attachRepository.findById(id).orElseThrow(() -> new RuntimeException("Attach not found"));
    }

    public Attach createAttach(Attach attach) {
        return attachRepository.save(attach);
    }

    public Attach updateAttach(UUID id, Attach attachDetails) {
        Attach attach = getAttachById(id);
        attach.setOriginName(attachDetails.getOriginName());
        attach.setSize(attachDetails.getSize());
        attach.setType(attachDetails.getType());
        attach.setPath(attachDetails.getPath());
        attach.setDuration(attachDetails.getDuration());
        return attachRepository.save(attach);
    }

    public void deleteAttach(UUID id) {
        attachRepository.deleteById(id);
    }
}
