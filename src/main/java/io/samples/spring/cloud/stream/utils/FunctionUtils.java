package io.samples.spring.cloud.stream.utils;

import lombok.experimental.UtilityClass;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
public class FunctionUtils {

    public static <T> Predicate<T> not(final Predicate<T> p) {
        return p.negate();
    }

    public static <T> Predicate<T> or(final Predicate<T> first, final Predicate<T>... predicates) {
        Predicate<T> current = first;
        for (final Predicate<T> next : predicates) {
            current = current.or(next);
        }
        return current;
    }

    public static <T> Function<T, T> apply(final Consumer<T> consumer) {
        return t -> {
            consumer.accept(t);
            return t;
        };
    }

    public static <T, R> Function<T, T> apply(final BiConsumer<T, R> consumer, final R value) {
        return t -> {
            consumer.accept(t, value);
            return t;
        };
    }

    public static <T> Function<T, T> ifTrue(final boolean condition, final Function<T, T> mapper) {
        return t -> condition ? mapper.apply(t) : t;
    }

}