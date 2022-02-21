package com.alan.show.love.repository;

import com.alan.show.love.entity.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * <p>操作接收人表的接口</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className ReceiverRepository.java
 * @project showLove
 * @package com.alan.show.love.repository
 * @date 2021/8/26-16:39
 * @email cmrhyq@163.com
 */
public interface ReceiverRepository extends JpaRepository<Receiver, Integer> {

    /**
     * 查询所有数据
     *
     * @return List
     */
    @Query("select r.receiverName, r.receiverSex, r.receiverPhone, r.receiverStatic, r.receiverCity, r.receiverSendCount, r.receiverSendErrorCount from Receiver as r")
    List<Receiver> findReceiverInfo();

    /**
     * 根据手机号查询数据
     *
     * @param receiverPhone 手机号
     * @return map
     */
    Receiver findByReceiverPhone(String receiverPhone);

    /**
     * 更新账号的发送状态
     *
     * @param receiverPhone  手机号
     * @param receiverStatic 发送状态 只能为0/1
     */
    @Modifying(clearAutomatically = true)
    @Transactional(rollbackOn = Exception.class)
    @Query("update Receiver as r set r.receiverStatic = ?2 where r.receiverPhone = ?1")
    void updateStatic(String receiverPhone, int receiverStatic);

    /**
     * 增加发送次数
     *
     * @param receiverPhone     手机号
     * @param receiverSendCount 发送次数
     */
    @Modifying(clearAutomatically = true)
    @Transactional(rollbackOn = Exception.class)
    @Query("update Receiver as r set r.receiverSendCount = ?2 where r.receiverPhone = ?1")
    void updateSendCount(String receiverPhone, int receiverSendCount);

    /**
     * 增加发送错误次数
     *
     * @param receiverPhone          手机号
     * @param receiverSendErrorCount 发送失败次数
     */
    @Modifying(clearAutomatically = true)
    @Transactional(rollbackOn = Exception.class)
    @Query("update Receiver as r set r.receiverSendErrorCount = ?2 where r.receiverPhone = ?1")
    void updateSendErrorCount(String receiverPhone, int receiverSendErrorCount);
}
