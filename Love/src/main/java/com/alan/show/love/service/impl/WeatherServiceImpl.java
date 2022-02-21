package com.alan.show.love.service.impl;

import com.alan.show.love.service.WeatherService;
import com.alan.show.love.utils.ParseJson;
import com.alan.show.love.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>天气等相关方法实现曾</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className WeatherServiceImpl.java
 * @project showLove
 * @package com.alan.show.love.service.impl
 * @date 2021/8/30-14:08
 * @email cmrhyq@163.com
 */
@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    /**
     * 返回今天白天和晚上的天气信息
     *
     * @param city 城市
     * @return HashMap<String, ArrayList < String>>> - 天气信息
     */
    @Override
    public HashMap<String, ArrayList<String>> getDayNightWeather(String city) {
        String weather = Util.getWeather(city);
        ParseJson json = new ParseJson(weather);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> weatherDay = new ArrayList<>();
        ArrayList<String> weatherNight = new ArrayList<>();
        ArrayList<String> tempHigh = new ArrayList<>();
        ArrayList<String> tempLow = new ArrayList<>();
        ArrayList<String> wind = new ArrayList<>();
        ArrayList<String> windPower = new ArrayList<>();
        ArrayList<String> tips = new ArrayList<>();
        weatherDay.add(json.getWeatherDay());
        weatherNight.add(json.getWeatherNight());
        tempHigh.add(json.getTemp().get("high"));
        tempLow.add(json.getTemp().get("low"));
        wind.add(json.getWindDirect());
        windPower.add(json.getWindPowerDayTwo());
        tips.add(json.getTips(Util.randomNumber()));
        map.put("weatherDay", weatherDay);
        map.put("weatherNight", weatherNight);
        map.put("tempHigh", tempHigh);
        map.put("tempLow", tempLow);
        map.put("wind", wind);
        map.put("windPower", windPower);
        map.put("tips", tips);
        return map;
    }
}
