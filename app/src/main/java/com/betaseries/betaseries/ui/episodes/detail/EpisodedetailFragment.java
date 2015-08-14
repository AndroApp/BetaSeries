package com.betaseries.betaseries.ui.episodes.detail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class EpisodeDetailFragment extends AbstractFragment {

    public static final String EPISODE = "EPISODE";
    public static final String SHOW = "SHOW";

    public static EpisodeDetailFragment newInstance(Show show, Episode episode) {
        EpisodeDetailFragment fragment = new EpisodeDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(SHOW, show);
        args.putSerializable(EPISODE, episode);
        fragment.setArguments(args);
        return fragment;
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    Show show;
    Episode episode;

    @Bind(R.id.play)
    View play;

    @Bind(R.id.ratingUserStar)
    RatingBar ratingUserStar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show = (Show) getArguments().getSerializable(SHOW);
        episode = (Episode) getArguments().getSerializable(EPISODE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_episode_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if (episode.getYoutubeId() == null)
            play.setVisibility(View.GONE);

        carpaccio.mapObject("show", show);
        carpaccio.mapObject("episode", episode);
        carpaccio.mapObject("user", userManager.getUser());

        ratingUserStar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                betaSeriesAPI.episodeMarquerVu(episode.getId())
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .onErrorReturn(null)
                        .subscribe(vu ->
                                {
                                    //unseenManager.markSeen(show, episode);
                                    betaSeriesAPI.episodeNoter(episode.getId(), episode.getNoteUser())
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .onErrorReturn(null)
                                            .subscribe(o2 ->
                                                            ratingUserStar.animate().alpha(0).setDuration(600).setListener(new AnimatorListenerAdapter() {
                                                                @Override
                                                                public void onAnimationEnd(Animator animation) {
                                                                    ratingUserStar.setVisibility(View.GONE);
                                                                }
                                                            }).start()
                                            );
                                }
                        );
            }
        });
    }

    @OnClick(R.id.bannerVideo)
    public void clickedOnVideo() {
        if (episode.getYoutubeId() != null) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + episode.getYoutubeId())));
        }
    }
}
