package org.adaschool.Weather.service;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherReportServiceTests {

    @Autowired
    private WeatherReportService weatherReportService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testGetWeatherReport(){
        WeatherApiResponse mockResponse = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setTemperature(0.0);
        main.setHumidity(88.0);
        mockResponse.setMain(main);

        when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat=37.8267&lon=-122.4233&appid=8d538bd0e78a70e6fd135397fc6478fa", WeatherApiResponse.class))
                .thenReturn(mockResponse);

        WeatherReport report = weatherReportService.getWeatherReport(37.8267, -122.4233);

        assertEquals(0.0, report.getTemperature());
        assertEquals(88.0, report.getHumidity());

    }

}
