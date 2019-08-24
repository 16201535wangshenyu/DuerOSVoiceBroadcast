package com.yscyber.duer.constant;

/**
 * 槽位名.
 *
 * 
 */
public enum SlotEnum {

    /**
     *
     */
    SIMPLE_NAVIGATION_START_POINT("nchu_start_point"),
    SIMPLE_NAVIGATION_END_POINT("nchu_end_point"),
    VIEWSPOT_DESCRIPTION_VIEW_SPOT("nchu_view_spot");

    private String slot;

    SlotEnum(String slot) {
        this.slot = slot;
    }

    public String getSlot() {
        return slot;
    }
}
