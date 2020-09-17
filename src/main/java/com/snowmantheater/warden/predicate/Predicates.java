package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

public class Predicates {
    /**
     * Returns a {@link Predicate} matching values that are <b>null</b>.
     *
     * @return A Predicate matching values that are null
     */
    public static Predicate<Object> Null() {
        return new NullPredicate();
    }

    /**
     * Returns a {@link Predicate} matching values that are <b>not null</b>.
     *
     * @return A Predicate matching values that are not null
     */
    public static Predicate<Object> NotNull() {
        return new NotNullPredicate();
    }

    /**
     * Returns a {@link Predicate} matching values <b>equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values equal to object
     */
    public static Predicate<Object> EqualTo(Object object) {
        return new EqualToPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values equal to object
     */
    public static Predicate<Object> eq(Object object) {
        return EqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>not equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values not equal to object
     */
    public static Predicate<Object> NotEqualTo(Object object) {
        return new NotEqualToPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>not equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values not equal to object
     */
    public static Predicate<Object> ne(Object object) {
        return NotEqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values that are <b>empty</b>.
     *
     * @return A new Predicate matching values that are empty
     */
    public static Predicate<Object> Empty() {
        return new EmptyPredicate();
    }

    /**
     * Creates a new {@link Predicate} matching values that are <b>not empty</b>.
     *
     * @return A new Predicate matching values that are not empty
     */
    public static Predicate<Object> NotEmpty() {
        return new NotEmptyPredicate();
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than or equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values greater than or equal to object
     */
    public static Predicate<Object> GreaterThanOrEqualTo(Object object) {
        return new GreaterThanOrEqualToPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than or equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values greater than or equal to object
     */
    public static Predicate<Object> ge(Object object) {
        return GreaterThanOrEqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>after or at</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values after or at object
     */
    public static Predicate<Object> AfterOrAt(Object object) {
        return GreaterThanOrEqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values greater than object
     */
    public static Predicate<Object> GreaterThan(Object object) {
        return new GreaterThanPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values greater than object
     */
    public static Predicate<Object> gt(Object object) {
        return GreaterThan(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>after</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values after object
     */
    public static Predicate<Object> After(Object object) {
        return GreaterThan(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>less than or equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values less than or equal to object
     */
    public static Predicate<Object> LessThanOrEqualTo(Object object) {
        return new LessThanOrEqualToPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>less than or equal to</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values less than or equal to object
     */
    public static Predicate<Object> le(Object object) {
        return LessThanOrEqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>before or at</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values before or at object
     */
    public static Predicate<Object> BeforeOrAt(Object object) {
        return LessThanOrEqualTo(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>less than</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values less than object
     */
    public static Predicate<Object> LessThan(Object object) {
        return new LessThanPredicate(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>less than</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values less than object
     */
    public static Predicate<Object> lt(Object object) {
        return LessThan(object);
    }

    /**
     * Returns a {@link Predicate} matching values <b>before</b> {@code object}.
     *
     * @param object The given instance to test against
     *
     * @return A Predicate matching values before object
     */
    public static Predicate<Object> Before(Object object) {
        return LessThan(object);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>not equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size not equal to size
     */
    public static Predicate<Object> SzNotEqualTo(int size) {
        return new SizeNotEqualToPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>not equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size not equal to size
     */
    public static Predicate<Object> zne(int size) {
        return SzNotEqualTo(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size equal to size
     */
    public static Predicate<Object> SzEqualTo(int size) {
        return new SizeEqualToPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size equal to size
     */
    public static Predicate<Object> zeq(int size) {
        return SzEqualTo(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than or equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size greater than or equal to size
     */
    public static Predicate<Object> SzGreaterThanOrEqualTo(int size) {
        return new SizeGreaterThanOrEqualToPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than or equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size greater than or equal to size
     */
    public static Predicate<Object> zge(int size) {
        return SzGreaterThanOrEqualTo(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than</b> {@code size}.
     *
     * @param size The size to test equality against
     *
     * @return A Predicate matching values with size greater than size
     */
    public static Predicate<Object> SzGreaterThan(int size) {
        return new SizeGreaterThanPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than</b> {@code size}.
     *
     * @param size The size to test equality against
     *
     * @return A Predicate matching values with size greater than size
     */
    public static Predicate<Object> zgt(int size) {
        return SzGreaterThan(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>less than or equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size less than or equal to size
     */
    public static Predicate<Object> SzLessThanOrEqualTo(int size) {
        return new SizeLessThanOrEqualToPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>less than or equal to</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size less than or equal to size
     */
    public static Predicate<Object> zle(int size) {
        return SzLessThanOrEqualTo(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>less than</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size less than size
     */
    public static Predicate<Object> SzLessThan(int size) {
        return new SizeLessThanPredicate(size);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>less than</b> {@code size}.
     *
     * @param size The size to test against
     *
     * @return A Predicate matching values with size less than size
     */
    public static Predicate<Object> zlt(int size) {
        return SzLessThan(size);
    }

    // *****************************************************************************************************************
    // *                                                                                        COMBINATION PREDICATES *
    // *****************************************************************************************************************

    /**
     * Returns a {@link Predicate} matching values <b>greater than</b> {@code min} and <b>less than</b> {@code max}.
     *
     * @param min The minimum exclusive bounding value
     * @param max The maximum exclusive bounding value
     *
     * @return A Predicate matching values greater than min and less than max
     */
    public static Predicate<Object> Between(Object min, Object max) {
        return GreaterThan(min).and(LessThan(max));
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than</b> {@code min} and <b>less than</b> {@code max}.
     *
     * @param min The minimum exclusive bounding value
     * @param max The maximum exclusive bounding value
     *
     * @return A Predicate matching values greater than min and less than max
     */
    public static Predicate<Object> btw(Object min, Object max) {
        return Between(min, max);
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than or equal to</b> {@code min} and <b>less than or equal
     * to</b> {@code max}.
     *
     * @param min The minimum inclusive bounding value
     * @param max The maximum inclusive bounding value
     *
     * @return A Predicate matching values greater than or equal to min and less than or equal to max
     */
    public static Predicate<Object> Within(Object min, Object max) {
        return GreaterThanOrEqualTo(min).and(LessThanOrEqualTo(max));
    }

    /**
     * Returns a {@link Predicate} matching values <b>greater than or equal to</b> {@code min} and <b>less than or equal
     * to</b> {@code max}.
     *
     * @param min The minimum inclusive bounding value
     * @param max The maximum inclusive bounding value
     *
     * @return A Predicate matching values greater than or equal to min and less than or equal to max
     */
    public static Predicate<Object> wtn(Object min, Object max) {
        return Within(min, max);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than</b> {@code min} and <b>less than</b>
     * {@code max}.
     *
     * @param min The minimum exclusive bounding size
     * @param max The maximum exclusive bounding size
     *
     * @return A Predicate matching values with size greater than min and less than max
     */
    public static Predicate<Object> SzBetween(int min, int max) {
        return SzGreaterThan(min).and(SzLessThan(max));
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than</b> {@code min} and <b>less than</b>
     * {@code max}.
     *
     * @param min The minimum exclusive bounding size
     * @param max The maximum exclusive bounding size
     *
     * @return A Predicate matching values with size greater than min and less than max
     */
    public static Predicate<Object> zbtw(int min, int max) {
        return SzBetween(min, max);
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than or equal to</b> {@code min} and <b>less
     * than or equal to</b> {@code max}.
     *
     * @param min The minimum inclusive bounding size
     * @param max The maximum inclusive bounding size
     *
     * @return A Predicate matching values with size greater than or equal to min and less than or equal to max
     */
    public static Predicate<Object> SzWithin(int min, int max) {
        return SzGreaterThanOrEqualTo(min).and(SzLessThanOrEqualTo(max));
    }

    /**
     * Returns a {@link Predicate} matching values with size <b>greater than or equal to</b> {@code min} and <b>less
     * than or equal to</b> {@code max}.
     *
     * @param min The minimum inclusive bounding size
     * @param max The maximum inclusive bounding size
     *
     * @return A Predicate matching values with size greater than or equal to min and less than or equal to max
     */
    public static Predicate<Object> zwtn(int min, int max) {
        return SzWithin(min, max);
    }

    /**
     * Returns a {@link Predicate} matching values which are <b>null or empty</b>. This is a common combination of
     * checks.
     *
     * @return A Predicate matching values which are null or empty
     */
    public static Predicate<Object> NullOrEmpty() {
        return Null().or(Empty());
    }
}
