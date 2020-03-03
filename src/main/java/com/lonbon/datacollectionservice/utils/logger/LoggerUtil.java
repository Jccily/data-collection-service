/**
 * Copyright (C),2007-2016, LonBon Technologies Co. Ltd. All Rights Reserved.
 */
/**
 * @Author:xielei
 * @Description:日志工具类
 * @Date: 15:29 2017/9/20
 * @Modified begin by
 * ----@Date:
 * ----@Description:
 * @Modified end
 */
package com.lonbon.datacollectionservice.utils.logger;

import org.slf4j.Logger;

/**
 * the logger util
 */
public class LoggerUtil {

    /**
     * Info.
     *
     * @param logger the logger
     * @param module the module
     * @param msg    the msg
     */
    public static void info(Logger logger, int module, String msg){
        logger.info(module + " normal " + msg);
    }

    /**
     * Error.
     *
     * @param logger the logger
     * @param module the module
     * @param msg    the msg
     */
    public static void error(Logger logger, int module, String msg){
        logger.error(module + " abnormal " + msg);
    }

    /**
     * Debug.
     *
     * @param logger the logger
     * @param module the module
     * @param msg    the msg
     */
    public static void debug(Logger logger, int module, String msg){
        logger.debug(module + " abnormal " + msg);
    }
}
