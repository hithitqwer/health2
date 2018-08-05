package com.creator.healthwebapp.controller;

import com.creator.model.Weather;
import com.creator.WeatherService;
import com.creator.model.WindDirection;
import com.creator.result.WeatherResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weather")
public class WeatherController{

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherResult.class);

    @Resource
    private WeatherService weatherService;

    @RequestMapping("/count")
    public WeatherResult countNum()
    {
        WeatherResult weatherResult=new WeatherResult();
        weatherResult.setObject(weatherService.countNum());
        LOGGER.info("/weather/count   weatherResult={}",weatherResult);
        return weatherResult;
    }

    @RequestMapping("/insert")
    public WeatherResult insertWeather(Weather weather, int windDirectionId)
    {
        WeatherResult weatherResult=new WeatherResult();
        weather.setWindDirectionString(WindDirection.of(windDirectionId).getWindDirection());
        weatherResult.setObject(weather);
        weatherService.insertWeather(weather);
        LOGGER.info("/weather/insert   insertObject={}",weather.toString());
        return weatherResult;
    }
}
