package com.yscyber.duer.constant;

/**
 *
 */
public enum ViewspotDescriptionBroadcastEnum {

    /**
     *
     */
    NON_DESCRIPTION("没有查到相关内容！"),
    ASK_VIEW_SPOT("请问您想让我为你介绍什么地方？");

    private String tip;

    ViewspotDescriptionBroadcastEnum(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

}
