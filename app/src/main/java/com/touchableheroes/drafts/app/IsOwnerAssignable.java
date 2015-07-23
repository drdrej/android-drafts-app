package com.touchableheroes.drafts.app;

import com.touchableheroes.drafts.behaviours.lifecycle.supports.IsOwnerSupported;

/**
 * Created by asiebert on 05.07.15.
 */
public interface IsOwnerAssignable<T> extends IsOwnerSupported {

    public void assignOwner(T owner);

}
