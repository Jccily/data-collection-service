package com.lonbon.datacollectionservice.serviceImpl;

import com.lonbon.datacollectionservice.dao.DeviceMapper;
import com.lonbon.datacollectionservice.model.locationSharing.Device;
import com.lonbon.datacollectionservice.service.IDeviceService;
import com.lonbon.datacollectionservice.utils.APIResultUtil;
import com.lonbon.datacollectionservice.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    static Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Override
    public HashMap<String,Object> getDevicePosition(String orgId, String mac, String deviceType, String imei){
        return APIResultUtil.searchResult(deviceMapper.getDevicePosition(orgId, mac, deviceType, imei));
    }

    @Override
    public HashMap<String, Object> saveDevicePosition(String orgId, List<Device> deviceList) {
        for (Device device :deviceList){
            if(!StringUtil.checkStr(device.getMac())){
                device.setMac("");
            }
            if(!StringUtil.checkStr(device.getImei())){
                device.setImei("");
            }
            if(!StringUtil.checkStr(device.getMac())&&!StringUtil.checkStr(device.getImei())){
                return APIResultUtil.noParameter("mac和imei都为空");
            }
            if(!StringUtil.checkStr(device.getDeviceType())){
                return APIResultUtil.noParameter("设备类型为空");
            }
            if(!StringUtil.checkStr(device.getPositionDesc())){
                device.setPositionDesc("");
            }
            if(!StringUtil.checkStr(device.getLatitude())){
                device.setLatitude("");
            }
            if(!StringUtil.checkStr(device.getLongitude())){
                device.setLongitude("");
            }
            String devicePositionId = StringUtil.getUUID();
            device.setDevicePositionId(devicePositionId);
            device.setOrgId(orgId);
            Integer count = deviceMapper.searchDevice(orgId, device.getMac(), device.getDeviceType(), device.getImei());
            if(0 != count){
                return APIResultUtil.error("该编号已存在");
            }
            logger.info("数据采集"+device.toString());
        }
        deviceMapper.saveDevicePosition(deviceList);
        return APIResultUtil.saveSuccess();
    }
}
