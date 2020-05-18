package weather.JsonStuff;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJsonStruct {
    public WeatherJsonData daily;
    public WeatherJsonCurrently currently;
}