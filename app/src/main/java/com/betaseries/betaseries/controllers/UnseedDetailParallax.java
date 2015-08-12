package com.betaseries.betaseries.controllers;

import android.view.View;

import com.github.florent37.carpaccio.controllers.*;

/**
 * Created by florentchampigny on 12/08/15.
 */
public class UnseedDetailParallax extends com.github.florent37.carpaccio.controllers.ParallaxViewController{

    View headerView;

    public void unseedDetailHeaderParallax(View view){
        headerView = view;
        super.parallaxY(headerView,0.5f);
    }

    @Override
    public void scrolled(int i) {
        super.scrolled(i);

        if(headerView != null){
            float alpha = 1;
            if(headerView.getHeight() != 0 && i != 0)
                alpha = 1.0f-(1.0f*i)/headerView.getHeight();
            headerView.setAlpha(alpha);
        }
    }
}
