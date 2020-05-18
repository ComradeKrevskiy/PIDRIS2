package weather.JsonStuff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJsonCurrently {
    public Double temperature;
}
