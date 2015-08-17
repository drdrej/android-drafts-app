package com.touchableheroes.drafts.app.components;

import com.touchableheroes.drafts.behaviours.component.BasicActivity;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;

import butterknife.ButterKnife;

/**
 * Created by asiebert on 17.08.15.
 */
public abstract class ExtendedActivity extends BasicActivity {

    public <T> T findById(int id) {
        return (T) ButterKnife.findById( this, id);
    }


/*
    @Override
    protected void onConfigBehaviours() {

    }

    @Override
    public IActivityConfig config() {
        return null;
    }
    */
}
