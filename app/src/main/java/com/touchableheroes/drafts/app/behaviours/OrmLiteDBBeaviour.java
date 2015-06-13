package com.touchableheroes.drafts.app.behaviours;

import android.content.res.Configuration;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.touchableheroes.drafts.behaviours.AbstractAppBehaviour;
// import com.touchableheroes.drafts.db.DBConfig;

/**
 * Created by asiebert on 30.12.14.
 */
public class OrmLiteDBBeaviour extends AbstractAppBehaviour {

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {

    }

    @Override
    public void onCreate() {

    }

    /*
    private DBConfig db;

    private final Class<?>[] entities;
    private final String dbName;

    public OrmLiteDBBeaviour(
            final String dbName,
            final Class<?>... entities) {
        this.dbName = dbName;
        this.entities = entities;
    }


    @Override
    public void onCreate() {
        db.configure( this.dbName, 3);

            for ( final Class<?> entity : entities ) {
                db.entity( entity );
            }

            this.db = OpenHelperManager.getHelper(context(), DB.class);
    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTerminate() {
        OpenHelperManager.releaseHelper();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }
    */
}
