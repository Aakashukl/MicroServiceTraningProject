package com.microservices.subscriptionService.repository;

import com.microservices.subscriptionService.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,String> {

}
