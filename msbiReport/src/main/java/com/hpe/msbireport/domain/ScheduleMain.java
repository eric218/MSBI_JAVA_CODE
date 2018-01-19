package com.hpe.msbireport.domain;

import java.util.Date;

public class ScheduleMain {
    private String message;

    private String serverName;

    private String domainName;

    private String scheduleName;

    private String nodeName;

    private Date insertDateTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }
}