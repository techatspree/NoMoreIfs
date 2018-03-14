package de.akquinet.playground.optionalvalues;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static de.akquinet.playground.optionalvalues.ReadParameters.readFloatParameterUsingValidation;
import static io.vavr.control.Validation.valid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadParametersUsingValidationTest {
    @Test
    void readFloatParameterusingIfsOnEmptyMap() {
        assertTrue(readFloatParameterUsingValidation("p", Collections.emptyMap()).isInvalid());
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneCorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        final String key = "key";
        paras.put(key, values);
        assertEquals(valid(3.14f), readFloatParameterUsingValidation(key,paras));
    }

    @Test
    void readFloatParameterusingIfsOnMapWithOneIncorrectValue() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        assertTrue(readFloatParameterUsingValidation(key,paras).isInvalid());
    }

    @Test
    void readFloatParameterusingIfsOnMapWithTwoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final HashSet<String> values = new HashSet<>();
        values.add("3.14");
        values.add("xyz");
        final String key = "key";
        paras.put(key, values);
        assertTrue(readFloatParameterUsingValidation(key, paras).isInvalid());
    }

    @Test
    void readFloatParameterusingIfsOnMapWithNoValues() {
        final HashMap<String, Set<String>> paras = new HashMap<>();
        final Set<String> values = Collections.emptySet();
        final String key = "key";
        paras.put(key, values);
        assertTrue(readFloatParameterUsingValidation(key,paras).isInvalid());
    }
}
