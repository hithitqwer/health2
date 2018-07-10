package com.creator;

import com.creator.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImp implements WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public int countNum()
    {
        return weatherMapper.countNum();
    }

    @Override
    public void insertWeather(Weather weather)
    {
        weatherMapper.insertWeather(weather);
    }
}
