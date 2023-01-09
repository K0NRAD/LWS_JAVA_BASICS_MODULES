package schwarz.it.lws.java._003_001_spring_boot.tasks.wearher_forecast.model;

import lombok.Data;

@Data
public class WeatherForecastRequestParam {
    private String city;
    private Integer days;
}
