package org.geminicraft.betterwitch.tester.scanners;

import org.geminicraft.betterwitch.tester.Store;
import org.geminicraft.betterwitch.tester.adapters.MetadataAdapter;

import java.util.List;

/**
 * scans methods/constructors and indexes parameters, return type and parameter annotations
 */
@SuppressWarnings("unchecked")
public class MethodParameterScanner extends AbstractScanner {

    @Override
    public void scan(Object cls, Store store) {
        final MetadataAdapter md = getMetadataAdapter();

        for (Object method : md.getMethods(cls)) {

            String signature = md.getParameterNames(method).toString();
            if (acceptResult(signature)) {
                put(store, signature, md.getMethodFullKey(cls, method));
            }

            String returnTypeName = md.getReturnTypeName(method);
            if (acceptResult(returnTypeName)) {
                put(store, returnTypeName, md.getMethodFullKey(cls, method));
            }

            List<String> parameterNames = md.getParameterNames(method);
            for (int i = 0; i < parameterNames.size(); i++) {
                for (Object paramAnnotation : md.getParameterAnnotationNames(method, i)) {
                    if (acceptResult((String) paramAnnotation)) {
                        put(store, (String) paramAnnotation, md.getMethodFullKey(cls, method));
                    }
                }
            }
        }
    }
}
