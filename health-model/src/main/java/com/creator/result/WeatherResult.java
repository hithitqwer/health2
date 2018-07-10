package com.creator.result;

import com.creator.Weather;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class WeatherResult implements Serializable {
    private Integer code;
    private Integer userId;
    private Weather weather;
    private String userMsg;
    private String msg;
    private Object object;
}
