package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.betaseries.betaseries.Application;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;

import javax.inject.Inject;

/**
 * Created by florentchampigny on 02/08/15.
 */
public class AbstractFragment extends Fragment {

    @Inject
    BetaSeriesAPI betaSeriesAPI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.app().component().inject(this);
    }
}
