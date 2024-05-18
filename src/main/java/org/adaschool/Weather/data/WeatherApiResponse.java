package org.adaschool.Weather.data;

public class WeatherApiResponse {

    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public static class Main {
        private double temp;
        private double humidity;

        public double getTemperature() {
            return temp;
        }

        public void setTemperature(double temp) {
            this.temp = temp;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }
    }
}