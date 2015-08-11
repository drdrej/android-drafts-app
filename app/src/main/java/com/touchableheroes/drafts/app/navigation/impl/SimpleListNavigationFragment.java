package com.touchableheroes.drafts.app.navigation.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchableheroes.drafts.app.navigation.NavigationDrawerFragment;
import com.touchableheroes.drafts.behaviours.config.IOwnerAssignable;
import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsFragmentExtSupported;
import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsOwnerSupported;
import com.touchableheroes.drafts.navidrawer.NaviItem;

/**
 * Created by asiebert on 04.07.15.
 */
public class SimpleListNavigationFragment<T> implements IsFragmentExtSupported,
        IOwnerAssignable<T>,
        IsOwnerSupported<T>  {

    private T owner;

    public SimpleListNavigationFragment( ) {
        ;
    }

    /*final N startState*/
    //super(startState);


    @Override
    public void assignOwner(T owner) {
        this.owner = owner;
    }


    @Override
    public View onCreateView(final LayoutInflater layoutInflater,
                             final ViewGroup viewGroup,
                             final Bundle bundle) {
        /*
        final View usedView;

        final NaviItem item = getConfig().entry(idx).get(NaviItem.class);

        if(item == null) {
            System.out.println( "warn: navi item is null, skip this item. index = " + idx );
            return view;
        }

        if (view == null) {
            usedView = LayoutInflater.from(getActivity()).inflate(item.layoutId(), null, false);
        } else {
            usedView = view;
        }

        ((TextView) usedView.findViewById(item.titleViewId()))
                .setText(item.title());

        return usedView;
        return null;
        */

        throw new UnsupportedOperationException( "todo" );

    }


    @Override
    public T owner() {
        return owner;
    }
}
