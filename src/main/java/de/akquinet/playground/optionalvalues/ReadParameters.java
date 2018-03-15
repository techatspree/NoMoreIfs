package de.akquinet.playground.optionalvalues;

import io.vavr.Function1;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ReadParameters {
    static Optional<Float> readFloatParameterUsingIfs(String parameterName, Map<String, Set<String>> parameters) {
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

    static Optional<Float> readFloatParameterUsingOptionals(String parameterName, Map<String, Set<String>> parameters) {
        return Optional.ofNullable(parameters.get(parameterName))
                .filter(values -> values.size() == 1)
                .map(values -> values.iterator().next())
                .map(value -> {
                    try {
                        return Float.parseFloat(value);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                });
    }

    static Optional<Float> readFloatParameterUsingOption(String parameterName, Map<String, Set<String>> parameters) {
        return Option.of(parameters.get(parameterName))
                .filter(values -> values.size() == 1)
                .map(values -> values.iterator().next())
                .flatMap(Function1.lift(Float::parseFloat))
                .toJavaOptional();
    }

    static Validation<String, Float> readFloatParameterUsingValidation(
            String parameterName, Map<String, Set<String>> parameters) {
        return Option.of(parameters.get(parameterName))
                .toValid("Parameter is not set")
                .flatMap(strings -> strings.size() == 1
                        ? Validation.valid(strings.iterator().next())
                        : Validation.invalid("Parameter is set several times"))
                .flatMap(s -> Try.of(() -> Float.parseFloat(s))
                        .toValid("The parameter is not a valid String"));
    }
}
