package hxz.www.commonbase.model;

import java.io.Serializable;

import hxz.www.commonbase.util.GsonUtil;

/**
 * @Author :rickBei
 * @Date :2019/11/9 10:20
 * @Descripe: From bug to bugs
 **/

public class BaseUrlModel implements Serializable {
    /**
     * id : 1
     * customerId : 1
     * serviceUrl : http://120.79.56.152:9010/lfcp-app/
     * resourceUrl : http://120.79.56.152:8010
     * licenseCode : 贵州融通测试
     * licenseCount : 100
     * licenseStart : 2019-11-07
     * licenseEnd : 2099-11-08
     * signDate : 2019-11-08
     */

    private int id;
    private int customerId;
    private String serviceUrl;
    private String resourceUrl;
    private String licenseCode;
    private int licenseCount;
    private String licenseStart;
    private String licenseEnd;
    private String signDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public int getLicenseCount() {
        return licenseCount;
    }

    public void setLicenseCount(int licenseCount) {
        this.licenseCount = licenseCount;
    }

    public String getLicenseStart() {
        return licenseStart;
    }

    public void setLicenseStart(String licenseStart) {
        this.licenseStart = licenseStart;
    }

    public String getLicenseEnd() {
        return licenseEnd;
    }

    public void setLicenseEnd(String licenseEnd) {
        this.licenseEnd = licenseEnd;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }


    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}

