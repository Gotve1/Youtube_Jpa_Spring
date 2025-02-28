package com.example.youtube.controller;

import com.example.youtube.model.Profile;
import com.example.youtube.service.ProfileService;
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
@RequestMapping("/profiles")
@Tag(name = "profiles", description = "the Profile API")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all profiles", description = "Get all profiles")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @GetMapping("/{id}")
    public HttpEntity<Profile> getProfileById(@PathVariable UUID id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PutMapping("/{id}")
    public HttpEntity<Profile> updateProfile(@PathVariable UUID id, @RequestBody Profile profileDetails) {
        return ResponseEntity.ok(profileService.updateProfile(id, profileDetails));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteProfile(@PathVariable UUID id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}