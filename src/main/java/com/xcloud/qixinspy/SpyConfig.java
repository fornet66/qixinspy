package com.xcloud.qixinspy;

public class SpyConfig {

    private String userAgent;
    private String driverPath;
    private String binPath;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBinPath() {
        return binPath;
    }

    public void setBinPath(String binPath) {
        this.binPath = binPath;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

}
