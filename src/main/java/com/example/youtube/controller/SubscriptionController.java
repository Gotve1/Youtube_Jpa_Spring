package com.example.youtube.controller;

import com.example.youtube.model.Subscription;
import com.example.youtube.service.SubscriptionService;
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
@RequestMapping("/subscriptions")
@Tag(name = "Subscriptions", description = "the Subscription API")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Get subscription by ID", description = "Get subscription by ID")
    public HttpEntity<?> getSubscriptionById(@PathVariable UUID id) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Create subscription", description = "Create subscription")
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN', 'USER')")
    @Operation(summary = "Update subscription", description = "Update subscription")
    public HttpEntity<Subscription> updateSubscription(@PathVariable UUID id, @RequestBody Subscription subscriptionDetails) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, subscriptionDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    @Operation(summary = "Delete subscription", description = "Delete subscription")
    public HttpEntity<Void> deleteSubscription(@PathVariable UUID id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}