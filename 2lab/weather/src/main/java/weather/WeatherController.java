package weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    @Autowired
    private WeatherMain service = new WeatherMain();

    @RequestMapping("/WeatherMain")
    public String weather() throws IOException {
        return "The current temperature is " + service.getCurrentWeather().temperature;
    }

}
