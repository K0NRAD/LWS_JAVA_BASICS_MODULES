package schwarz.it.lws.java._003_001_spring_boot.tasks.wearher_forecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private Long id;
    private Double temperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Integer pressure;
    private Integer humidity;
    private String date;
    private String description;
    private String weatherIcon;
}
