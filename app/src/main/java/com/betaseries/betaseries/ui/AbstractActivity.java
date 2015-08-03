package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.betaseries.betaseries.Application;
import com.betaseries.betaseries.authentification.AuthentificationManager;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;

import javax.inject.Inject;

/**
 * Created by florentchampigny on 02/08/15.
 */
public class AbstractActivity extends AppCompatActivity {

    @Inject
    BetaSeriesAPI betaSeriesAPI;

    @Inject
    AuthentificationManager authentificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.app().component().inject(this);
    }
}
