package pred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class PredictionMain {

    public static void main(String[] args) {
        SpringApplication.run(PredictionMain.class, args);
    }

}
