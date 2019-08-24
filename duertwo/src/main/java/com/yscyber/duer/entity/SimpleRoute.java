package com.yscyber.duer.entity;

/**
 * 
 */
public class SimpleRoute {

    private String routeId;
    private Integer routeStartPointId;
    private String routeStartPointName;
    private Integer routeEndPointId;
    private String routeEndPointName;
    private String routeDescription;
    private String routeKey;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteStartPointId() {
        return routeStartPointId;
    }

    public void setRouteStartPointId(Integer routeStartPointId) {
        this.routeStartPointId = routeStartPointId;
    }

    public String getRouteStartPointName() {
        return routeStartPointName;
    }

    public void setRouteStartPointName(String routeStartPointName) {
        this.routeStartPointName = routeStartPointName;
    }

    public Integer getRouteEndPointId() {
        return routeEndPointId;
    }

    public void setRouteEndPointId(Integer routeEndPointId) {
        this.routeEndPointId = routeEndPointId;
    }

    public String getRouteEndPointName() {
        return routeEndPointName;
    }

    public void setRouteEndPointName(String routeEndPointName) {
        this.routeEndPointName = routeEndPointName;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    @Override
    public String toString() {
        return "SimpleRoute{" +
                "routeId='" + routeId + '\'' +
                ", routeStartPointId='" + routeStartPointId + '\'' +
                ", routeStartPointName='" + routeStartPointName + '\'' +
                ", routeEndPointId='" + routeEndPointId + '\'' +
                ", routeEndPointName='" + routeEndPointName + '\'' +
                ", routeDescription='" + routeDescription + '\'' +
                ", routeKey='" + routeKey + '\'' +
                '}';
    }

}
