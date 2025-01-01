package com.codecrafters.tvpss.model;

import java.util.List;

public class Dashboard {
    private String type;
    private List<Object> data;

    // Constructor
    public Dashboard(String type, List<Object> data) {
        this.type = type;
        this.data = data;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
