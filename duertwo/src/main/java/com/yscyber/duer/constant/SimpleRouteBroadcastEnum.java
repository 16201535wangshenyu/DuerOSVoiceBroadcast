package com.yscyber.duer.constant;

/**
 * 简单寻路功能相关语音播报.
 *
 * 
 */
public enum SimpleRouteBroadcastEnum {

    /**
     *
     */
    REPEAT_POINT("您提供的地点是同一地点！"),
    NON_ROUTE("没有查到相关路径！"),
    ASK_START_POINT("请问您现在在什么位置？"),
    ASK_END_POINT("请问您要到什么地方？");

    private String tip;

    SimpleRouteBroadcastEnum(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

}
