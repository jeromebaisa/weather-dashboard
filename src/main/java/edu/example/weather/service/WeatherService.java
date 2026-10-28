package edu.example.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.weather.model.WeatherData;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WeatherService {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<String> getCities() {
        return List.of("Seattle", "Redmond", "Bellevue");
    }

    public WeatherData load(String city) throws IOException {

        if (!getCities().contains(city)) {
            throw new IllegalArgumentException(
                "Unknown city: " + city
            );
        }

        String filename = "/weather/"
                + city.toLowerCase() + ".json";

        try (InputStream input =
                getClass().getResourceAsStream(filename)) {

            if (input == null) {
                throw new IOException(
                    "Weather file not found: " + filename
                );
            }

            return mapper.readValue(input, WeatherData.class);
        }
    }
}
