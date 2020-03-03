/**
 * Copyright (C),2007-2016, LonBon Technologies Co. Ltd. All Rights Reserved.
 *
 * @Author:wangjihao
 * @Description: 接口返回值
 * @Date: 15 :29  2017/9/13.
 * @Modified begin by xielei
 * ----@Date: 10:29 2018/01/10
 * ----@Description:修改中文log msg
 * @Modified end
 */
/**
 *
 * @Author:wangjihao
 * @Description: 接口返回值
 * @Date: 15 :29  2017/9/13.
 * @Modified begin by xielei
 * ----@Date: 10:29 2018/01/10
 * ----@Description:修改中文log msg
 * @Modified end
 */

package com.lonbon.datacollectionservice.utils;

import com.lonbon.datacollectionservice.utils.logger.LoggerUtil;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Api result util.
 */
public class APIResultUtil {

    private static HashMap<String, Object> mapEmpty = new HashMap<>();

    /**
     * Search result hash map.
     * 搜索接口返回
     * @param object the object
     * @return the hash map
     */
    public  static HashMap<String, Object> searchResult(Object object) {
        HashMap<String, Object> map = new HashMap<>();
        if (null == object) {
            map.put("status", "203");
            map.put("msg", "没有符合条件的数据！");
            map.put("body", mapEmpty);
        } else {
            map.put("status", "200");
            map.put("msg", "查询成功!");
            map.put("body", object);
        }
        return map;
    }

