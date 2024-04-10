package cs489.apsd.citylibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitylibraryApplication implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(CitylibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test");
    }
}
