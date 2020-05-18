package pred;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class PredictionController {

    @RequestMapping("/Prediction")
    public String index() throws IOException {
        return predict();
    }

    public String predict() throws IOException, RestClientException {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Integer> request = new HttpEntity<>(5);
        //ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8083/course",request,String.class);
        ResponseEntity<String> response2 = restTemplate.getForEntity("http://localhost:8081/WeatherMain", String.class);
        return response2.getBody() + "343";//response.getBody();
    }
}
