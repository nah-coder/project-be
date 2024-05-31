package com.example.projectbe.projection;

public class TransportProjection {
    private String name;
    private Integer total;

    public TransportProjection(String name, Integer total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public Integer getTotal() {
        return total;
    }
}
