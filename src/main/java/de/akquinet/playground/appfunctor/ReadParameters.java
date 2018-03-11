package de.akquinet.playground.appfunctor;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ReadParameters {
    static Optional<Float> readFloatParameterusingIfs(String parameterName, Map<String, Set<String>> parameters) {
        final Set<String> values = parameters.get(parameterName);
        if (values == null) {
            return Optional.empty();
        }
        if (values.size() != 1) {
            return Optional.empty();
        }
        final String valueAsString = values.iterator().next();
        final float valueAsFloat;
        try {
            valueAsFloat = Float.parseFloat(valueAsString);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        return Optional.of(valueAsFloat);
    }
}
