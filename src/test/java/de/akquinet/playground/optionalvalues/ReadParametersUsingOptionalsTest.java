package de.akquinet.playground.optionalvalues;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;

class ReadParametersUsingOptionalsTest extends AbstractReadParametersTest {

    @Override
    BiFunction<String, Map<String, Set<String>>, Optional<Float>> getReadFloatParameter() {
        return ReadParameters::readFloatParameterUsingOptionals;
    }
}