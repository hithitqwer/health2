package com.creator;

import com.creator.model.WeatherPO;

public interface WeatherService {

    int countNum();

    void insertWeather(WeatherPO weather);

    WeatherPO selectByCode(Long code);

    void updateByCode(WeatherPO weather);
}
