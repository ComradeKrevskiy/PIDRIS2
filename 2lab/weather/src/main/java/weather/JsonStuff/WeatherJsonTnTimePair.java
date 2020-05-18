package weather.JsonStuff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJsonTnTimePair {
    public double highTemp;
    public int time;
}
