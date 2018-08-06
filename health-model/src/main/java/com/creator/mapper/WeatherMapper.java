package com.creator.mapper;

import com.creator.model.WeatherPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WeatherMapper {

    int countNum();

    int insertWeather(WeatherPO weather);

    WeatherPO selectByCode(Long code);

    int updateByCode(WeatherPO weather);
}
