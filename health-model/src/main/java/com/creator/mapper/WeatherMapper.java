package com.creator.mapper;

import com.creator.model.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WeatherMapper {

    int countNum();

    int insertWeather(Weather weather);
}
