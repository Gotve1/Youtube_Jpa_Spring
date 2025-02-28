package com.example.youtube.controller;

import com.example.youtube.model.Channel;
import com.example.youtube.service.ChannelService;
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
@RequestMapping("/channels")
@Tag(name = "Channels", description = "the Channel API")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    @Operation(summary = "Get all profiles", description = "Get all profiles")
    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @GetMapping("/{id}")
    public HttpEntity<Channel> getChannelById(@PathVariable UUID id) {
        return ResponseEntity.ok(channelService.getChannelById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @PutMapping("/{id}")
    public HttpEntity<Channel> updateChannel(@PathVariable UUID id, @RequestBody Channel channelDetails) {
        return ResponseEntity.ok(channelService.updateChannel(id, channelDetails));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deleteChannel(@PathVariable UUID id) {
        channelService.deleteChannel(id);
        return ResponseEntity.noContent().build();
    }
}