package com.creator;

import com.creator.model.WeatherPO;

/**
 * @author zhangzeyu
 */
public interface WeatherService {

    int countNum();

    void insertWeather(WeatherPO weather);

    WeatherPO selectByCode(Long code);

    void updateByCode(WeatherPO weather);

    void delete(Long code);
}
