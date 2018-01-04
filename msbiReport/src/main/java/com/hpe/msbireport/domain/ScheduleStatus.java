package com.hpe.msbireport.domain;

public class ScheduleStatus {
    private Integer id;

    private Integer scheduleTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Integer scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}