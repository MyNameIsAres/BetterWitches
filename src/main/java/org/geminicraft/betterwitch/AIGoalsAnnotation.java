package org.geminicraft.betterwitch;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AIGoalsAnnotation {

    String name();

    String description();
}
