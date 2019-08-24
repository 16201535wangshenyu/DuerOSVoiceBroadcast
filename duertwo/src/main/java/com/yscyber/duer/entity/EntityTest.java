package com.yscyber.duer.entity;

public class EntityTest {

    private Integer colA;
    private String colB;
    private String colC;

    public Integer getColA() {
        return colA;
    }

    public void setColA(Integer colA) {
        this.colA = colA;
    }

    public String getColB() {
        return colB;
    }

    public void setColB(String colB) {
        this.colB = colB;
    }

    public String getColC() {
        return colC;
    }

    public void setColC(String colC) {
        this.colC = colC;
    }

    @Override
    public String toString() {
        return "EntityTest{" +
                "colA=" + colA +
                ", colB='" + colB + '\'' +
                ", colC='" + colC + '\'' +
                '}';
    }

}
