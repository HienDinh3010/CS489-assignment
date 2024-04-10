package edu.miu.cs489democode;

import edu.miu.cs489democode.model.Publisher;
import edu.miu.cs489democode.repository.PublisherRepository;
import edu.miu.cs489democode.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cs489DemoCodeApplication implements CommandLineRunner {

    private PublisherService publisherService;

    public Cs489DemoCodeApplication(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public static void main(String[] args) {

        SpringApplication.run(Cs489DemoCodeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
        var penguinRandomHouse = new Publisher
                (null, "Random House", "123");
        publisherService.addNewPublisher(penguinRandomHouse);
    }
}
