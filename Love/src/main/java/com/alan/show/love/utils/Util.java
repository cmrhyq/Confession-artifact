package com.alan.show.love.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * <p>获取天气信息、读取网址信息、短信发送</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className Util.java
 * @project showLove
 * @package com.alan.show.love.utils
 * @date 2021/8/23-0:54
 * @email cmrhyq@163.com
 */
@Slf4j
public class Util {

    @Autowired
    private SendSms send;

    /**
     * 使用Math.random的方法返回0到11的随机整数
     *
     * @return int - number
     */
    public static int randomNumber() {
        return (int) (Math.random() * 11);
    }

    /**
     * 读取网址数据
     *
     * @param getUrl 网址
     * @return 读取结果
     */
    public static String getString(String getUrl) {
        try {
            URL url = new URL(getUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            StringBuffer sb = new StringBuffer();
            String text = null;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回一个Json类型的天气信息
     *
     * @param city 城市
     * @return 天气结果
     */
    public static String getWeather(String city) {
        try {
            String json = getString("https://itdage.cn/hw/weather?city=" + URLEncoder.encode(city, "utf-8"));
            return json;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过URLEncoder.encode()的方法转换参数成浏览器看得懂的数据并请求接口发送短信
     *
     * @param name        名字
     * @param phoneNumber 手机号
     * @param s1          天气
     * @param s2          温度
     * @param s3          温馨提示
     * @return 发送结果
     */
    public static String sendSms(String name, String phoneNumber, String s1, String s2, String s3) {
        try {
            name = URLEncoder.encode(name, "utf-8");
            s1 = URLEncoder.encode(s1, "utf-8");
            s2 = URLEncoder.encode(s2, "utf-8");
            s3 = URLEncoder.encode(s3, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getString("https://itdage.cn/hw/hwSms?name=" + name + "&phoneNumber=" + phoneNumber + "&s1=" + s1 + "&s2=" + s2 + "&s3=" + s3);
    }

    /**
     * 测试main方法
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException{
//        String weather = getWeather("武汉");
//        ParseJson json = new ParseJson(weather);
//        log.info(""+json.getTemps());

//        log.info(sendSms("1","18164038469","1","1","1"));

//        String weather = getWeather("武汉");
//        ParseJson json = new ParseJson(weather);
//        log.info(sendSms(AliyunSmsConfig.RECEIVER_NAME, AliyunSmsConfig.RECEIVER_PHONE, json.getWeather(), json.getTemp().get("low") + "-" + json.getTemp().get("high"), json.getTips(randomNumber())));
    }

}
