package com.betaseries.betaseries.authentification.webservice;

import com.betaseries.betaseries.authentification.model.Authentification;

import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface AuthentificationService {

    @POST("/members/auth")
    Observable<Authentification> authentifier(@Query("login") String login, @Query("password") String passwordMD5);
}
