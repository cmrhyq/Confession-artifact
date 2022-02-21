package com.alan.show.love.controller;

import com.alan.show.love.entity.Receiver;
import com.alan.show.love.repository.ReceiverRepository;
import com.alan.show.love.service.ReceiverService;
import com.alan.show.love.service.WeatherService;
import com.alan.show.love.utils.ParseJson;
import com.alan.show.love.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>接口控制层</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className FunctionController.java
 * @project showLove
 * @package com.alan.show.love.controller
 * @date 2021/8/28-19:12
 * @email cmrhyq@163.com
 */
@Slf4j
@RestController
@RequestMapping("/")
public class FunctionController {

    @Autowired
    private ReceiverRepository receiverRepository;

    @Autowired
    private ReceiverService receiverService;

    @Autowired
    private WeatherService weatherService;

    /**
     * 返回今天到未来五天的温度信息
     *
     * @param city 城市
     * @return HashMap<String, ArrayList < String>> - 温度信息
     */
    @PostMapping("getTemps")
    public HashMap<String, ArrayList<String>> getTemps(String city) {
        String weather = Util.getWeather(city);
        ParseJson json = new ParseJson(weather);
        return json.getTemps();
    }

    /**
     * 返回今天白天和晚上的天气信息
     *
     * @param city 城市
     * @return HashMap<String, ArrayList < String>>> - 天气信息
     */
    @PostMapping("getDayNightWeather")
    public HashMap<String, ArrayList<String>> getDayNightWeather(String city) {
        return weatherService.getDayNightWeather(city);
    }

    /**
     * 更新用户状态
     *
     * @param receiverPhone 手机号
     * @return String类型的更新结果
     */
    @PostMapping("updateStatic")
    public Map<String, Object> updateStatic(String receiverPhone) {
        return receiverService.updateStatic(receiverPhone);
    }

    /**
     * 将所有用户信息返回
     *
     * @return List<Map < String, Object>> - 用户信息
     */
    @PostMapping("queryUserData")
    public List<Receiver> queryUserData() {
        return receiverRepository.findAll();
    }

}
