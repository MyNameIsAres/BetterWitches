package org.geminicraft.betterwitch.tester.scanners;

import org.geminicraft.betterwitch.tester.Configuration;
import org.geminicraft.betterwitch.tester.Store;
import org.geminicraft.betterwitch.tester.vfs.Vfs;

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
