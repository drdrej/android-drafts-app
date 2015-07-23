package com.touchableheroes.drafts.app.navigation;

import android.app.Activity;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
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
public class NavigationDrawerActivityBehaviour<N extends Enum> extends BasicBehaviour<ActionBarActivity> implements SimpleUILifecycle, IActivityLifecycle {

    private final Class<N> navigation;

    protected final NavigationDrawerFragment<N> naviImpl;

    protected DrawerLayout mDrawerLayout;

    protected NavigationContainerFragment fragmentNavigation;

    protected Fragment fragmentContent;

    private ActionBarDrawerToggle drawerToggle;


    public NavigationDrawerActivityBehaviour(final ActionBarActivity owner,
                                             final Class<N> navigation,
                                             final NavigationDrawerFragment<N> implementation) {
        super(owner);

        this.navigation = navigation;
        this.naviImpl = implementation;
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

        /*
        <fragment
        android:id="@+id/frgmt_navigation"

        android:layout_width="wrap_content"
        android:layout_height="match_parent"

        android:layout_gravity="start"

        android:name="com.touchableheroes.drafts.app.navigation.NavigationContainerFragment"
                />
                */


        bind();

        prepareDrawerLayout();
        prepareFragmentNavigation();
    }

    private void prepareFragmentNavigation() {
        // frueher war hier *.bind()... Was ist der Sinn der Methode?
        // fragmentNavigation.config(naviImpl); .... // configuration binden. damit man metadata einfach aufnehmen kann.
    }

    private void prepareDrawerLayout() {
        final ActionBar actionBar = owner().getSupportActionBar();

        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(owner(),
                mDrawerLayout,
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close   /* "close drawer" description */
        ) {

            // new Toolbar(owner()),  /* nav drawer icon to replace 'Up' caret */

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                // actionBar.setTitle(R.string.drawer_title_closed);
                actionBar.setTitle( "App" );
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // actionBar.setTitle(R.string.drawer_title_open);
                actionBar.setTitle("Mavi");
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(drawerToggle);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        this.drawerToggle = drawerToggle;

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
