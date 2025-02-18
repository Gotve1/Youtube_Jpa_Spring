package com.example.youtube.service;

import com.example.youtube.model.EmailHistory;
import com.example.youtube.repository.EmailHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmailHistoryService {

    @Autowired
    private EmailHistoryRepository emailHistoryRepository;

    public List<EmailHistory> getAllEmailHistories() {
        return emailHistoryRepository.findAll();
    }

    public EmailHistory getEmailHistoryById(UUID id) {
        return emailHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Email History not found"));
    }

    public EmailHistory createEmailHistory(EmailHistory emailHistory) {
        return emailHistoryRepository.save(emailHistory);
    }

    public void deleteEmailHistory(UUID id) {
        emailHistoryRepository.deleteById(id);
    }
}
