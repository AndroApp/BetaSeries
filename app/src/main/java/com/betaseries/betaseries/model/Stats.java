package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by kevindejesusferreira on 16/04/15.
 */
public class Stats implements Serializable{

    int friends;
    int shows;
    int seasons;
    int episodes;
    int comments;
    double progress;
    int episodes_to_watch;
    int time_on_tv;
    int time_to_spend;
    int badges;

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getShows() {
        return shows;
    }

    public void setShows(int shows) {
        this.shows = shows;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public int getEpisodes_to_watch() {
        return episodes_to_watch;
    }

    public void setEpisodes_to_watch(int episodes_to_watch) {
        this.episodes_to_watch = episodes_to_watch;
    }

    public int getTime_on_tv() {
        return time_on_tv;
    }

    public void setTime_on_tv(int time_on_tv) {
        this.time_on_tv = time_on_tv;
    }

    public int getTime_to_spend() {
        return time_to_spend;
    }

    public void setTime_to_spend(int time_to_spend) {
        this.time_to_spend = time_to_spend;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
}
