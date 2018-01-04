package com.hpe.msbireport.domain;

public class LookupSummary {
    private Integer id;

    private Integer monthIndicator;

    private Integer lookupId;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonthIndicator() {
        return monthIndicator;
    }

    public void setMonthIndicator(Integer monthIndicator) {
        this.monthIndicator = monthIndicator;
    }

    public Integer getLookupId() {
        return lookupId;
    }

    public void setLookupId(Integer lookupId) {
        this.lookupId = lookupId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}