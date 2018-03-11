package de.akquinet.playground.appfunctor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

class ReadParametersTest {

    private BiFunction<String, Map<String, Set<String>>, Optional<Float>> readFloatParameter;

    @BeforeEach
    void setFunction() {
        readFloatParameter = ReadParameters::readFloatParameterusingIfs;
    }

    @Test
    void readFloatParameterusingIfsOnEmptyMap() {
        Assertions.assertEquals(Optional.empty(),readFloatParameter.apply("p",Collections.emptyMap()));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneCorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        final String key = "key";
        paras.put(key, values);
        Assertions.assertEquals(Optional.of(3.14f),readFloatParameter.apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneInCorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        Assertions.assertEquals(Optional.empty(),readFloatParameter.apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithTwoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        Assertions.assertEquals(Optional.empty(),readFloatParameter.apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithNoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final Set<String> values = Collections.emptySet();
        final String key = "key";
        paras.put(key, values);
        Assertions.assertEquals(Optional.empty(),readFloatParameter.apply(key,paras));
    }
}