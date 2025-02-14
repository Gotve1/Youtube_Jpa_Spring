package com.example.youtube.service;

import com.example.youtube.model.Profile;
import com.example.youtube.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(UUID id) {
        return profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(UUID id, Profile profileDetails) {
        Profile profile = getProfileById(id);
        profile.setName(profileDetails.getName());
        profile.setSurname(profileDetails.getSurname());
        profile.setEmail(profileDetails.getEmail());
        profile.setPassword(profileDetails.getPassword());
        profile.setPhoto(profileDetails.getPhoto());
        profile.setRole(profileDetails.getRole());
        profile.setStatus(profileDetails.getStatus());
        return profileRepository.save(profile);
    }

    public void deleteProfile(UUID id) {
        profileRepository.deleteById(id);
    }
}