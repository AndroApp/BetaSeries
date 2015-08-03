package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by kevindejesusferreira on 16/04/15.
 */
public class Options implements Serializable{


    boolean downloaded;
    boolean notation;
    boolean timelag;
    boolean global;
    String friendship;


    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public boolean isNotation() {
        return notation;
    }

    public void setNotation(boolean notation) {
        this.notation = notation;
    }

    public boolean isTimelag() {
        return timelag;
    }

    public void setTimelag(boolean timelag) {
        this.timelag = timelag;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String getFriendship() {
        return friendship;
    }

    public void setFriendship(String friendship) {
        this.friendship = friendship;
    }
}
