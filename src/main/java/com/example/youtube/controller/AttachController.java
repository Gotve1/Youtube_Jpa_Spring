package com.example.youtube.controller;

import com.example.youtube.model.Attach;
import com.example.youtube.service.AttachService;
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
@RequestMapping("/attaches")
@Tag(name = "attaches", description = "the Attach API")
public class AttachController {

    @Autowired
    private AttachService attachService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<Attach> getAllAttaches() {
        return attachService.getAllAttaches();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get attach by ID", description = "Get attach by ID")
    public HttpEntity<?> getAttachById(@PathVariable UUID id) {
        return ResponseEntity.ok(attachService.getAttachById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Create attach", description = "Create attach")
    public Attach createAttach(@RequestBody Attach attach) {
        return attachService.createAttach(attach);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Update attach", description = "Update attach")
    public HttpEntity<Attach> updateAttach(@PathVariable UUID id, @RequestBody Attach attachDetails) {
        return ResponseEntity.ok(attachService.updateAttach(id, attachDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete attach", description = "Delete attach")
    public HttpEntity<Void> deleteAttach(@PathVariable UUID id) {
        attachService.deleteAttach(id);
        return ResponseEntity.noContent().build();
    }
}