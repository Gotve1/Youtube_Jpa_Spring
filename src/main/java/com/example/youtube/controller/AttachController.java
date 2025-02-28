package com.example.youtube.controller;

import com.example.youtube.model.Attach;
import com.example.youtube.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attaches")
public class AttachController {

    @Autowired
    private AttachService attachService;


    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @GetMapping
    public List<Attach> getAllAttaches() {
        return attachService.getAllAttaches();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    public HttpEntity<?> getAttachById(@PathVariable UUID id) {
        return ResponseEntity.ok(attachService.getAttachById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PostMapping
    public Attach createAttach(@RequestBody Attach attach) {
        return attachService.createAttach(attach);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PutMapping("/{id}")
    public HttpEntity<Attach> updateAttach(@PathVariable UUID id, @RequestBody Attach attachDetails) {
        return ResponseEntity.ok(attachService.updateAttach(id, attachDetails));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteAttach(@PathVariable UUID id) {
        attachService.deleteAttach(id);
        return ResponseEntity.noContent().build();
    }
}