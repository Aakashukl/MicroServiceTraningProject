package com.microservices.subscriptionService.restController;

import com.microservices.subscriptionService.entity.Subscription;
import com.microservices.subscriptionService.service.SubscriptionService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubscriptionController {

  @Autowired
  SubscriptionService subscriptionService;

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/subscriptions")
  public ResponseEntity<?> getAllSubscription() {
    return new ResponseEntity<>(subscriptionService.getAllSubscription(), HttpStatus.OK);
  }

  @PostMapping("/subscription")
  public ResponseEntity<?> addSubscription(@RequestBody Subscription subscription) {
    Optional<Subscription> subscription1 = subscriptionService.addSubscription(subscription);
    return subscription1.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY));
  }

  @DeleteMapping("/subscription/{id}")
  public ResponseEntity<?> deleteSubscriptionById(@PathVariable String id) {
    return new ResponseEntity<>(subscriptionService.deleteById(id).orElse(new Subscription()),
        HttpStatus.OK);
  }
}