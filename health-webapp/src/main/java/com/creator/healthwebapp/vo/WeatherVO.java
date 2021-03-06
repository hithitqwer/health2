package com.creator.healthwebapp.vo;

import com.creator.model.WindDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
/**
 * @author zhangzeyu
 */
@Getter
@Setter
@ToString
public class WeatherVO implements Serializable {
    private String weather;
    private Integer humidity;
    private String visibility;
    private Integer pressure;
    private Integer weatherCode;
    private Date sunrise;
    private Date sunset;
    private Integer ultraviolet;
    private Integer windForce;
    private Integer airQuality;
    private WindDirection windDirection;
    private String WindDirectionString;
    private String picPath;
}
