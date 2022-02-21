package com.alan.show.love.quartz;

import com.alan.show.love.config.AliyunSmsConfig;
import com.alan.show.love.entity.Receiver;
import com.alan.show.love.repository.ReceiverRepository;
import com.alan.show.love.utils.ParseJson;
import com.alan.show.love.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className QuartzJob.java
 * @project showLove
 * @package com.alan.show.love.quartz
 * @date 2021/8/26-13:33
 * @email cmrhyq@163.com
 */
@Slf4j
public class QuartzJob implements Job {

    @Autowired
    private ReceiverRepository rec;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 查询天气的城市
        String city = "汉川";
        Date date = new Date();
        // 接收者状态 0 为禁用 1 为启用
        String receiverStatic = "0";
        // 查询数据库中用户的数据
        List<Receiver> recList = rec.findReceiverInfo();
        // 设置时间格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("当前时间：" + sf.format(date));
        log.info("开始获取" + city + "的天气状况");
        try {
            // 使用封装的方法获取城市天气
            String weather = Util.getWeather(city);
            // 将获得的天气解析
            ParseJson json = new ParseJson(weather);
            log.info("获取结果为：" + json.getTips(Util.randomNumber()) + "--" + json.getWeatherDay());
            log.info("开始发送短信");
            // 遍历数据库中有多少用户并发送短信
            for (int i = 0; i < recList.size(); i++) {
                // 判断用户状态是否正常
                if (!receiverStatic.equals(recList.get(i).getReceiverStatic())) {
                    String result = Util.sendSms(recList.get(i).getReceiverName(), recList.get(i).getReceiverPhone(),
                            json.getWeatherDay(), json.getTemp().get("low") + "-" + json.getTemp().get("high"),
                            json.getTips(Util.randomNumber()));
                    if ("OK".equals(result)){
                        rec.updateSendCount(recList.get(i).getReceiverPhone(),recList.get(i).getReceiverSendCount()+1);
                    } else {
                        rec.updateSendErrorCount(recList.get(i).getReceiverPhone(), recList.get(i).getReceiverSendErrorCount()+1);
                    }
                    log.info("用户"+recList.get(i).getReceiverName()+"的发送结果为;" + result);
                } else {
                    log.info("用户：" + recList.get(i).getReceiverName() + "的状态禁用");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
