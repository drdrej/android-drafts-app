package com.touchableheroes.drafts.app.behaviours;

import android.app.Activity;

import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.touchableheroes.drafts.app.R;
import com.touchableheroes.drafts.behaviours.impl.BasicBehaviour;
import com.touchableheroes.drafts.behaviours.lifecycle.IActivityLifecycle;
import com.touchableheroes.drafts.behaviours.lifecycle.SimpleUILifecycle;


/**
 * Created by asiebert on 22.06.15.
 */
public class NavigationDrawerBehaviour2 extends BasicBehaviour<Activity> implements SimpleUILifecycle, IActivityLifecycle {

    public NavigationDrawerBehaviour2(final Activity owner) {
        super(owner);
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void setEnabled(boolean b) {
        ;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onCreate() {
        owner().setContentView(R.layout.navigation_drawer_app_layout);
    }

}
