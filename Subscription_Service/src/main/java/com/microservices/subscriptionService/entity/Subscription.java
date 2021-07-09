package com.microservices.subscriptionService.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(generator = "subscription-uuid")
    @GenericGenerator(strategy = "uuid", name = "subscription-uuid")
    private String subscriptionId;
    private String subscriberName;
    private Date subscriptionDate;
    private Date returnDate;
    private long BookId;

    public Subscription() {
    }

    public Subscription(String subscriptionId, String subscriberName, Date subscriptionDate, Date returnDate, long bookId) {
        this.subscriptionId = subscriptionId;
        this.subscriberName = subscriberName;
        this.subscriptionDate = subscriptionDate;
        this.returnDate = returnDate;
        BookId = bookId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long getBookId() {
        return BookId;
    }

    public void setBookId(long bookId) {
        BookId = bookId;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", subscriberName='" + subscriberName + '\'' +
                ", subscriptionDate=" + subscriptionDate +
                ", returnDate=" + returnDate +
                ", BookId=" + BookId +
                '}';
    }
}
