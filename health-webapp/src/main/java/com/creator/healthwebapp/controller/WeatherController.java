package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.WeatherService;
import com.creator.healthwebapp.vo.WeatherVO;
import com.creator.model.WeatherPO;
import com.creator.result.Result;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

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

    @RequestMapping("/write")
    @ResponseBody
    public Result<WeatherVO> insertWeather(@RequestBody WeatherVO weather) {
        logger.info("/weather/write  weather= {}", weather);

        if(null == weather) {
            logger.error("/weather/write   weather is null");
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
        logger.info("/weather/write  params={}", weather);
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

    @RequestMapping("/deleteByCode")
    @ResponseBody
    public Result<WeatherVO> delete(@RequestParam("code") Long code) {
        logger.info("/weather/deleteByCode   code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/weather/deleteByCode   code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        WeatherPO weatherPO = weatherService.selectByCode(code);
        if(Objects.isNull(weatherPO)) {
            logger.info("/weather/deleteByCode   code对应的信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应的信息不存在");
        }

        try{
            weatherService.delete(code);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(!Objects.isNull(weatherService.selectByCode(code))) {
            logger.error("/weather/deleteByCode   code对应的信息删除失败  weatherPO={}", weatherPO);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code对应的信息删除失败");
        }
        WeatherVO weatherVO = new WeatherVO();
        BeanCopy.from(weatherPO).to(weatherVO).copy();
        logger.info("/weather/deleteByCode  code对应的信息成功删除  {}", weatherVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), weatherVO, Result.ErrorCode.OK.getMsg());
    }

}
