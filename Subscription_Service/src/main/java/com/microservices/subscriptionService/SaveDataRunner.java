package com.microservices.subscriptionService;

import com.microservices.subscriptionService.entity.Subscription;
import com.microservices.subscriptionService.repository.SubscriptionRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.sql.Date;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class SaveDataRunner implements CommandLineRunner {
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 10).forEach(i -> {
            Subscription subscription = new Subscription();
            subscription.setSubscriptionDate(new Date(System.currentTimeMillis()));
            subscription.setSubscriptionId(UUID.randomUUID().toString());
            subscription.setSubscriberName("Akash " + i);
            subscription.setReturnDate(new Date(System.currentTimeMillis()));
            subscription.setBookId(i + 1L);
            subscriptionRepository.save(subscription);
        });
    }
}