    public  static HashMap<String, Object> searchResultEn(Object object) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> listMap = new HashMap<>();
        if (null == object) {
            map.put("status", "203");
            map.put("msg", "no result");
            map.put("body", mapEmpty);
        } else {
            map.put("status", "200");
            map.put("msg", "success");
            listMap.put("data", object);
            map.put("body", listMap);
        }
        return map;
    }

    /**
     * Search result list hash map.
     *  搜索结果为list返回
     * @param list the list
     * @return the hash map
     */
    public static HashMap<String, Object> searchResultList(List list) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> listMap = new HashMap<>();
        if (null == list || list.isEmpty()) {
            map.put("status", "203");
            map.put("msg", "没有符合条件的数据！");
            map.put("body", mapEmpty);
        } else {
            map.put("status", "200");
            map.put("msg", "查询成功!");
            listMap.put("data", list);
            map.put("body", listMap);
        }
        return map;
    }

    public static HashMap<String, Object> searchList(List list) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> listMap = new HashMap<>();
        if (null == list || list.isEmpty()) {
            map.put("status", "203");
            map.put("msg", "没有符合条件的数据！");
            map.put("body", list);
        } else {
            map.put("status", "200");
            map.put("msg", "查询成功!");
            listMap.put("data", list);
            map.put("body", listMap);
        }
        return map;
    }

    public static HashMap<String, Object> exportSuccess(Object object) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "导出成功!");
        map.put("body", object);
        return map;
    }


    public static HashMap<String, Object> noData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "203");
        map.put("msg", "没有符合条件的数据！");
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Update success hash map.
     * 修改成功
     * @return the hash map
     */
    public static HashMap<String, Object> updateSuccess() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "修改成功！");
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String, Object> loginSuccess(HashMap<String, Object> hashMap) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "登录成功！");
        map.put("body", hashMap);
        return map;
    }

    /**
     * No parameter hash map.
     * 参数不全
     * @return the hash map
     */
    public static HashMap<String, Object> noParameter() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "301");
        map.put("msg", "参数不全！");
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String,Object> noParameter(Logger logger, Integer code){
        HashMap<String, Object> map = new HashMap<>();
        LoggerUtil.error(logger, code,"missing parameter");
        map.put("status", "301");
        map.put("msg", "参数不全！");
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String,Object> noParameter(String data, String loggerData, Logger logger, Integer code){
        HashMap<String, Object> map = new HashMap<>();
        LoggerUtil.error(logger, code,loggerData);
        map.put("status", "301");
        map.put("msg", data);
        map.put("body", mapEmpty);
        return map;
    }


    /**
     * No parameter hash map.
     *  没有参数
     * @param msg the msg
     * @return the hash map
     */
    public static HashMap<String, Object> noParameter(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "301");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Delete success hash map.
     * 删除成功
     * @return the hash map
     */
    public static HashMap<String, Object> deleteSuccess() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "删除成功！");
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String,Object> deleteSuccess(Logger logger, Integer code){
        HashMap<String, Object> map = new HashMap<>();
        LoggerUtil.info(logger, code,"delete success");
        map.put("status", "200");
        map.put("msg", "删除成功！");
        map.put("body", mapEmpty);
        return map;
    }
    /**
     * Delete error hash map.
     *
     * @param noDeleteIds the no delete ids
     * @return the hash map
     */
    public static HashMap<String, Object> deleteError(List<Map> noDeleteIds) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> listMap = new HashMap<>();
        listMap.clear();
        map.put("status", "201");
        if (noDeleteIds.size() > 0) {
            map.put("msg", "唯一标识均不存在");
            listMap.put("errorId", noDeleteIds);
            map.put("body", listMap);
        } else {
            map.put("msg", "删除失败");
            map.put("body", mapEmpty);
        }
        return map;
    }

    /**
     * Error delete parm hash map.
     *
     * @param noDeleteIds the no delete ids
     * @return the hash map
     */
    public static HashMap<String, Object> errorDeleteParm(List<Map> noDeleteIds) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> listMap = new HashMap<>();
        listMap.clear();
        map.put("status", "200");
        if (noDeleteIds.size() > 0) {
            map.put("msg", "删除成功，但下列唯一标识不存在");
            listMap.put("errorId", noDeleteIds);
            map.put("body", listMap);
        } else {
            map.put("msg", "删除成功");
            map.put("body", mapEmpty);
        }
        return map;
    }

    /**
     * Save success hash map.
     *  保存成功
     * @return the hash map
     */
    public static HashMap<String, Object> saveSuccess() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "添加成功！");
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Save success hash map.
     *  保存成功
     * @param list the list
     * @return the hash map
     */
    public static HashMap<String, Object> saveSuccess(Object list) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "添加成功！");
        map.put("body", list);
        return map;
    }

    /**
     * Error hash map.
     * 错误
     * @param msg the msg
     * @return the hash map
     */
    public static HashMap<String, Object> error(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "201");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }
    public static HashMap<String,Object> error(String msg, String logMsg, Logger logger, Integer code){
        HashMap<String, Object> map = new HashMap<>();
        LoggerUtil.error(logger, code,logMsg);
        map.put("status", "201");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Repeat hash map.
     * 数据重复
     * @return the hash map
     */
    public static HashMap<String, Object> repeat() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "300");
        map.put("msg", "数据重复");
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * No repeat hash map.
     * 数据不重复
     * @return the hash map
     */
    public static HashMap<String, Object> noRepeat() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "数据重复验证通过！");
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Success hash map.
     *  成功
     * @param msg the msg
     * @return the hash map
     */
    public static HashMap<String, Object> success(String msg, Object dataMap) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", msg);
        map.put("body", dataMap);
        return map;
    }

    /**
     * @param msg the msg
     * @return the hash map
     */
    public static HashMap<String, Object> refundResult(String msg, String refundStatus) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", refundStatus);
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }


    /**
     * Repeat hash map.
     *  重复
     * @param msg the msg
     * @return the hash map
     */
    public static HashMap<String, Object> repeat(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "300");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * Login fail hash map.
     * 未登录
     * @return the hash map
     */
    public static HashMap<String, Object> loginFail() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "401");
        map.put("msg", "未登录!");
        map.put("body", mapEmpty);
        return map;
    }


    /**
     * No privilege hash map.
     *  没有权限
     * @return the hash map
     */
    public static HashMap<String, Object> noPrivilege() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "402");
        map.put("msg", "您没有此操作的权限!");
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String, Object> noPrivilege(String data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "402");
        map.put("msg", data);
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String, Object> loginTimeOut() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "402");
        map.put("msg", "登录超时，请重新登录!");
        map.put("body", null);
        return map;
    }

    /**
     * illegal hash map.
     *  不合法
     * @return the hash map
     */
    public static HashMap<String, Object> illegal(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "302");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }

    /**
     * non Existent hash map.
     *  不存在
     * @return the hash map
     */
    public static HashMap<String, Object> nonExistent(String msg) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", "303");
        map.put("msg", msg);
        map.put("body", mapEmpty);
        return map;
    }

    public static HashMap<String, Object> customize(String status,String msg, Object dataMap) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("msg", msg);
        map.put("body", dataMap);
        return map;
    }
}
