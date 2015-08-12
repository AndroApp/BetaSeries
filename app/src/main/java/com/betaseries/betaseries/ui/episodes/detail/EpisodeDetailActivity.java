package com.betaseries.betaseries.ui.episodes.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractActivity;

import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 12/08/15.
 */
public class EpisodeDetailActivity extends AbstractActivity {

    public static final String EPISODE = "EPISODE";
    Episode episode;

    public static final String SHOW = "SHOW";
    Show show;

    public static Intent newInstance(Context context, Show show, Episode episode) {
        Intent intent = new Intent(context, EpisodeDetailActivity.class);
        intent.putExtra(SHOW, show);
        intent.putExtra(EPISODE, episode);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);
        ButterKnife.bind(this);

        this.episode = (Episode) getIntent().getExtras().getSerializable(EPISODE);
        this.show = (Show) getIntent().getExtras().getSerializable(SHOW);

        supportPostponeEnterTransition();
        setContentFragment(EpisodeDetailFragment.newInstance(show, episode));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportActionBar().setTitle("");
    }

}
