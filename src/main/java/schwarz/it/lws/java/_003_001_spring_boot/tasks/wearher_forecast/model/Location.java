package schwarz.it.lws.java._003_001_spring_boot.tasks.wearher_forecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private Long id;
    private Double longitude;
    private Double latitude;
    private String city;
}
