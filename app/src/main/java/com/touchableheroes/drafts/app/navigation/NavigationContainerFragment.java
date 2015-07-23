package com.touchableheroes.drafts.app.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchableheroes.drafts.app.lang.Navigation;
import com.touchableheroes.drafts.behaviours.component.BasicFragment;
import com.touchableheroes.drafts.behaviours.config.ConfigUtil;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;
import com.touchableheroes.drafts.behaviours.config.IFragmentConfig;
import com.touchableheroes.drafts.behaviours.config.IHasConfiguration;
import com.touchableheroes.drafts.behaviours.config.IOwnerAssignable;
import com.touchableheroes.drafts.behaviours.config.IUIConfig;
import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsFragmentExtSupported;
import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsOwnerSupported;
import com.touchableheroes.drafts.log.Logger;

/**
 * Created by asiebert on 04.07.15.
 */
public class NavigationContainerFragment extends BasicFragment {

    public static final Logger LOGGER = Logger.create(NavigationContainerFragment.class);

    public NavigationContainerFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final FragmentActivity activity = getActivity();
        if( !(activity instanceof IHasConfiguration) ) {
            LOGGER.debug( "Fragment can only be used inside Activities extends IHasConfiguration. This activity-class [=" + activity.getClass() + "] doesn't extends IHasConfiguration." );
            return null;
        }

        final IHasConfiguration configManager = (IHasConfiguration) activity;

        final IUIConfig config = configManager.config();
        if( !(config instanceof IActivityConfig) ) {
                LOGGER.debug( "Fragment can only be used inside Activities with IActivityConfig-support. Class of config [=" + config + "] doesn't extends IActivityConfig." );
                return null;
        }

        final IActivityConfig activityConfig = (IActivityConfig) config;

        final Navigation navigation = config.get(Navigation.class);

        if( navigation == null ) {
                LOGGER.debug("Activity has no Navigation-configuration. Class activity [=" + activity.getClass() + "] has no annotation @" + Navigation.class);
                return null;
        }

        final IsFragmentExtSupported impl = create(navigation.implementation());

        if( impl instanceof IOwnerAssignable) {
            final IOwnerAssignable<Fragment> ownerHandler = (IOwnerAssignable<Fragment>) impl;
            ownerHandler.assignOwner(this);
        }

        return impl.onCreateView(inflater, container, savedInstanceState);
    }

    private IsFragmentExtSupported create(Class<? extends IsFragmentExtSupported> implementation) {
        final Class<? extends IsFragmentExtSupported> impl = implementation;
        try {
            return impl.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onConfigBehaviours() {
        ;
    }

    @Override
    public IFragmentConfig config() {
        return null;
    }

}
