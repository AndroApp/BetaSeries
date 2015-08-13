package com.betaseries.betaseries.back.episodes.unseen;

import android.content.Context;
import android.content.SharedPreferences;

import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 12/08/15.
 */
public class UnseenManager {

    SharedPreferences sharedPreferences;
    protected static final String PREFS = "UnseenManager";
    protected static final String PREFS_SHOWS = "PREFS_SHOWS";

    List<Show> unseens = new ArrayList<>();
    Gson gson;

    public UnseenManager(Context context, Gson gson) {
        sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        this.gson = gson;
    }

    public UnseenManager load() {
        String json = sharedPreferences.getString(PREFS_SHOWS, "[]");
        unseens = gson.fromJson(json, new TypeToken<List<Show>>() {
        }.getType());
        return this;
    }

    public List<Show> getUnseens() {
        return unseens;
    }

    public UnseenManager save() {
        sharedPreferences.edit()
                .putString(PREFS_SHOWS, gson.toJson(unseens))
                .apply();
        return this;
    }

    //public Show getShowUpdated(Show show) {
    //    return unseens.get(unseens.indexOf(show));
    //}

    //public void markSeen(Show show, Episode episode) {
    //    getShowUpdated(show).getUnseen().remove(episode);
    //    save();
    //}

    public UnseenManager replace(List<Show> shows) {
        unseens.clear();
        unseens.addAll(shows);
        return this;
    }

}
