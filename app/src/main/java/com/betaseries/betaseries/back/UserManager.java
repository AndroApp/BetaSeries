package com.betaseries.betaseries.back;

import android.content.Context;
import android.content.SharedPreferences;

import com.betaseries.betaseries.model.Member;
import com.betaseries.betaseries.model.User;
import com.google.gson.Gson;

/**
 * Created by florentchampigny on 13/08/15.
 */
public class UserManager {

    SharedPreferences sharedPreferences;
    protected static final String PREFS = "UserManager";
    protected static final String PREFS_USER = "PREFS_USER";

    Gson gson;

    Member user;

    public UserManager(Context context, Gson gson) {
        sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        this.gson = gson;
    }

    public UserManager load() {
        String json = sharedPreferences.getString(PREFS_USER, null);
        if (json != null)
            user = gson.fromJson(json, Member.class);
        return this;
    }

    public UserManager save() {
        if (user != null)
            sharedPreferences.edit()
                    .putString(PREFS_USER, gson.toJson(user))
                    .apply();
        return this;
    }

    public boolean hasUser(){
        return getUser() != null;
    }

    public Member getUser() {
        if(user == null)
            load();
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
        save();
    }
}
