package com.microservice.store.service;

public interface CDCEventConsumer {

    void handle (String message);
}
