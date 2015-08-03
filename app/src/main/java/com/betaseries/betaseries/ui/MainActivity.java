package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.betaseries.betaseries.BuildConfig;
import com.betaseries.betaseries.R;
import com.betaseries.betaseries.authentification.model.Authentification;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        authentificationManager.authentifier(BuildConfig.BETASERIES_USER, BuildConfig.BETASERIES_PASSWORD)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> {
                    Toast.makeText(MainActivity.this, "Authentification error", Toast.LENGTH_SHORT).show();
                    return null;
                })
                .subscribe(authentification -> {
                    Toast.makeText(MainActivity.this, "Authentifié ! " + authentification.toString(), Toast.LENGTH_SHORT).show();
                });
    }

}

