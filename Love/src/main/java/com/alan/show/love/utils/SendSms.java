package com.alan.show.love.utils;

import com.alan.show.love.config.AliyunSmsConfig;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>AliYun短信发送工具</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className SendSms.java
 * @project showLove
 * @package com.alan.show.love.utils
 * @date 2021/8/26-1:00
 * @email cmrhyq@163.com
 */
@Slf4j
@Service
public class SendSms {

    /**
     * 阿里云短信发送方法
     *
     * @param name 名字
     * @param phone 手机号
     * @param weather 天气
     * @param temperature 温度
     * @param other 提示
     * @return String send result
     */
    public String sendSms(String name, String phone, String weather, String temperature, String other) {
        String result = "";
        // 设置超时时间
        System.setProperty(AliyunSmsConfig.DEFAULT_CONNECT_TIMEOUT, AliyunSmsConfig.TIMEOUT);
        System.setProperty(AliyunSmsConfig.DEFAULT_READ_TIMEOUT, AliyunSmsConfig.TIMEOUT);
        // 初始化ascClient
        // 短信API产品名称
        final String product = AliyunSmsConfig.PRODUCT;
        // 短信API产品域名
        final String domain = AliyunSmsConfig.DOMAIN;
        // accessKeyId
        final String accessKeyId = AliyunSmsConfig.AK_KEY_ID;
        // accessKeySecret
        final String accessKeySecret = AliyunSmsConfig.AK_KEY_SECRET;
        // 初始化ascClient,
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
                    domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 待发送手机号
        request.setPhoneNumbers(phone);
        // 短信签名
        request.setSignName(AliyunSmsConfig.SIGN_NAME);
        // 短信模板
        request.setTemplateCode(AliyunSmsConfig.SMS_TEMP);
        // 模板中的变量替换JSON串,如模板内容为"***${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"name\":\"" + name + "\",\"waether\":\"" + weather + "\",\"Temperature\":\"" + temperature + "\",\"other\":\"" + other + "\"}");
        // outId为提供给业务方扩展字段
        request.setOutId("yourOutId");
        // 请求失败抛ClientException异常
        SendSmsResponse sendSmsResponse;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            // 判断是否请求成功
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                // 请求成功
                result = "发送成功";
                log.info(result);
            } else {
                // 请求失败
                result = sendSmsResponse.getCode();
                log.info(result);
            }
            return result;
        } catch (ClientException e) {
            e.printStackTrace();
            result = "由于系统维护，暂时无法注册！";
            return result;
        }
    }
}
