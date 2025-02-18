package com.example.youtube.controller;

import com.example.youtube.model.Profile;
import com.example.youtube.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public HttpEntity<Profile> getProfileById(@PathVariable UUID id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @PutMapping("/{id}")
    public HttpEntity<Profile> updateProfile(@PathVariable UUID id, @RequestBody Profile profileDetails) {
        return ResponseEntity.ok(profileService.updateProfile(id, profileDetails));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteProfile(@PathVariable UUID id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}