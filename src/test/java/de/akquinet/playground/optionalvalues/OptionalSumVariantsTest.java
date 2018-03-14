package de.akquinet.playground.optionalvalues;

import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;

import static io.vavr.control.Option.none;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalSumVariantsTest {

    @Test
    void addWithOptionalUsingIfs() {
        testOptionalSum(OptionalSumVariants::addWithOptionalUsingIfs);
    }

    @Test
    void addWithOptionalUsingMaps() {
        testOptionalSum(OptionalSumVariants::addWithOptionalUsingMaps);
    }

    private void testOptionalSum(BinaryOperator<Optional<Integer>> optionalSum) {
        assertEquals(empty() , optionalSum.apply(empty(), empty()));
        assertEquals(empty() , optionalSum.apply(Optional.of(1), empty()));
        assertEquals(empty() , optionalSum.apply(empty(), Optional.of(2) ));
        assertEquals(Optional.of(3) , optionalSum.apply(Optional.of(1), Optional.of(2)));
    }

    @Test
    void addWithOptionUsingSequence() {
        assertEquals(none(), OptionalSumVariants.addWithOptionUsingSequence(none(), none()));
        assertEquals(none(), OptionalSumVariants.addWithOptionUsingSequence(Option.of(1), none()));
        assertEquals(none(), OptionalSumVariants.addWithOptionUsingSequence(none(), Option.of(2)));
        assertEquals(Option.of(3) ,  OptionalSumVariants.addWithOptionUsingSequence(Option.of(1), Option.of(2)));
    }
}