package de.akquinet.playground.optionalvalues;

import io.vavr.control.Option;

import java.util.List;
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

    static Optional<Integer> addWithOptionalUsingMaps(Optional<Integer> optSummand1, Optional<Integer> optSummand2) {
        return optSummand1.flatMap(
                sum1 -> optSummand2.map( sum2 -> sum1 + sum2)
        );
    }

    static Option<Integer> addWithOptionUsingSequence(Option<Integer> optSummand1, Option<Integer> optSummand2) {
        return Option.sequence(List.of(optSummand1, optSummand2))
                .map(seq -> seq.reduce(Integer::sum));
    }
}
