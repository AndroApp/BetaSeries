package com.betaseries.betaseries.ui.show.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Episode;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowEpisodeViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.saison)
    TextView saison;

    @Bind(R.id.episode)
    TextView episode;

    @Bind(R.id.date)
    TextView date;

    @Bind(R.id.image_episode)
    ImageView image_episode;

    @Bind(R.id.tiret)
    TextView tiret;

    @Bind(R.id.card_view)
    View card_view;

    public ShowEpisodeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Episode episode_object) {
        this.saison.setText(episode_object.getCode());
        this.episode.setText(episode_object.getTitle());
        this.episode.setText(episode_object.getTitle());

        //String dateFr = DateUtils.getDateFr(episode_object.getDate());
//
        //int length = 0;
//
        //if (episode_object.getShow().getLength() != null)
        //    length = Integer.parseInt(episode_object.getShow().getLength());
//
        //if (length > 0) {
//
        //    if (length > 1)
        //        this.date.setText(dateFr + " (" + length + " minutes)");
        //    else
        //        this.date.setText(dateFr + " (" + length + " minute)");
//
        //} else {
        //    this.date.setText(dateFr);
        //}


        String url = "https://api.betaseries.com/pictures/episodes?key=d932200243da&id=" + episode_object.getId() + "&width=500&height=300";


        Picasso.with(itemView.getContext()).load(url).into(image_episode);
    }
}
