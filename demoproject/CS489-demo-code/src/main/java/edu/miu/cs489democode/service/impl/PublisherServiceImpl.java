package edu.miu.cs489democode.service.impl;

import edu.miu.cs489democode.model.Publisher;
import edu.miu.cs489democode.repository.PublisherRepository;
import edu.miu.cs489democode.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher addNewPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return null;
    }
}
