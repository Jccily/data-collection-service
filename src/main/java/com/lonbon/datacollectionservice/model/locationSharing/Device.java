package com.lonbon.datacollectionservice.model.locationSharing;

import java.util.List;

public class Device {

    private String devicePositionId;
    private String mac;
    private String imei;
    private String positionDesc;
    private String longitude;
    private String latitude;
    private String deviceType;
    private String orgId;
    private String createTime;
    private String updateTime;

    public String getDevicePositionId() {
        return devicePositionId;
    }

    public void setDevicePositionId(String devicePositionId) {
        this.devicePositionId = devicePositionId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "devicePositionId='" + devicePositionId + '\'' +
                ", mac='" + mac + '\'' +
                ", imei='" + imei + '\'' +
                ", positionDesc='" + positionDesc + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", orgId='" + orgId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", update_time='" + updateTime + '\'' +
                '}';
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
