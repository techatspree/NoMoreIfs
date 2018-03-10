package de.akquinet.playground.appfunctor;

import java.util.Optional;

public class OptionalSumVariants {
    private OptionalSumVariants() {}

    static Optional<Integer> addWithOptionalUsingIfs(Optional<Integer> summand1, Optional<Integer> summand2) {
        if ((summand1.isPresent()) && (summand2.isPresent())) {
            return Optional.of(summand1.get() + summand2.get());
        } else {
            return Optional.empty();
        }
    }
}
