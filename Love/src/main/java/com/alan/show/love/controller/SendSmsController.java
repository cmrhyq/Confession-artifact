package com.alan.show.love.controller;

import com.alan.show.love.config.AliyunSmsConfig;
import com.alan.show.love.utils.ParseJson;
import com.alan.show.love.utils.SendSms;
import com.alan.show.love.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>短信发送控制层(未启用)</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className SendSmsController.java
 * @project showLove
 * @package com.alan.show.love.controller
 * @date 2021/8/26-1:56
 * @email cmrhyq@163.com
 */
@Slf4j
@Controller
@RequestMapping("/")
public class SendSmsController {
    @Autowired
    private SendSms send;

    /**
     * 调用aliYun短信发送接口方法发送短信
     *
     * @return String Type. send result
     */
    @PostMapping("sendSms")
    public String sendSms(String city) {
        String weather = Util.getWeather(city);
        ParseJson json = new ParseJson(weather);
        return send.sendSms(AliyunSmsConfig.RECEIVER_NAME, AliyunSmsConfig.RECEIVER_PHONE, json.getWeatherDay(), json.getTemp().get("low") + "-" + json.getTemp().get("high"), json.getTips(Util.randomNumber()));
    }
}
