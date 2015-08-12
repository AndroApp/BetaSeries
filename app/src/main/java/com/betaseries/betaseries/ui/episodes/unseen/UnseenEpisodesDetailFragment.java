package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.controllers.EventImageViewController;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseenEpisodesDetailFragment extends AbstractFragment {

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    Show show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show = (Show) getArguments().getSerializable("show");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_episodes_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        eventBus.unregister(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        carpaccio.mapObject("show", show);
        carpaccio.mapList("episode", show.getUnseen());
    }

    public static Fragment newInstance(Show show) {
        UnseenEpisodesDetailFragment fragment = new UnseenEpisodesDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("show", show);
        fragment.setArguments(args);
        return fragment;
    }

    public void onEvent(EventImageViewController.EventImage eventImage){
        if(eventImage.url.equals(show.getUrlShow()))
            getActivity().supportStartPostponedEnterTransition();
    }
}
