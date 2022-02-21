package com.alan.show.love.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>天气等相关方法Service层</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className WeatherService.java
 * @project showLove
 * @package com.alan.show.love.service
 * @date 2021/8/30-14:08
 * @email cmrhyq@163.com
 */
public interface WeatherService {

    /**
     * 返回今天白天和晚上的天气信息
     *
     * @param city 城市
     * @return HashMap<String, ArrayList < String>>> - 天气信息
     */
    HashMap<String, ArrayList<String>> getDayNightWeather(String city);
}
