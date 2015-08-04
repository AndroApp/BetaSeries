package com.betaseries.betaseries.ui.show.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowDetailViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.numberSeasonsEpisodes)
    TextView numberSeasonsEpisodes;

    @Bind(R.id.regardePar)
    TextView regardePar;

    @Bind(R.id.description)
    TextView description;

    @Bind(R.id.ratingBar)
    RatingBar ratingBar;

    public ShowDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Show show) {
        this.numberSeasonsEpisodes.setText(itemView.getContext().getString(R.string.nb_season_episodes, show.getSeasons(), show.getEpisodes()));
        this.regardePar.setText(itemView.getContext().getString(R.string.regardes_par, show.getFollowers()));
        this.description.setText(show.getDescription());
        try {
            this.ratingBar.setRating(Float.valueOf(show.getNotes().getMean()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
