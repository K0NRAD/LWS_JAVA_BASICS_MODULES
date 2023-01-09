package schwarz.it.lws.java._003_001_spring_boot.tasks.wearher_forecast.service.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String message) {
        super(message);
    }
}
