package com.snowmantheater.warden.predicate;

import java.util.function.Predicate;

public class Predicates {
    private final static Predicate<Object> ASSERT_NULL = new NullPredicate();
    private final static Predicate<Object> ASSERT_NOT_NULL = new NotNullPredicate();
    private final static Predicate<Object> ASSERT_EMPTY = new AssertEmpty();
    private final static Predicate<Object> ASSERT_NOT_EMPTY = new AssertNotEmpty();

    private Predicates() { }

    public static Predicate<Object> Null() { return ASSERT_NULL; }
    public static Predicate<Object> NotNull() { return ASSERT_NOT_NULL; }

    public static Predicate<Object> EqualTo(Object object) { return new AssertEqualTo(object); }
    public static Predicate<Object> NotEqualTo(Object object) { return new AssertNotEqualTo(object); }

    public static Predicate<Object> GreaterThan(Object object) { return new AssertGreaterThan(object); }
    public static Predicate<Object> GreaterThanOrEqualTo(Object object) { return new AssertGreaterThanOrEqualTo(object); }

    public static Predicate<Object> LessThan(Object object) { return new AssertLessThan(object); }
    public static Predicate<Object> LessThanOrEqualTo(Object object) { return new AssertLessThanOrEqualTo(object); }

    public static Predicate<Object> eq(Object object) { return new AssertEqualTo(object); }
    public static Predicate<Object> neq(Object object) { return new AssertNotEqualTo(object); }

    public static Predicate<Object> gt(Object object) { return new AssertGreaterThan(object); }
    public static Predicate<Object> gte(Object object) { return new AssertGreaterThanOrEqualTo(object); }

    public static Predicate<Object> lt(Object object) { return new AssertLessThan(object); }
    public static Predicate<Object> lte(Object object) { return new AssertLessThanOrEqualTo(object); }

    public static Predicate<Object> After(Object object) { return gt(object); }
    public static Predicate<Object> Before(Object object) { return lt(object); }

    public static Predicate<Object> Between(Object min, Object max) { return gt(min).and(lt(max)); }
    public static Predicate<Object> Within(Object min, Object max) { return gte(min).and(lte(max)); }

    public static Predicate<Object> Empty() { return ASSERT_EMPTY; }
    public static Predicate<Object> NotEmpty() { return ASSERT_NOT_EMPTY; }

    public static Predicate<Object> SizeEqualTo(int size) { return new AssertSizeEqualTo(size); }
    public static Predicate<Object> SizeNotEqualTo(int size) { return new AssertSizeNotEqualTo(size); }

    public static Predicate<Object> SizeGreaterThan(int size) { return new AssertSizeGreaterThan(size); }
    public static Predicate<Object> SizeGreaterThanOrEqualTo(int size) { return new AssertSizeGreaterThanOrEqualTo(size); }

    public static Predicate<Object> SizeLessThan(int size) { return new AssertSizeLessThan(size); }
    public static Predicate<Object> SizeLessThanOrEqualTo(int size) { return new AssertSizeLessThanOrEqualTo(size); }

    public static Predicate<Object> sz_eq(int size) { return new AssertSizeEqualTo(size); }
    public static Predicate<Object> sz_neq(int size) { return new AssertSizeNotEqualTo(size); }

    public static Predicate<Object> sz_gt(int size) { return new AssertSizeGreaterThan(size); }
    public static Predicate<Object> sz_gte(int size) { return new AssertSizeGreaterThanOrEqualTo(size); }

    public static Predicate<Object> sz_lt(int size) { return new AssertSizeLessThan(size); }
    public static Predicate<Object> sz_lte(int size) { return new AssertSizeLessThanOrEqualTo(size); }

    public static Predicate<Object> SizeBetween(int min, int max) { return sz_gt(min).and(sz_lt(max)); }
    public static Predicate<Object> SizeWithin(int min, int max) { return sz_gte(min).and(sz_lte(max)); }
}
