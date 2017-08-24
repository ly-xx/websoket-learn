package com.lxxspace.demain;

/**
 * 接收服务器向浏览器发送的消息
 * @author lxx
 */

public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
