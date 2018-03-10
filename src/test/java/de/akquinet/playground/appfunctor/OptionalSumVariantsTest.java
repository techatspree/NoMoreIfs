package de.akquinet.playground.appfunctor;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalSumVariantsTest {

    @Test
    void addWithOptional() {
        assertEquals(empty() , OptionalSumVariants.addWithOptionalUsingIfs(empty(), empty()));
        assertEquals(empty() , OptionalSumVariants.addWithOptionalUsingIfs(Optional.of(1), empty()));
        assertEquals(empty() , OptionalSumVariants.addWithOptionalUsingIfs(empty(), Optional.of(2) ));
        assertEquals(Optional.of(3) , OptionalSumVariants.addWithOptionalUsingIfs(Optional.of(1), Optional.of(2)));
    }
}