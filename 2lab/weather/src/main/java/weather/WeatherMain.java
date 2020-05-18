package weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import weather.JsonStuff.WeatherJsonCurrently;
import weather.JsonStuff.WeatherJsonStruct;
import weather.JsonStuff.WeatherJsonTnTimePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WeatherMain {
    RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication.run(WeatherMain.class, args);
    }


    public String getResponse(String currentTime){
        String curl = "https://api.darksky.net/forecast/"+"7680422f32effb534f62f1283f0c38be"+"/42.3601,-71.0589," + currentTime;
        System.out.println(curl);
        ResponseEntity<String> response = restTemplate.getForEntity(curl, String.class);
        String responseBody =response.getBody();
        System.out.println("responseBody = " + responseBody);
        return responseBody;
    }

    public WeatherJsonStruct parseBody(String responseBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherJsonStruct data = objectMapper.readValue(responseBody, WeatherJsonStruct.class);
        return data;
    }

    public WeatherJsonCurrently getCurrentWeather() throws IOException {
        long unixTime = System.currentTimeMillis() / 1000L;
        String responseBody = getResponse("" + unixTime);
        WeatherJsonStruct response = parseBody(responseBody);
        return response.currently;
    }

    public WeatherJsonTnTimePair getTInOneDay(String responseBody) throws IOException {
        WeatherJsonStruct response = parseBody(responseBody);
        return response.daily.data.get(0);
    }


    public List<Double> getTInTwentyDays() throws IOException {
        List<Double> data = new ArrayList<>();
        long unixTime = System.currentTimeMillis() / 1000L;
        for (long i = 0; i < 20; i++) {
            WeatherJsonTnTimePair response = getTInOneDay(getResponse("" + (unixTime - i * 86400L)));
            data.add(response.highTemp);
        }
        return data;
    }

}

