package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.betaseries.betaseries.Application;
import com.betaseries.betaseries.R;
import com.betaseries.betaseries.authentification.AuthentificationManager;
import com.betaseries.betaseries.back.UserManager;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 02/08/15.
 */
public class AbstractActivity extends AppCompatActivity {

    @Inject
    BetaSeriesAPI betaSeriesAPI;

    @Inject
    AuthentificationManager authentificationManager;

    @Inject
    UserManager userManager;

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.app().component().inject(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setTitleTextColor(0xFFFFFFFF);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setContentFragment(AbstractFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
