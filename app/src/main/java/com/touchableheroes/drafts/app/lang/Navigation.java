package com.touchableheroes.drafts.app.lang;

import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsFragmentExtSupported;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by asiebert on 04.07.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Navigation {

    LayoutId layout();

    Class<? extends IsFragmentExtSupported> implementation();

    Class<? extends Enum> items();

}
