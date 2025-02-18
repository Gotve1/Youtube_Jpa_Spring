package com.example.youtube.service;

import com.example.youtube.model.Subscription;
import com.example.youtube.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(UUID id) {
        return subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(UUID id, Subscription subscriptionDetails) {
        Subscription subscription = getSubscriptionById(id);
        subscription.setStatus(subscriptionDetails.getStatus());
        subscription.setUnsubscribeDate(subscriptionDetails.getUnsubscribeDate());
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(UUID id) {
        subscriptionRepository.deleteById(id);
    }
}
