package weather.JsonStuff;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJsonData {
    public ArrayList<WeatherJsonTnTimePair> data;
}