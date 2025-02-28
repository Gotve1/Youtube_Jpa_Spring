package com.example.youtube.controller;

import com.example.youtube.model.EmailHistory;
import com.example.youtube.service.EmailHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/email-histories")
@Tag(name = "EmailHistories", description = "the EmailHistory API")
public class EmailHistoryController {

    @Autowired
    private EmailHistoryService emailHistoryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<EmailHistory> getAllEmailHistories() {
        return emailHistoryService.getAllEmailHistories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get email history by ID", description = "Get email history by ID")
    public HttpEntity<?> getEmailHistoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(emailHistoryService.getEmailHistoryById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Create email history", description = "Create email history")
    public EmailHistory createEmailHistory(@RequestBody EmailHistory emailHistory) {
        return emailHistoryService.createEmailHistory(emailHistory);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete email history", description = "Delete email history")
    public HttpEntity<Void> deleteEmailHistory(@PathVariable UUID id) {
        emailHistoryService.deleteEmailHistory(id);
        return ResponseEntity.noContent().build();
    }
}