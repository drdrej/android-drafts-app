package com.touchableheroes.drafts.app.config;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.touchableheroes.drafts.app.lang.LayoutId;
import com.touchableheroes.drafts.behaviours.config.IFragmentConfig;

import java.lang.annotation.Annotation;

/**
 * Created by asiebert on 03.07.15.
 */
public class FragmentConfig<F extends Fragment> extends UIConfig<F> implements IFragmentConfig {

    public FragmentConfig(final F fragment) {
        this((Class<F>) fragment.getClass());
    }

    public FragmentConfig(final Class<F> type) {
        super((Class<F>) type);
    }

}
