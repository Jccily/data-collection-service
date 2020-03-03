package com.lonbon.datacollectionservice.service;

import com.lonbon.datacollectionservice.model.locationSharing.Device;

import java.util.HashMap;
import java.util.List;

public interface IDeviceService {
    HashMap<String, Object> getDevicePosition(String orgId, String mac, String deviceType, String imei);

    HashMap<String, Object> saveDevicePosition(String orgId, List<Device> deviceList );
}
