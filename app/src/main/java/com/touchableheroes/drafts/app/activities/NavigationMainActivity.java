package com.touchableheroes.drafts.app.activities;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;

import com.touchableheroes.drafts.app.config.ActivityConfig;
import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.activity.BasicActivity;
import com.touchableheroes.drafts.behaviours.impl.LogLifecycleBehaviour;
import com.touchableheroes.drafts.behaviours.lifecycle.IActivityConfig;
import com.touchableheroes.drafts.ui.flow.ContentFragmentFlow;

/**
 * Created by asiebert on 16.06.15.
 */
public class NavigationMainActivity extends BasicActivity {

    @Override
    protected void onConfigBehaviours() {
        behaviours().add(new LogLifecycleBehaviour(this));
    }

    @Override
    protected IActivityConfig config() {
        return new ActivityConfig(this.getClass());
    }
}