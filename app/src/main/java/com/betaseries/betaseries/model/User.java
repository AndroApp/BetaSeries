package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class User implements Serializable{
    private boolean archived;
    private boolean favorited;
    private boolean seen;

    private String remaining;
    private String status;
    private String last;
    private Object tags;

    public boolean isArchived() {
        return archived;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }
}
