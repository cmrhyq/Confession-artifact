package com.alan.show.love.utils;

/**
 * <p>错误代码枚举类</p>
 * <p>
 * 000001~100000 请求成功
 * 100001~200000 请求失败
 * 200001~300000 客户端错误
 * 300001~400000 服务器错误
 * </p>
 *
 * @author Alan Huang
 * @version v1
 * @Title ErrorMessages
 * @date 2021/7/22-16:33
 * @Email cmrhyq@163.com
 */
public enum EnumErrorCode implements ErrorMessages {
    /**
     * 请求成功，SUCCESS
     *
     * @since 1.0.0
     */
    SUCCESS("000001", "请求成功", 101),
    /**
     * 启用成功
     */
    ENABLE_SUCCESS("000002", "启用成功", 102),
    /**
     * 禁用成功
     */
    DISABLE_SUCCESS("000003","禁用成功",103),
    /**
     * 启用失败
     */
    ENABLE_FAILED("100001", "启用失败", 201),
    /**
     * 禁用失败
     */
    DISABLE_FAILED("100002","禁用失败",202),
    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST("200001", "账号不存在", 301);

    /**
     * JSON返回的错误代码
     *
     * @since 1.0.0
     */
    private String infoCode;
    /**
     * JSON返回的错误信息
     *
     * @since 1.0.0
     */
    private String msg;
    /**
     * JSON返回的状态
     *
     * @since 1.0.0
     */
    private int status;


    private EnumErrorCode() {
    }

    private EnumErrorCode(String infoCode, String msg, int status) {
        this.infoCode = infoCode;
        this.msg = msg;
        this.status = status;
    }


    @Override
    public String getCode() {
        return this.infoCode;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public int getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + infoCode +
                ", msg='" + msg + '\'' +
                '}';
    }


}
