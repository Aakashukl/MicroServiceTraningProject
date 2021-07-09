package com.microservices.subscriptionService.service;

import com.microservices.subscriptionService.entity.Subscription;
import com.microservices.subscriptionService.model.Book;
import com.microservices.subscriptionService.repository.SubscriptionRepository;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Subscription> getAllSubscription() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> addSubscription(Subscription subscription) {
        Book book = getBookById(subscription.getBookId());
        if (Objects.isNull(book) || book.getAvailableCopies()==0)
            return Optional.empty();
        updateBookCopies(subscription.getBookId(),-1);
        return Optional.of(subscriptionRepository.save(subscription));
    }

    @Override
    public Optional<Subscription> deleteById(String id) {
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if (subscription.isPresent()) {
            subscriptionRepository.delete(subscription.get());
            return subscription;
        }
        subscriptionRepository.deleteById(id);
        return Optional.empty();
    }

    private Book getBookById(long id) {
        String url = String.format("http://bookService/books/%s",id);
        return restTemplate.getForObject(url, Book.class);
    }

    private String updateBookCopies(long id,int incrementCount) {
        String url = "http://bookService/books/updateAvailability/{id}/{incrementCount}";
        return restTemplate.exchange(url, HttpMethod.PUT, null,
            new ParameterizedTypeReference<String>() {},id,incrementCount).getBody();
    }
}
