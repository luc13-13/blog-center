package com.lc.blog.center.binding;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/23 16:03
 * @Version : 1.0
 */
public class BaseMsg<T extends Object> implements  Serializable, Message {
    private Integer id;
    private String msgType;
    private T body;


    public BaseMsg(T body) {
        this.body = body;
    }

    public BaseMsg(Integer id, T body) {
        this.id = id;
        this.body = body;
    }

    public BaseMsg(Integer id, String msgType, T body) {
        this.id = id;
        this.msgType = msgType;
        this.body = body;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public T getPayload() {
        return this.body;
    }

    @Override
    public MessageHeaders getHeaders() {
        Map<String, Object> headers =  new HashMap();
        headers.put("msgType", msgType);
        return new MessageHeaders(headers);
    }

    @Override
    public String toString() {
        return "BaseMsg{" +
                "id=" + id +
                ", msgType='" + msgType + '\'' +
                ", body=" + body +
                '}';
    }
}
