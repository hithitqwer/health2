package com.creator;

import com.creator.mapper.WeatherMapper;
import com.creator.model.WeatherPO;
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
    public void insertWeather(WeatherPO weather)
    {
        weatherMapper.insertWeather(weather);
    }

    @Override
    public WeatherPO selectByCode(Long code) {
        return weatherMapper.selectByCode(code);
    }

    @Override
    public void updateByCode(WeatherPO weatherPO) {
        weatherMapper.updateByCode(weatherPO);
    }
}
