package com.hpe.msbireport.domain;

public class Lookup {
    private Integer id;

    private String title;

    private String code;

    private String coulor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCoulor() {
        return coulor;
    }

    public void setCoulor(String coulor) {
        this.coulor = coulor == null ? null : coulor.trim();
    }
}