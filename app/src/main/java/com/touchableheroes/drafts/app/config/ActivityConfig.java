package com.touchableheroes.drafts.app.config;

import android.app.Activity;

import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.config.IActivityConfig;

/**
 * Created by asiebert on 16.06.15.
 */
public class ActivityConfig implements IActivityConfig {

    private final Class<? extends Activity> activityType;

    public ActivityConfig(final Class<? extends Activity> activityType) {
        if( activityType == null ) {
            throw new IllegalArgumentException("PARAM:activityType is NULL");
        }

        this.activityType = activityType;
    }


    @Override
    public int initialContentView() {
        return activityType.getAnnotation(LayoutId.class).value();
    }
}
