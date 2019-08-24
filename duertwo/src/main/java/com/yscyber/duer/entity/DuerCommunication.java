package com.yscyber.duer.entity;

/**
 * 
 */
public class DuerCommunication {

    private String broadcast;
    private String key = "NONE";

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "DuerCommunication{" +
                "broadcast='" + broadcast + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

}
