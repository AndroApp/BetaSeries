package com.betaseries.betaseries.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import com.betaseries.betaseries.R;

import butterknife.Bind;

/**
 * Created by florentchampigny on 02/08/15.
 */
public class AbstractDrawerActivity extends AbstractActivity {

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (drawerToggle == null && drawerLayout != null) {
            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
            drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {
                    drawerToggle.onDrawerSlide(drawerView,slideOffset);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    drawerToggle.onDrawerOpened(drawerView);
                    drawerOpened();
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    drawerToggle.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerStateChanged(int newState) {
                    drawerToggle.onDrawerStateChanged(newState);
                }
            });
            drawerLayout.setOnClickListener(v -> {});
        }

        if (drawerToggle != null)
            drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (drawerToggle != null)
            drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (drawerToggle != null && drawerToggle.onOptionsItemSelected(item))
                || super.onOptionsItemSelected(item);
    }

    public void closeDrawer(){
        drawerLayout.closeDrawers();
    }

    public void drawerOpened(){}
}
