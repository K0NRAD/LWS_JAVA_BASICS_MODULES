package schwarz.it.lws.java._003_001_spring_boot.tasks.wearher_forecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {
    private Long id;
    private Location location;
    @Builder.Default
    private List<Weather> weathers = new ArrayList<>();

    public void addWeather(Weather weather) {
        weathers.add(weather);
    }
}
