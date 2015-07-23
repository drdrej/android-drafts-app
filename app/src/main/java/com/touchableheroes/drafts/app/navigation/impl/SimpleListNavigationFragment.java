package com.touchableheroes.drafts.app.navigation.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchableheroes.drafts.app.navigation.NavigationDrawerFragment;
import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsFragmentExtSupported;

/**
 * Created by asiebert on 04.07.15.
 */
public class SimpleListNavigationFragment implements IsFragmentExtSupported {

    public SimpleListNavigationFragment( /*final N startState*/) {
        //super(startState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }
}
