package com.touchableheroes.drafts.app.config;

import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.config.IUIConfig;

import java.lang.annotation.Annotation;

/**
 * Created by asiebert on 03.07.15.
 */
public abstract class UIConfig<T> implements IUIConfig {

    private final Class<T> type;

    public UIConfig(final Class<T> type) {
        this.type = type;

        if( type == null )
            throw new IllegalArgumentException("PARAM:activityType is NULL");
    }

    @Override
    public int getLayoutId() {
        final LayoutId layout = (LayoutId) get(LayoutId.class);

        if( layout == null ) {
            throw new IllegalStateException("Config missing: @LayoutId in class " + type);
        }

        return layout.value();
    }

    public <A extends Annotation> A get(final Class<A> key) {
        return (A) type.getAnnotation(key);
    }

}
