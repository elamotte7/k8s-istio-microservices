package com.sedona.test.microprofile.a.rest.model;

import java.util.Date;

public class ServiceData {

    private Date time = new Date();
    private String source;
    private String message;
    private ServiceData data;
    private long callCount;
    private long tries;
    private boolean fallback = false;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCallCount() {
        return callCount;
    }

    public void setCallCount(long callCount) {
        this.callCount = callCount;
    }

    public long getTries() {
        return tries;
    }

    public void setTries(long tries) {
        this.tries = tries;
    }

    public boolean isFallback() {
        return fallback;
    }

    public void setFallback(boolean fallback) {
        this.fallback = fallback;
    }

    public ServiceData getData() {
        return data;
    }

    public void setData(ServiceData data) {
        this.data = data;
    }

}
