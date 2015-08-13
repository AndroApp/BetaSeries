package com.betaseries.betaseries.controllers;

import android.view.View;
import android.widget.ImageView;

import com.betaseries.betaseries.Application;
import com.github.florent37.carpaccio.controllers.ImageViewController;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.greenrobot.event.EventBus;

/**
 * Created by florentchampigny on 12/08/15.
 */
public class EventImageViewController extends ImageViewController{

    public static class EventImage{
        public String url;

        public EventImage(String url) {
            this.url = url;
        }
    }

    EventBus eventBus;

    public EventImageViewController() {
        eventBus = Application.app().component().eventBus();
    }
    @Override
    protected void onImageLoadedFromUrl(String url, ImageView imageView) {
        super.onImageLoadedFromUrl(url, imageView);
        eventBus.post(new EventImage(url));
    }
}
