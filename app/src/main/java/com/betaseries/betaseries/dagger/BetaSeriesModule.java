package com.betaseries.betaseries.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.betaseries.betaseries.authentification.AuthentificationManager;
import com.betaseries.betaseries.back.UserManager;
import com.betaseries.betaseries.back.episodes.unseen.UnseenManager;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;
import com.betaseries.betaseries.BuildConfig;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by florentchampigny on 30/07/15.
 */
@Singleton
@Module
public class BetaSeriesModule {

    @Singleton
    @Provides
    public EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public UnseenManager provideUnseenManager(Gson gson, Context context) {
        return new UnseenManager(context,gson);
    }

    @Singleton
    @Provides
    public UserManager provideUserManager(Gson gson, Context context) {
        return new UserManager(context,gson);
    }

    @Singleton
    @Provides
    public BetaSeriesAPI provideBetaSeriesApi(AuthentificationManager authentificationManager) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_BETASERIES)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("Retrofit"))
                .setRequestInterceptor(request -> {
                    request.addHeader("X-BetaSeries-Key", BuildConfig.API_KEY);
                    request.addHeader("X-BetaSeries-Version", "2.4");
                    request.addHeader("Accept", "application/json");

                    String userToken = authentificationManager.getToken();
                    if (userToken != null)
                        request.addHeader("X-BetaSeries-Token", userToken);
                })
                .build()
                .create(BetaSeriesAPI.class);
    }

}
