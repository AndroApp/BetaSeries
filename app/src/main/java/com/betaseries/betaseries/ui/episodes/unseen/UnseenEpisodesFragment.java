package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.controllers.EventImageViewController;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.ui.episodes.detail.EpisodeDetailActivity;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.controllers.adapter.CarpaccioRecyclerViewAdapter;
import com.github.florent37.carpaccio.controllers.adapter.Holder;
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListener;
import com.github.florent37.carpaccio.controllers.adapter.OnItemSwipedListener;
import com.github.florent37.carpaccio.controllers.adapter.RecyclerViewCallbackAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseenEpisodesFragment extends AbstractFragment {

    public static final String SHOW = "SHOW";

    public static UnseenEpisodesFragment newInstance(Show show) {
        UnseenEpisodesFragment fragment = new UnseenEpisodesFragment();
        Bundle args = new Bundle();
        args.putSerializable(SHOW, show);
        fragment.setArguments(args);
        return fragment;
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    Show show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show = (Show) getArguments().getSerializable(SHOW);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_episodes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onStart() {
        super.onStart();

        carpaccio.mapList("episode", show.getUnseen());
        carpaccio.mapObject("show", this.show);

        {
            CarpaccioRecyclerViewAdapter adapter = carpaccio.getAdapter("episode");
            adapter.setRecyclerViewCallback(new RecyclerViewCallbackAdapter() {

                @Override
                public Holder onCreateViewHolder(View view, int viewType) {
                    return new EpisodeViewHolder(view);
                }

                @Override
                public void onBind(Object object, Holder holder, int position) {
                    super.onBind(object, holder, position);
                    EpisodeViewHolder.class.cast(holder).setCardVisible(object);
                }
            });
        }
        carpaccio.onItemSwiped("episode", new OnItemSwipedListener<Episode>() {
            @Override
            public boolean canSwipe(int i, Episode episode) {
                return !episode.isSwiped() || episode.isVoted();
            }

            @Override
            public boolean onItemSwiped(Episode episode, int i, Holder holder, RecyclerView.Adapter adapter) {
                if (!episode.isSwiped()) {
                    episode.setSwiped(true);
                    return false;
                } else {
                    betaSeriesAPI.episodeMarquerVu(episode.getId())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(vu -> {
                                        EpisodeViewHolder.class.cast(holder).reinitStars();
                                        betaSeriesAPI.episodeNoter(episode.getId(), episode.getNoteUser()).subscribe(o2 -> {
                                        });
                                    }
                            );
                    return true;
                }
            }
        });
        carpaccio.onItemClick("episode", new OnItemClickListener<Episode>() {
            @Override
            public boolean isClickable(Episode episode, int i, Holder holder) {
                return !episode.isSwiped();
            }

            @Override
            public void onItemClick(Episode episode, int i, Holder holder) {
                if (!episode.isSwiped()) {
                    ActivityCompat.startActivity(getActivity(), EpisodeDetailActivity.newInstance(getActivity(), show, episode), null);
                }
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        eventBus.unregister(this);
    }

    public void onEvent(EventImageViewController.EventImage eventImage) {
        if (eventImage.url.equals(show.getUrlShow()))
            getActivity().supportStartPostponedEnterTransition();
    }
}
