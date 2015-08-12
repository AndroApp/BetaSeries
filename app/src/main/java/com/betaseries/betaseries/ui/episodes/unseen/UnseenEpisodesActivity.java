package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseenEpisodesActivity extends AbstractActivity{

    public static final String SHOW = "SHOW";
    Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_unseen);
        ButterKnife.bind(this);

        this.show = (Show) getIntent().getExtras().getSerializable(SHOW);

        supportPostponeEnterTransition();
        setContentFragment(UnseenEpisodesFragment.newInstance(show));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportActionBar().setTitle(show.getTitle());
    }
}
