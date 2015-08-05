package com.betaseries.betaseries.controllers;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.betaseries.betaseries.R;
import com.github.florent37.carpaccio.controllers.ControllerHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 05/08/15.
 */
public class ParallaxViewController extends RecyclerView.OnScrollListener {

    int PARALLAX_SPEED = 100;
    int CELL_IMAGE_FOND_HEIGHT;

    protected List<ImageView> imageViewList = new ArrayList<>();

    public void registerParallax(RecyclerView recyclerView){
        recyclerView.addOnScrollListener(this);
        CELL_IMAGE_FOND_HEIGHT = (int) ControllerHelper.dpFromPx(recyclerView.getContext(),250);
    }

    public void imageParallax(ImageView imageView){
        if(!imageViewList.contains(imageView))
            imageViewList.add(imageView);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    View top = null;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (recyclerView.getChildCount() == 0)
            return;

        int first = 0;
        if (top == null)
            top = recyclerView.getChildAt(first);

        int last = first + recyclerView.getLayoutManager().getItemCount();

        float centerY = recyclerView.getMeasuredHeight() / 2 + recyclerView.getTop();

        Rect rect = new Rect();
        View viewCell;
        for (int i = first; i < last; ++i) {
            if((viewCell = recyclerView.getChildAt(i)) != null) {
                viewCell.getGlobalVisibleRect(rect);

                float diffCenter = (centerY - rect.top);

                View viewToParallax = viewCell.findViewById(R.id.image);

                float yOffset = diffCenter / viewToParallax.getHeight();

                yOffset = Math.max(Math.min(yOffset,1),-1);

                viewToParallax.setTranslationY((-1f + yOffset) * PARALLAX_SPEED);
            }
        }
    }
}
