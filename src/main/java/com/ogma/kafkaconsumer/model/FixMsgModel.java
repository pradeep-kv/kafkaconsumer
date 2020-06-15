package com.ogma.kafkaconsumer.model;

import org.springframework.stereotype.Component;

@Component
public class FixMsgModel {
    private String fixMsgName;
    private String fixMsgType;

    public String getFixMsgName() {
        return fixMsgName;
    }

    public void setFixMsgName(String fixMsgName) {
        this.fixMsgName = fixMsgName;
    }

    public String getFixMsgType() {
        return fixMsgType;
    }

    public void setFixMsgType(String fixMsgType) {
        this.fixMsgType = fixMsgType;
    }

    @Override
    public String toString() {
        return "FixMsgModel{" +
                "fixMsgName='" + fixMsgName + '\'' +
                ", fixMsgType='" + fixMsgType + '\'' +
                '}';
    }
}

