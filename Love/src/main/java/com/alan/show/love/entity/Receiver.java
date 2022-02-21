package com.alan.show.love.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>接收人实体类</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className Receiver.java
 * @project showLove
 * @package com.alan.show.love.entity
 * @date 2021/8/26-16:21
 * @email cmrhyq@163.com
 */
@Data
@Entity
@Table(name = "receiver")
@DynamicUpdate
public class Receiver implements Serializable {

    private static final long serialVersionUID = 4635808294594639L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiver_id", columnDefinition = "int(11) DEFAULT NULL COMMENT 'id'")
    private Integer receiverId;

    /**
     * 接收人姓名
     */
    @Column(name = "receiver_name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '名字'")
    private String receiverName;

    /**
     * 接收人性别
     */
    @Column(name = "receiver_sex", columnDefinition = "varchar(11) DEFAULT NULL COMMENT '接收人性别'")
    private String receiverSex;

    /**
     * 接收人手机号
     */
    @Column(name = "receiver_phone", columnDefinition = "text(11) DEFAULT NULL COMMENT '接收人手机号'")
    private String receiverPhone;

    /**
     * 状态
     */
    @Column(name = "receiver_static", columnDefinition = "int(11) DEFAULT NULL COMMENT '0为经用/1为启用'")
    private int receiverStatic;

    /**
     * 所在城市
     */
    @Column(name = "receiver_city", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '所在城市'")
    private String receiverCity;

    /**
     * 发送次数
     */
    @Column(name = "receiver_send_count", columnDefinition = "text(255) DEFAULT NULL COMMENT '发送次数'")
    private Integer receiverSendCount;

    /**
     * 发送未成功次数
     */
    @Column(name = "receiver_send_error_count", columnDefinition = "text(255) DEFAULT NULL COMMENT '发送未成功次数'")
    private Integer receiverSendErrorCount;
}
