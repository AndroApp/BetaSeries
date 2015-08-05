package com.betaseries.betaseries;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.betaseries.betaseries.dagger.BetaSeriesComponent;
import com.betaseries.betaseries.dagger.ContextModule;
import com.betaseries.betaseries.dagger.DaggerBetaSeriesComponent;
import com.crashlytics.android.Crashlytics;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.CarpaccioLogger;

import java.lang.reflect.Field;

import io.fabric.sdk.android.Fabric;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Application extends MultiDexApplication {

    private static Application application;
    private BetaSeriesComponent betaSeriesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
        Application.application = this;
        CarpaccioLogger.ENABLE_LOG = true;

        this.betaSeriesComponent = DaggerBetaSeriesComponent.builder()
                .contextModule(ContextModule.with(getApplicationContext())) //in case we need a context
                .build();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);

    }

    public static Application app() {
        return application;
    }

    public BetaSeriesComponent component() {
        return betaSeriesComponent;
    }

}
