package com.lonbon.datacollectionservice.controller.locationSharing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lonbon.datacollectionservice.model.locationSharing.Device;
import com.lonbon.datacollectionservice.service.IDeviceService;
import com.lonbon.datacollectionservice.utils.APIResultUtil;
import com.lonbon.datacollectionservice.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0/data/device/")
public class DeviceController {
    @Autowired
    private IDeviceService positionService;

    @RequestMapping(value = "position",method = RequestMethod.GET)
    public HashMap<String,Object> getDevicePosition(HttpServletRequest request){
        String orgId = request.getParameter("orgId");
        String mac = request.getParameter("mac");
        String deviceType = request.getParameter("deviceType");
        String imei = request.getParameter("imei");
//        if(!StringUtil.checkStr(orgId)){
//            return APIResultUtil.noParameter("缺少机构ID");
//        }
        if (!StringUtil.checkStr(mac)&&!StringUtil.checkStr(imei)) {
            return APIResultUtil.noParameter("缺少设备地址");
        }
        if (!StringUtil.checkStr(deviceType)) {
            return APIResultUtil.noParameter("缺少设备类型");
        }
        return positionService.getDevicePosition(orgId, mac, deviceType, imei);
    }

    @RequestMapping(value = "position",method = RequestMethod.POST)
    public HashMap<String,Object> saveDevicePosition(HttpServletRequest request){
        String orgId = request.getParameter("orgId");
         if(!StringUtil.checkStr(orgId)){
            return APIResultUtil.noParameter("缺少机构ID");
        }
        String deviceData = request.getParameter("device");
        List<Device> deviceList;
        try {
            deviceList=   StringUtil.jsonToList(deviceData,Device.class);
            //device = JSON.parseObject(deviceData).toJavaObject(Device.class);
        } catch (JSONException e) {
            return APIResultUtil.noParameter("参数格式错误");
        }
        if(null==deviceList||deviceList.isEmpty()){
            return  APIResultUtil.noParameter("请求参数集合为空");
        }
        return positionService.saveDevicePosition(orgId, deviceList);
    }

}
