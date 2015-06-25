package com.touchableheroes.drafts.app.activities;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;

import com.touchableheroes.drafts.app.config.ActivityConfig;
import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.activity.BasicActivity;
import com.touchableheroes.drafts.behaviours.impl.LogActivityBehaviour;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;
import com.touchableheroes.drafts.ui.flow.ContentFragmentFlow;

import com.touchableheroes.drafts.app.behaviours.NavigationDrawerBehaviour2;

/**
 * Created by asiebert on 16.06.15.
 */
public class NavigationMainActivity extends BasicActivity {

    @Override
    protected void onConfigBehaviours() {
        behaviours().add(new LogActivityBehaviour(this));
        behaviours().add(new NavigationDrawerBehaviour2(this));
    }

    @Override
    protected IActivityConfig config() {
        return new ActivityConfig(this.getClass());
    }
}