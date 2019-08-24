package com.yscyber.duer.constant;



public enum OtherEnum {

    /**
     *
     */
    OPEN_SPEECH("您好，我叫小度，很高兴为您服务。我可以为您提供两种类型的服务哦，请问您想了解景区路线、景点介绍呢？您可以回答我景区路线、景点介绍。"),
    CLOSE_SPEECH("感谢您的使用！"),
    CONTINUE_SPEECH("请问您还需要了解什么，我将继续为您提供服务！");

    private String language;

    OtherEnum(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
