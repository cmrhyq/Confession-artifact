package com.alan.show.love.service.impl;

import com.alan.show.love.entity.Receiver;
import com.alan.show.love.repository.ReceiverRepository;
import com.alan.show.love.service.ReceiverService;
import com.alan.show.love.utils.EnumErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className ReceiverServiceImpl.java
 * @project showLove
 * @package com.alan.show.love.service.impl
 * @date 2021/8/31-9:49
 * @email cmrhyq@163.com
 */
@Slf4j
@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    /**
     * 更新用户状态
     *
     * @param receiverPhone 手机号
     * @return String类型的更新结果
     */
    @Override
    public Map<String, Object> updateStatic(String receiverPhone) {
        Map<String, Object> result = new HashMap<>();
        Receiver receiver = receiverRepository.findByReceiverPhone(receiverPhone);
        if (receiver != null) {
            if (receiver.getReceiverStatic() == 1) {
                receiverRepository.updateStatic(receiverPhone, 0);
                result.put("code", EnumErrorCode.DISABLE_SUCCESS.getCode());
                result.put("message", EnumErrorCode.DISABLE_SUCCESS.getMessage());
                result.put("status", EnumErrorCode.DISABLE_SUCCESS.getStatus());
            } else {
                receiverRepository.updateStatic(receiverPhone, 1);
                result.put("code", EnumErrorCode.ENABLE_SUCCESS.getCode());
                result.put("message", EnumErrorCode.ENABLE_SUCCESS.getMessage());
                result.put("status", EnumErrorCode.ENABLE_SUCCESS.getStatus());
            }
        } else {
            result.put("code", EnumErrorCode.ACCOUNT_NOT_EXIST.getCode());
            result.put("message", EnumErrorCode.ACCOUNT_NOT_EXIST.getMessage());
            result.put("status", EnumErrorCode.ACCOUNT_NOT_EXIST.getStatus());
        }
        return result;
    }

}
