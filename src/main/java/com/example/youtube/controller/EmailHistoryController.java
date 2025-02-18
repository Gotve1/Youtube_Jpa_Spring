package com.example.youtube.controller;

import com.example.youtube.model.EmailHistory;
import com.example.youtube.service.EmailHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/email-histories")
public class EmailHistoryController {

    @Autowired
    private EmailHistoryService emailHistoryService;

    @GetMapping
    public List<EmailHistory> getAllEmailHistories() {
        return emailHistoryService.getAllEmailHistories();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getEmailHistoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(emailHistoryService.getEmailHistoryById(id));
    }

    @PostMapping
    public EmailHistory createEmailHistory(@RequestBody EmailHistory emailHistory) {
        return emailHistoryService.createEmailHistory(emailHistory);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteEmailHistory(@PathVariable UUID id) {
        emailHistoryService.deleteEmailHistory(id);
        return ResponseEntity.noContent().build();
    }
}
