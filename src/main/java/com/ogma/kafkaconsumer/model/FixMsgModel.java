package com.ogma.kafkaconsumer.model;

import org.springframework.stereotype.Component;

@Component
public class FixMsgModel {
    private String fixMsgName;
    private String fixMsgType;
    private Long currentDate;

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

    public Long getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Long currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "FixMsgModel{" +
                "fixMsgName='" + fixMsgName + '\'' +
                ", fixMsgType='" + fixMsgType + '\'' +
                '}';
    }
}

