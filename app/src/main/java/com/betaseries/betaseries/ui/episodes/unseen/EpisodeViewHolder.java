package com.betaseries.betaseries.ui.episodes.unseen;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RatingBar;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Episode;
import com.github.florent37.carpaccio.controllers.adapter.Holder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 13/08/15.
 */
public class EpisodeViewHolder extends Holder implements RatingBar.OnRatingBarChangeListener {

    @Nullable @Bind(R.id.ratingUserStar)
    RatingBar ratingBar;
    @Nullable  @Bind(R.id.card)
    View card;

    public EpisodeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        if(ratingBar != null)
            ratingBar.setOnRatingBarChangeListener(this);
    }

    public void setCardVisible(Object object){
        if (object instanceof Episode)
            setCardVisible(((Episode) object).isSwiped());
    }

    public void setCardVisible(boolean visible){
        if(card != null) {
            if (visible) {
                card.setVisibility(View.GONE);
            } else {
                card.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if(this.mappedObject!=null && fromUser && this.mappedObject instanceof Episode){
            Episode.class.cast(mappedObject).setNoteUser(rating);
            ratingBar.setRating(rating);
        }
    }

    public void reinitStars() {
        if(ratingBar != null)
            ratingBar.setRating(0);
    }
}