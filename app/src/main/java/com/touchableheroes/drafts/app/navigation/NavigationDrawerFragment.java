package com.touchableheroes.drafts.app.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.touchableheroes.drafts.app.R;
import com.touchableheroes.drafts.app.config.FragmentConfig;
import com.touchableheroes.drafts.behaviours.component.BasicFragment;
import com.touchableheroes.drafts.behaviours.config.IFragmentConfig;
import com.touchableheroes.drafts.navidrawer.AppNavigationDrawerListAdapter;

/**
 * Created by asiebert on 14.05.2014.
 */
public abstract class NavigationDrawerFragment<N extends Enum>
        extends BasicFragment {

    private final N currentState;

    private final IFragmentConfig config;

    public ListView listView;

/*
    public NavigationDrawerFragment(final Class<N> states) {
        this.currentState = states.;
    }
  */

   public NavigationDrawerFragment(final N startState) {
       this.currentState = startState;
       this.config = new FragmentConfig(this);
   }

   @Override
   protected void onConfigBehaviours() {
                // behaviours().add(new NavigationDrawerActivityBehaviour<N>(this) );
   }

    @Override
    public IFragmentConfig config() {
        return config;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View root = inflater.inflate(
                config().getLayoutId(), container, false);

        listView = (ListView) root.findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("CALL: click in Navi drawer");

                // selectItem(position);
            }
        });

        final Class<N> type = (Class<N>) currentState.getClass();
        final AppNavigationDrawerListAdapter adapter = new AppNavigationDrawerListAdapter<N>(getActivity(), type);

        listView.setAdapter(adapter);

        setHasOptionsMenu(true);

        return root;
    }

    public static <Navi extends Enum> NavigationDrawerFragment<Navi> create(final Navi state) {
        return new NavigationDrawerFragment<Navi>(state) {;};
    }

}
