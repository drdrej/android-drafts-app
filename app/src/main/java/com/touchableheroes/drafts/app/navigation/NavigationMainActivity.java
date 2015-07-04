package com.touchableheroes.drafts.app.navigation;

import com.touchableheroes.drafts.app.config.ActivityConfig;
import com.touchableheroes.drafts.behaviours.component.BasicActivity;
import com.touchableheroes.drafts.behaviours.impl.LogActivityBehaviour;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;

/**
 * Created by asiebert on 16.06.15.
 */
public class NavigationMainActivity extends BasicActivity {

    @Override
    protected void onConfigBehaviours() {
        behaviours().add(new LogActivityBehaviour(this));
        // behaviours().add(new NavigationDrawerActivityBehaviour(this));
    }

    @Override
    protected IActivityConfig config() {
        return new ActivityConfig(this.getClass());
    }
}