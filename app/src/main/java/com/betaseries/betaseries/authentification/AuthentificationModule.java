package com.betaseries.betaseries.authentification;

import android.content.Context;

import com.betaseries.betaseries.BuildConfig;
import com.betaseries.betaseries.authentification.webservice.AuthentificationService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by florentchampigny on 02/08/15.
 */
@Module
public class AuthentificationModule {

    @Singleton
    @Provides
    public AuthentificationService provideAuthentificationService(){
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_BETASERIES)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("retrofit"))
                .setRequestInterceptor(request -> {
                    request.addHeader("X-BetaSeries-Key", BuildConfig.API_KEY);
                    request.addHeader("X-BetaSeries-Version", "2.4");
                    request.addHeader("Accept", "application/json");
                })
                .build()
                .create(AuthentificationService.class);
    }

    @Singleton
    @Provides
    public AuthentificationManager provideAuthentificationManager(AuthentificationService authentificationService, Context context){
        return new AuthentificationManager(authentificationService, context);
    }

}
