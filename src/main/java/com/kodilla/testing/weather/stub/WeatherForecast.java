package com.kodilla.testing.weather.stub;


import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    Temperatures temperatures;

    //brakuje klasy impl interfej Temperatures = z tego powodu tworzymy zaslepke
    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public HashMap<Integer, Double> calculateForecast(){
        HashMap<Integer, Double> resultMap = new HashMap<>();

        for(Map.Entry<Integer, Double> temperature: temperatures.getTemperatures().entrySet()){//dlaczego?
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }
}
