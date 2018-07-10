package com.baizhi.cmfz.entity;

public class City {
    private String name;
    private Integer value;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public City(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
