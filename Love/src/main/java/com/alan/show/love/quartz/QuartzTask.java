package com.alan.show.love.quartz;

import com.alan.show.love.entity.Receiver;
import com.alan.show.love.repository.ReceiverRepository;
import com.alan.show.love.utils.ParseJson;
import com.alan.show.love.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>Quartz任务</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className QuartzTask.java
 * @project showLove
 * @package com.alan.show.love.quartz
 * @date 2021/8/26-17:18
 * @email cmrhyq@163.com
 */
@Slf4j
@Service
public class QuartzTask {

    @Autowired
    private ReceiverRepository rec;

    /**
     * quartz所要执行的任务
     */
    public void reptilian() {
        // 查询天气的城市
        String city = "";
        Date date = new Date();
        // 接收者状态 0 为禁用 1 为启用
        int receiverStatic = 0;
        // 查询数据库中用户的数据
        List<Receiver> recList = rec.findAll();
        // 设置时间格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("当前时间：" + sf.format(date));
        try {
            String tips = "";
            // 遍历数据库中有多少用户并发送短信
            for (int i = 0; i < recList.size(); i++) {
                city = recList.get(i).getReceiverCity();
                // 使用封装的方法获取城市天气
                String weather = Util.getWeather(city);
                // 将获得的天气解析
                ParseJson json = new ParseJson(weather);
                log.info("--开始获取" + city + "的天气状况--");
                tips = json.getTips(Util.randomNumber());
                log.info("获取的结果提示为：" + tips + ",天气为：" + json.getWeatherDay());
                // 判断用户状态是否正常
                if (receiverStatic != recList.get(i).getReceiverStatic()) {
                    String result = Util.sendSms(recList.get(i).getReceiverName(), recList.get(i).getReceiverPhone(),
                            json.getWeatherDay(), json.getTemp().get("low") + "-" + json.getTemp().get("high"),
                            tips);
                    // 根据发送的结果分为成功和失败两种，分别计算两种情况的次数
                    if ("OK".equals(result)) {
                        int receiverSendCount = recList.get(i).getReceiverSendCount() + 1;
                        rec.updateSendCount(recList.get(i).getReceiverPhone(), receiverSendCount);
                    } else {
                        int receiverSendErrorCount = recList.get(i).getReceiverSendErrorCount() + 1;
                        rec.updateSendErrorCount(recList.get(i).getReceiverPhone(), receiverSendErrorCount);
                    }
                    log.info("--用户" + recList.get(i).getReceiverName() + "的发送结果为;" + result+"--");
                } else {
                    int receiverSendErrorCount = recList.get(i).getReceiverSendErrorCount() + 1;
                    rec.updateSendErrorCount(recList.get(i).getReceiverPhone(), receiverSendErrorCount);
                    log.info("--用户：" + recList.get(i).getReceiverName() + "的状态禁用--");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
