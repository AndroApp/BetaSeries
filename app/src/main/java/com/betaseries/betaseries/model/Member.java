package com.betaseries.betaseries.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kevindejesusferreira on 16/04/15.
 */
public class Member implements Serializable{

    int id;
    String login;
    int xp;
    String cached;
    String avatar;
    boolean in_account;
    Stats stats;
    Options options;

    ArrayList<Show> shows;

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getCached() {
        return cached;
    }

    public void setCached(String cached) {
        this.cached = cached;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isIn_account() {
        return in_account;
    }

    public void setIn_account(boolean in_account) {
        this.in_account = in_account;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", xp=" + xp +
                ", cached='" + cached + '\'' +
                ", avatar='" + avatar + '\'' +
                ", in_account=" + in_account +
                ", stats=" + stats +
                ", options=" + options +
                '}';
    }
}
