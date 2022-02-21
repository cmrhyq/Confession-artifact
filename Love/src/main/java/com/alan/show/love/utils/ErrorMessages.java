package com.alan.show.love.utils;

import java.io.Serializable;

/**
 * <p>错误代码实现类</p>
 *
 * @author Alan Huang
 * @version v1
 * @Title ErrorMessages
 * @date 2021/7/22-16:33
 * @Email cmrhyq@163.com
 */
public interface ErrorMessages extends Serializable {
    /**
     * 错误代码名
     *
     * @since 1.0.0
     */
    public static final String E_CODE = "errcode";
    /**
     * 错误信息名
     *
     * @since 1.0.0
     */
    public static final String E_MSG = "errmsg";
    /**
     * 错误信息名
     *
     * @since 1.0.0
     */
    public static final String E_STATUS = "errstatus";
    /**
     * 请求处理数据
     *
     * @since 1.0.0
     */
    public static final String DATA = "data";
    /**
     * 请求处理使时间
     *
     * @since 1.0.0
     */
    public static final String DATE_TIME = "dateTime";
    /**
     * 请求未处理
     *
     * @since 1.0.0
     */
    public static final String NO_PRO = "Request not processed";
    /**
     * 访问验证请求返回的jwt
     */
    public static final String JWT = "jwt";

    /**
     * 获得错误代码
     *
     * @return int 返回错误代码
     * @author Alan Huang on 2020/10/16 09:33
     * @description ErrorMessages / getCode
     * @version 1.0.0
     * @since 1.0.0
     */
    String getCode();

    /**
     * 获得错误代码对应的错误信息
     *
     * @return java.lang.String 返回错误信息
     * @author Alan Huang on 2020/10/16 09:34
     * @description ErrorMessages / getMsg
     * @version 1.0.0
     * @since 1.0.0
     */
    String getMessage();

    /**
     * 获得错误代码对应的错误信息
     *
     * @return java.lang.String 返回状态
     * @author Alan Huang on 2020/10/16 09:34
     * @description ErrorMessages / getStatus
     * @version 1.0.0
     * @since 1.0.0
     */
    int getStatus();
}

