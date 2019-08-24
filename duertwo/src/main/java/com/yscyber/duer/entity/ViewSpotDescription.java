package com.yscyber.duer.entity;

/**
 *
 */
public class ViewSpotDescription {

    private String descriptionId;
    private Integer descriptionViewSpotId;
    private String descriptionViewSpotName;
    private String descriptionDescription;

    public String getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Integer getDescriptionViewSpotId() {
        return descriptionViewSpotId;
    }

    public void setDescriptionViewSpotId(Integer descriptionViewSpotId) {
        this.descriptionViewSpotId = descriptionViewSpotId;
    }

    public String getDescriptionViewSpotName() {
        return descriptionViewSpotName;
    }

    public void setDescriptionViewSpotName(String descriptionViewSpotName) {
        this.descriptionViewSpotName = descriptionViewSpotName;
    }

    public String getDescriptionDescription() {
        return descriptionDescription;
    }

    public void setDescriptionDescription(String descriptionDescription) {
        this.descriptionDescription = descriptionDescription;
    }

    @Override
    public String toString() {
        return "ViewSpotDescription{" +
                "descriptionId='" + descriptionId + '\'' +
                ", descriptionViewSpotId=" + descriptionViewSpotId +
                ", descriptionViewSpotName='" + descriptionViewSpotName + '\'' +
                ", descriptionDescription='" + descriptionDescription + '\'' +
                '}';
    }

}
