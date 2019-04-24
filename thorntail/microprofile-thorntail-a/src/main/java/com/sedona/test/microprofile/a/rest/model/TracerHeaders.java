package com.sedona.test.microprofile.a.rest.model;

public class TracerHeaders {
    public String user;
    public String xreq;
    public String xtraceid;
    public String xspanid;
    public String xparentspanid;
    public String xsampled;
    public String xflags;
    public String xotspan;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TracerHeaders{");
        sb.append("user='").append(user).append('\'');
        sb.append(", xreq='").append(xreq).append('\'');
        sb.append(", xtraceid='").append(xtraceid).append('\'');
        sb.append(", xspanid='").append(xspanid).append('\'');
        sb.append(", xparentspanid='").append(xparentspanid).append('\'');
        sb.append(", xsampled='").append(xsampled).append('\'');
        sb.append(", xflags='").append(xflags).append('\'');
        sb.append(", xotspan='").append(xotspan).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
