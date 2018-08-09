package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class WeatherPO {
    private Integer id;
    private Long code;
    private String weather;
    private Integer humidity;
    private String visibility;
    private Integer pressure;
    private Integer weatherCode;
    private String sunrise;
    private String sunset;
    private Integer ultraviolet;
    private Integer windForce;
    private Integer airQuality;
    private WindDirection windDirection;
    private String WindDirectionString;
    private String picPath;
}
