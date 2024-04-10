package edu.miu.cs489democode.repository;

import edu.miu.cs489democode.model.Publisher;
import org.springframework.data.repository.ListCrudRepository;


public interface PublisherRepository extends ListCrudRepository<Publisher, Integer> {
}
