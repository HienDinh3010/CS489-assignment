package edu.miu.cs489democode.service;

import edu.miu.cs489democode.model.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher addNewPublisher(Publisher publisher);

    List<Publisher> getAllPublishers();
}
