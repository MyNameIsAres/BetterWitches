package org.geminicraft.betterwitch.reflections.scanners;

import org.geminicraft.betterwitch.reflections.Configuration;
import org.geminicraft.betterwitch.reflections.Store;
import org.geminicraft.betterwitch.reflections.vfs.Vfs;

import java.util.List;

/**
 * scans for field's annotations
 */
@SuppressWarnings({"unchecked"})
public class FieldAnnotationsScanner extends AbstractScanner {
    public void scan(final Object cls, Store store) {
        final String className = getMetadataAdapter().getClassName(cls);
        List<Object> fields = getMetadataAdapter().getFields(cls);
        for (final Object field : fields) {
            List<String> fieldAnnotations = getMetadataAdapter().getFieldAnnotationNames(field);
            for (String fieldAnnotation : fieldAnnotations) {

                if (acceptResult(fieldAnnotation)) {
                    String fieldName = getMetadataAdapter().getFieldName(field);
                    put(store, fieldAnnotation, String.format("%s.%s", className, fieldName));
                }
            }
        }
    }

    @Override
    public void setConfiguration(Configuration configuration) {

    }

    @Override
    public Object scan(Vfs.File file, Object classObject, Store store) {
        return null;
    }
}
