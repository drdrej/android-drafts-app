package com.touchableheroes.drafts.app.navigation;

import android.app.Activity;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.ListView;

import com.touchableheroes.drafts.app.R;
import com.touchableheroes.drafts.behaviours.impl.BasicBehaviour;
import com.touchableheroes.drafts.behaviours.lifecycle.IActivityLifecycle;
import com.touchableheroes.drafts.behaviours.lifecycle.SimpleUILifecycle;
import com.touchableheroes.drafts.navidrawer.AppNavigationDrawerListAdapter;
import com.touchableheroes.drafts.navidrawer.NaviItem;
import com.touchableheroes.drafts.ui.annotations.BindView;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by asiebert on 22.06.15.
 */
public class NavigationDrawerBehaviour2<N extends Enum> extends BasicBehaviour<Activity> implements SimpleUILifecycle, IActivityLifecycle {

    private final Class<N> navigation;

    protected DrawerLayout mDrawerLayout;

    protected Fragment fragmentNavigation;


    protected Fragment fragmentContent;

    public NavigationDrawerBehaviour2(final Activity owner, final Class<N> navigation) {
        super(owner);
        this.navigation = navigation;
    }


    @Override
    public void onPause() {
        ;
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

        bind();

        setupAdapter();
        // ButterKnife.inject(this, owner());



        // lade die sources:
        // mPlanetTitles = getResources().getStringArray(R.array.planets_array);

        // hole das drawer layout

        // owner().findViewById(R.id.frgmt_navigation);

        // Set the adapter for the list view
    //    mDrawerList.setAdapter(new ArrayAdapter<String>(this,
      //          R.layout.drawer_list_item, mPlanetTitles));

        // Set the list's click listener
        // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // ActionBarDrawerToggle toggle =

    }

    private void setupAdapter() {
        final ListView list = ButterKnife.findById(fragmentNavigation.getView(), R.id.listview);
        final AppNavigationDrawerListAdapter adapter = new AppNavigationDrawerListAdapter<N>(owner(), navigation);

        list.setAdapter(adapter);
    }

    private void bind() {
        mDrawerLayout =  findById(R.id.drawer_layout);
        fragmentNavigation = findById(R.id.frgmt_navigation);
        fragmentContent = findById(R.id.frame_content);
    }

    private <T> T findById(int id) {
        return (T) ButterKnife.findById(owner(), id);
    }


    @Override
    public void onConfigurationChanged(Configuration configuration) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTerminate() {

    }
}
