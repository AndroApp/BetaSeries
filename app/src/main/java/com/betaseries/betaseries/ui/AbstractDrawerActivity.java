package com.betaseries.betaseries.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

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
            drawerLayout.setDrawerListener(drawerToggle);
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
}
