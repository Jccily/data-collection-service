package com.lonbon.datacollectionservice.dao;

import com.lonbon.datacollectionservice.model.locationSharing.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {
    List<Device> getDevicePosition(@Param("orgId")String orgId, @Param("mac")String mac, @Param("deviceType")String deviceType, @Param("imei")String imei);

    Integer searchDevice(@Param("orgId")String orgId, @Param("mac")String mac, @Param("deviceType")String deviceType, @Param("imei")String imei);

    void saveDevicePosition(@Param("list")List<Device> device);
}
