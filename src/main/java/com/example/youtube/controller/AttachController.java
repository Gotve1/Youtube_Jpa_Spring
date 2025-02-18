package com.example.youtube.controller;

import com.example.youtube.model.Attach;
import com.example.youtube.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attaches")
public class AttachController {

    @Autowired
    private AttachService attachService;

    @GetMapping
    public List<Attach> getAllAttaches() {
        return attachService.getAllAttaches();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAttachById(@PathVariable UUID id) {
        return ResponseEntity.ok(attachService.getAttachById(id));
    }

    @PostMapping
    public Attach createAttach(@RequestBody Attach attach) {
        return attachService.createAttach(attach);
    }

    @PutMapping("/{id}")
    public HttpEntity<Attach> updateAttach(@PathVariable UUID id, @RequestBody Attach attachDetails) {
        return ResponseEntity.ok(attachService.updateAttach(id, attachDetails));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteAttach(@PathVariable UUID id) {
        attachService.deleteAttach(id);
        return ResponseEntity.noContent().build();
    }
}


/*
{ "profile":
    { "id": "123e4567-Eyaw-1234-pkwa-426614174000"
},
        "email": "test@email.com",
        "name": "bobr",
        "password": "testpassword123",
        "photo": "photo1.jpg",
        "role": "test role",
        "description": "ja perdole",
        "status": "OK",
        "surname": "kurwa",
        "banner": "image.jpg"
}
*/