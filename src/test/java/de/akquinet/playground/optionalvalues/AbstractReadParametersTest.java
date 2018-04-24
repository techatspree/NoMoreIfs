package de.akquinet.playground.optionalvalues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AbstractReadParametersTest {
    @Test
    void readFloatParameterusingIfsOnEmptyMap() {
        assertEquals(Optional.empty(), getReadFloatParameter().apply("p", Collections.emptyMap()));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneCorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        final String key = "key";
        paras.put(key, values);
        assertEquals(Optional.of(3.14f), getReadFloatParameter().apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneInCorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        assertEquals(Optional.empty(), getReadFloatParameter().apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithTwoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        assertEquals(Optional.empty(), getReadFloatParameter().apply(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithNoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final Set<String> values = Collections.emptySet();
        final String key = "key";
        paras.put(key, values);
        assertEquals(Optional.empty(), getReadFloatParameter().apply(key,paras));
    }

    abstract BiFunction<String, Map<String, Set<String>>, Optional<Float>> getReadFloatParameter();
}
