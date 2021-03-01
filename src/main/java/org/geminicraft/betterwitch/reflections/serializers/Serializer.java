package org.geminicraft.betterwitch.reflections.serializers;

import org.geminicraft.betterwitch.reflections.Reflections;

import java.io.File;
import java.io.InputStream;

/**
 *
 */
public interface Serializer {
    /**
     * reads the input stream into a new Reflections instance, populating it's store
     */
    Reflections read(InputStream inputStream);

    /**
     * saves a Reflections instance into the given filename
     */
    File save(Reflections reflections, String filename);

    /**
     * returns a string serialization of the given Reflections instance
     */
    String toString(Reflections reflections);
}
