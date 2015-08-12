package com.betaseries.betaseries.controllers;

import android.view.View;
import android.widget.RatingBar;

import com.github.florent37.carpaccio.Carpaccio;

/**
 * Created by florentchampigny on 12/08/15.
 */
public class RatingViewController {

    public void rating(RatingBar ratingBar, float value){
        ratingBar.setRating(value);
    }

    public void ratingPreview(RatingBar ratingBar, float value){
        if(Carpaccio.IN_EDIT_MODE)
            rating(ratingBar,value);
    }


}
