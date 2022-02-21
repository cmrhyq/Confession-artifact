package com.alan.show.love.service;

import com.alan.show.love.entity.Receiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className ReceiverService.java
 * @project showLove
 * @package com.alan.show.love.service
 * @date 2021/8/31-9:49
 * @email cmrhyq@163.com
 */
public interface ReceiverService {

    /**
     * 更新用户状态
     * @param receiverPhone 手机号
     * @return String类型的更新结果
     */
    Map<String, Object> updateStatic(String receiverPhone);
}
