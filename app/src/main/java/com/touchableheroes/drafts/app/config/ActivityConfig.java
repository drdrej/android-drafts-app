package com.touchableheroes.drafts.app.config;

import android.app.Activity;

import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;

/**
 * Created by asiebert on 16.06.15.
 */
public class ActivityConfig<A extends Activity> extends UIConfig<A> implements IActivityConfig {

    public ActivityConfig(final Class<A> type) {
        super(type);
    }

}
