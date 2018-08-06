package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.WeatherService;
import com.creator.healthwebapp.vo.WeatherVO;
import com.creator.model.WeatherPO;
import com.creator.result.Result;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/weather")
public class WeatherController{

    private Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Resource
    private WeatherService weatherService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/count")
    public Result<Integer> countNum() {
        Integer num = weatherService.countNum();
        logger.info("/weather/count");
        return new Result<>(Result.ErrorCode.OK.getCode(), num, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result<WeatherVO> insertWeather(WeatherVO weather) {
        logger.info("/weather/insert  weather= {}", weather);

        if(null == weather) {
            logger.error("/weather/insert   weather is null");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), Result.ErrorCode.ParamCheckError.getMsg());
        }

        Long code = loginService.getCodeByTime();
        WeatherPO weatherPO = new WeatherPO();
        BeanCopy.from(weather).to(weatherPO).copy();

        if(null != weatherService.selectByCode(code)) {
            weatherService.updateByCode(weatherPO);
        }else{
            weatherService.insertWeather(weatherPO);
        }

        WeatherPO weatherSelect = weatherService.selectByCode(code);
        WeatherVO weatherVOR = new WeatherVO();
        BeanCopy.from(weatherSelect).to(weatherVOR).copy();
        logger.info("/weather/insert  params={}", weather);
        return new Result<>(Result.ErrorCode.OK.getCode(), weatherVOR, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByCode")
    @ResponseBody
    public Result<WeatherVO> selectByCode(@RequestParam("code") Long code) {
        logger.info("/weather/selectByCode  code= {}", code);

        if(null == code) {
            logger.error("/weather/selectByCode  code is null");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),Result.ErrorCode.ParamCheckError.getMsg());
        }

        WeatherPO weatherPO =  weatherService.selectByCode(code);
        if(null == weatherPO) {
            logger.error("/weather/selectByCode   code= {}对应的数据不存在", code);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "code 对应的数据不存在");
        }

        WeatherVO weatherVO = new WeatherVO();
        BeanCopy.from(weatherPO).to(weatherVO).copy();
        logger.info("/weather/selectByCode  code= {} 对应的结果为 {}", code, weatherPO);
        return new Result<>(Result.ErrorCode.OK.getCode(), weatherVO, Result.ErrorCode.OK.getMsg());
    }
}
