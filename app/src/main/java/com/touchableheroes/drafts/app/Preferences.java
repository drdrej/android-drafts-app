package com.touchableheroes.drafts.app;

import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Vereinfacht die Arbeit mit SharedPrefs und Objekten.
 *
 * Created by asiebert on 06.08.15.
 */
public class Preferences {

    private final SharedPreferences src;

    public Preferences(final SharedPreferences basedOn) {
        this.src = basedOn;
    }

    public SharedPreferences getSrc() {
        return src;
    }

    public void delete( final String key ) {
        final SharedPreferences.Editor editor = this.src.edit();
        editor.remove(key);
        editor.commit();
    }

    public void delete( final Class key ) {
        delete(key.getName());
    }


    public boolean has( final String key ) {
        return this.src.contains(key);
    }

    public boolean has( final Class key ) {
        return this.src.contains(key.getName());
    }

    public void write(final Serializable obj) throws IOException {
        if( obj == null ) {
            throw new IllegalArgumentException( "NULL-Werte werden nicht geschrieben." );
        }

        write(obj.getClass().getName(), obj);
    }


    /**
     * Serialisiert ein Objekt als Base64 in die Preferences.
     *
     * @param key nie NULL
     * @param value nie NULL
     */
    public void write( final String key, final Serializable value) throws IOException {
        final String encoded = encode(value);

        final SharedPreferences.Editor editor = this.src.edit();
        editor.putString(key, encoded);
        editor.commit();
    }

    public <T> T read( final String key ) throws IOException {
        final String encoded = this.src.getString(key, null);

        if( encoded == null ) {
            return null;
        }

        try {
            return (T) decode(encoded);
        } catch (final IOException e) {
            throw e;
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            throw new IOException( "Kann den Wert nicht laden. Probleme mit Klasse [=" + key + "].");
        }
    }

    public <T> T read(final Class<T> key) throws IOException {
        return read(key.getName());
    }

    protected String encode(final Serializable object)
            throws IOException {

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream( baos );

        oos.writeObject(object);
        oos.close();

        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
    }

    protected <T extends Serializable> T decode(final String value)
            throws IOException,
                   ClassNotFoundException {

        final byte [] data = Base64.decode( value, Base64.DEFAULT );
        final ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );

        final Object o  = ois.readObject();
        ois.close();

        return (T) o;
    }

}
