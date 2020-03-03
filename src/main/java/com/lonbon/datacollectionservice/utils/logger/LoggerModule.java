/**
 * Copyright (C),2007-2016, LonBon Technologies Co. Ltd. All Rights Reserved.
 */
/**
 *
 * @Author:wangjihao
 * @Description: 日志模块枚举类
 * @Date: 10:20   2018/1/4.
 * @Modified begin by xielei
 * ----@Date: 10:29 2018/1/4.
 * ----@Description:添加公共模块
 * @Modified end
 */
package com.lonbon.datacollectionservice.utils.logger;

import java.util.Objects;

/**
 * The enum Logger module.
 */
public enum LoggerModule {

    /**
     * Common logger module
     */
    COMMON(0,"COMMON"),

    /**
     * Login logger module.
     */
//登录认证模块
    LOGIN(1,"LOGIN"),

    /**
     * User logger module.
     */
//用户模块
    USER(2,"USER"),
    /**
     * 老人
     * Careobject logger module.
     */
    CARE_OBJECT(3,"CARE_OBJECT"),
    /**
     * Department logger module.
     */
//信息分享模块
    SHARE_INFO(4,"SHARE_INFO"),
    /**
     * 记录查询
     * Record search logger module.
     */
    RECORD_SEARCH(5,"RECORD_SEARCH"),
    /**
     * 商城
     * Store logger module.
     */
    STORE(6,"STORE"),
    /**
     * 续费
     * Renew logger module.
     */
    RENEW(7,"RENEW"),
    /**
     * 版本关于
     * Version logger module.
     */
    VERSION(7,"VERSION");



    private Integer code;
    private String description;



    LoggerModule(int code, String description) {
        this.code=code;
        this.description=description;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get module desc string.
     * 根据枚举Code返回枚举描述
     *
     * @param code the code
     * @return the string
     */
    public static String getModuleDesc(Integer code){
        for(LoggerModule module: LoggerModule.values()){
            if(Objects.equals(code, module.getCode())){
                return module.getDescription();
            }
        }
        return null;
    }
}
