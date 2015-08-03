package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class SeasonDetail implements Serializable{
    private Integer number;
    private Integer episodes;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
}
