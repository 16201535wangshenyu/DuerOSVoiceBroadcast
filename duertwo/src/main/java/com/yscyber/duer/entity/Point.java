package com.yscyber.duer.entity;

/**
 * 景点.
 *
 */
public class Point {

    private Integer pointId;
    private String pointName;


    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointKey=" + pointId +
                ", pointName='" + pointName + '\'' +
                '}';
    }

}
