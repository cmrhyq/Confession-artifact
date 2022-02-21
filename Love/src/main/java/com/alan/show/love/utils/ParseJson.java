package com.alan.show.love.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>解析返回的Json格式的天气信息</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className ParseJson.java
 * @project showLove
 * @package com.alan.show.love.utils
 * @date 2021/8/25-22:18
 * @email cmrhyq@163.com
 */
@Slf4j
public class ParseJson {

    private JSONObject data;

    public ParseJson(String json) {
        this.data = JSONObject.parseObject(json);
        this.data = this.data.getJSONObject("resp");
    }

    /**
     * 使用FastJson获取当天白天黑夜的风力等级
     *
     * @return Map<String, String> - night day
     */
    public Map<String, String> getWindPowerDay() {
        HashMap<String, String> map = new HashMap<>();
        JSONArray array = data.getJSONObject("forecast").getJSONArray("weather");
        JSONObject obj = array.getJSONObject(0);
        map.put("night", obj.getJSONObject("night").getString("fengli"));
        map.put("day", obj.getJSONObject("day").getString("fengli"));
        return map;
    }

    /**
     * 获取当天的综合风力等级
     *
     * @return String - 风力
     */
    public String getWindPowerDayTwo() {
        return data.getString("fengli");
    }

    /**
     * 使用FastJson获取未来五天风力等级
     *
     * @return HashMap<String, ArrayList < String>> - low high
     */
    public HashMap<String, ArrayList<String>> getWindPowers() {
        HashMap map = new HashMap();
        JSONArray array = data.getJSONObject("forecast").getJSONArray("weather");
        ArrayList low = new ArrayList();
        ArrayList high = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            low.add(obj.getJSONObject("day").getString("fengli"));
            high.add(obj.getJSONObject("night").getString("fengli"));
        }
        map.put("low", low);
        map.put("high", high);
        return map;
    }

    /**
     * 使用FastJson获取今天的温度区间
     *
     * @return HashMap<String, String> - low high
     */
    public HashMap<String, String> getTemp() {
        HashMap<String, String> map = new HashMap<>();
        JSONArray array = data.getJSONObject("forecast").getJSONArray("weather");
        JSONObject obj = array.getJSONObject(0);
        map.put("low", obj.getString("low"));
        map.put("high", obj.getString("high"));
        return map;
    }

    /**
     * 使用FastJson获取未来五天的温度
     *
     * @return HashMap<String, ArrayList < String>> - low high
     */
    public HashMap<String, ArrayList<String>> getTemps() {
        HashMap map = new HashMap();
        JSONArray array = data.getJSONObject("forecast").getJSONArray("weather");
        ArrayList low = new ArrayList();
        ArrayList high = new ArrayList();
        ArrayList week = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            week.add(obj.getString("date"));
            low.add(obj.getString("low").substring(3, 5));
            high.add(obj.getString("high").substring(3, 5));
        }
        map.put("week", week);
        map.put("low", low);
        map.put("high", high);
        return map;
    }

    /**
     * 使用FastJson获取当天的风向
     *
     * @return String - Wind Direct
     */
    public String getWindDirect() {
        return data.getString("fengxiang");
    }

    /**
     * 使用FastJson获取当天白天的天气信息
     *
     * @return String - weather
     */
    public String getWeatherDay() {
        JSONArray day = data.getJSONObject("forecast").getJSONArray("weather");
        JSONObject obj = day.getJSONObject(0);
        return obj.getJSONObject("day").getString("type");
    }

    /**
     * 使用FastJson获取当天夜晚的天气信息
     *
     * @return String - weather
     */
    public String getWeatherNight() {
        JSONArray day = data.getJSONObject("forecast").getJSONArray("weather");
        JSONObject obj = day.getJSONObject(0);
        return obj.getJSONObject("night").getString("type");
    }

    /**
     * 使用FastJson组装温馨提示
     *
     * @return Map<String, String> - tips
     */
    public String getTips(int tipsNumber) {
        StringBuilder tips = new StringBuilder();
        JSONArray tipsArray = data.getJSONObject("zhishus").getJSONArray("zhishu");
        for (int i = 0; i < tipsArray.size(); i++) {
            JSONObject obj = tipsArray.getJSONObject(i);
            if (i == tipsNumber) {
                tips.append(obj.getString("detail"));
            }
        }
        return tips.toString();
    }
}
