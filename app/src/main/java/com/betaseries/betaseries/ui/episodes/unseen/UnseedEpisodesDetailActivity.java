package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseedEpisodesDetailActivity extends AbstractActivity{

    public static final String SHOW = "SHOW";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_unseen);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(0xFFFFFFFF);

        Show show = (Show) getIntent().getExtras().getSerializable(SHOW);

        supportPostponeEnterTransition();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,UnseenEpisodesDetailFragment.newInstance(show))
                .commit();
    }
}
