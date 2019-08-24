package com.yscyber.duer.constant;


public enum IntentEnum {

    /**
     * 简单寻路意图.
     */
    SIMPLE_NAVIGATION("nchu_simple_navigation"),
    VIEWSPOT_DESCRIPTION("nchu_viewspot_description"),
    DIFFICULT_NAVIGATION("nchu_difficult_navigation");

    private String intent;

    IntentEnum(String intent) {
        this.intent = intent;
    }

    public String getIntent() {
        return intent;
    }

}

