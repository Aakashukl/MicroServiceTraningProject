package com.microservices.subscriptionService.service;

import com.microservices.subscriptionService.entity.Subscription;
import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

  List<Subscription> getAllSubscription();

  Optional<Subscription> addSubscription(Subscription subscription);

  Optional<Subscription> deleteById(String id);
}
