package org.geminicraft.betterwitch.reflections.scanners;

import org.geminicraft.betterwitch.reflections.Configuration;
import org.geminicraft.betterwitch.reflections.Store;
import org.geminicraft.betterwitch.reflections.vfs.Vfs;

import java.util.function.Predicate;

/**
 *
 */
public interface Scanner {

    void setConfiguration(Configuration configuration);

    Scanner filterResultsBy(Predicate<String> filter);

    boolean acceptsInput(String file);

    Object scan(Vfs.File file, Object classObject, Store store);

    boolean acceptResult(String fqn);
}
