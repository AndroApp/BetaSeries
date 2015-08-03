package com.betaseries.betaseries.authentification;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.betaseries.betaseries.authentification.model.Authentification;
import com.betaseries.betaseries.authentification.webservice.AuthentificationService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by florentchampigny on 11/04/15.
 */
public class AuthentificationManager {

    private static final String PREFS_AUTH = "PREFS_AUTH";

    private static final String TOKEN = "TOKEN";
    private static final String NOM_UTILISATEUR = "NOM_UTILISATEUR";

    protected SharedPreferences sharedPreferences;
    protected AuthentificationService authentificationService;

    public AuthentificationManager(AuthentificationService authentificationService, Context context) {
        this.authentificationService = authentificationService;
        sharedPreferences = context.getSharedPreferences(PREFS_AUTH, Context.MODE_PRIVATE);
    }

    public void setToken(String token) {
        sharedPreferences.edit().putString(TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public String getNomUtilisateur() {
        return sharedPreferences.getString(NOM_UTILISATEUR, null);
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        sharedPreferences.edit().putString(NOM_UTILISATEUR, nomUtilisateur).apply();
    }


    public boolean isAuthentified() {
        return getToken() != null;
    }

    public Observable<Authentification> authentifier(String login, String password) {
        return Observable.create(subscriber ->
                authentificationService.authentifier(login, toMd5(password))
                        .doOnError(subscriber::onError)
                        .onErrorReturn(null)
                        .subscribe(authentification -> {
                            setToken(authentification.getToken());
                            setNomUtilisateur(login);
                            subscriber.onNext(authentification);

                            // after sending all values we complete the sequence
                            subscriber.onCompleted();
                        })
        );
    }

    private String toMd5(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(string.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String md5 = number.toString(16);

            while (md5.length() < 32)
                md5 = "0" + md5;

            return md5;
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", e.getLocalizedMessage());
            return null;
        }
    }

}
