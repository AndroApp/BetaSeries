package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class Note implements Serializable{
    private String total;
    private String mean;
    private Integer user;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMean() {
        return mean;
    }
    public String getMeanFormatted() {
        return mean != null ?
                String.format("%.01f", Float.parseFloat(mean)).replace(".", ",") :
                "5";
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
