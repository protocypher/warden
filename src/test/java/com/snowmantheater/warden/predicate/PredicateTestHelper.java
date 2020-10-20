package com.snowmantheater.warden.predicate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * {@link PredicateTestHelper} provides various data points and methods to assist {@code Predicate} tests.
 *
 * @author benjamin@snowmantheater.com
 * @version 1.0.0
 */
public class PredicateTestHelper {

    // *****************************************************************************************************************
    // *                                                                                                     TEST DATA *
    // *****************************************************************************************************************

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                    PRIMITIVES |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static boolean BOOL_TRUE = true;
    protected final static boolean BOOL_FALSE = false;

    protected final static byte BYTE_NEG3 = (byte)-3;
    protected final static byte BYTE_ZERO = (byte)0;
    protected final static byte BYTE_POS3 = (byte)3;

    protected final static char CHAR_0 = (char)0;
    protected final static char CHAR_A = 'A';
    protected final static char CHAR_M = 'M';
    protected final static char CHAR_Z = 'Z';

    protected final static double DOUBLE_NEG3 = -3.3D;
    protected final static double DOUBLE_ZERO = 0D;
    protected final static double DOUBLE_POS3 = 3.3D;

    protected final static float FLOAT_NEG3 = -3.3F;
    protected final static float FLOAT_ZERO = 0F;
    protected final static float FLOAT_POS3 = 3.3F;

    protected final static int INT_NEG3 = -3;
    protected final static int INT_ZERO = 0;
    protected final static int INT_POS3 = 3;

    protected final static long LONG_NEG3 = -3L;
    protected final static long LONG_ZERO = 0L;
    protected final static long LONG_POS3 = 3L;

    protected final static short SHORT_NEG3 = (short)-3;
    protected final static short SHORT_ZERO = (short)0;
    protected final static short SHORT_POS3 = (short)3;

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                     INSTANCES |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static Number NUMBER_NULL = null;
    protected final static Number NUMBER_NEG3 = -3;
    protected final static Number NUMBER_ZERO = 0;
    protected final static Number NUMBER_POS3 = 3;

    protected final static Object OBJECT_NULL = null;
    protected final static Object OBJECT_VALUE = new Object();

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                       STRINGS |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static String STRING_NULL = null;
    protected final static String STRING_EMPTY = "";
    protected final static String STRING_ABC = "ABC";
    protected final static String STRING_XYZ = "XYZ";

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                   COLLECTIONS |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static List<Integer> LIST_NULL = null;
    protected final static List<Integer> LIST_EMPTY = Collections.emptyList();
    protected final static List<Integer> LIST_VALUE = List.of(1, 2, 3);

    protected final static Map<String, String> MAP_NULL = null;
    protected final static Map<String, String> MAP_EMPTY = Collections.emptyMap();
    protected final static Map<String, String> MAP_VALUE = Map.of("A", "a", "B", "b", "C", "c");

    protected final static Set<Character> SET_NULL = null;
    protected final static Set<Character> SET_EMPTY = Collections.emptySet();
    protected final static Set<Character> SET_VALUE = Set.of('A', 'B', 'C');

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                        ARRAYS |
    // +---------------------------------------------------------------------------------------------------------------+

    public final static Object[] ARRAY_OBJECT_NULL = null;
    public final static Object[] ARRAY_OBJECT_EMPTY = {};
    public final static Object[] ARRAY_OBJECT_VALUE = {new Object(), new Object(), new Object()};

    public final static boolean[] ARRAY_BOOL_NULL = null;
    public final static boolean[] ARRAY_BOOL_EMPTY = {};
    public final static boolean[] ARRAY_BOOL_VALUE = {true, false, true};

    public final static byte[] ARRAY_BYTE_NULL = null;
    public final static byte[] ARRAY_BYTE_EMPTY = {};
    public final static byte[] ARRAY_BYTE_VALUE = {1, 2, 3};

    public final static char[] ARRAY_CHAR_NULL = null;
    public final static char[] ARRAY_CHAR_EMPTY = {};
    public final static char[] ARRAY_CHAR_VALUE = {'A', 'B', 'C'};

    public final static double[] ARRAY_DOUBLE_NULL = null;
    public final static double[] ARRAY_DOUBLE_EMPTY = {};
    public final static double[] ARRAY_DOUBLE_VALUE = {1.1D, 2.2D, 3.3D};

    public final static float[] ARRAY_FLOAT_NULL = null;
    public final static float[] ARRAY_FLOAT_EMPTY = {};
    public final static float[] ARRAY_FLOAT_VALUE = {1.1F, 2.2F, 3.3F};

    public final static int[] ARRAY_INT_NULL = null;
    public final static int[] ARRAY_INT_EMPTY = {};
    public final static int[] ARRAY_INT_VALUE = {1, 2, 3};

    public final static long[] ARRAY_LONG_NULL = null;
    public final static long[] ARRAY_LONG_EMPTY = {};
    public final static long[] ARRAY_LONG_VALUE = {1L, 2L, 3L};

    public final static short[] ARRAY_SHORT_NULL = null;
    public final static short[] ARRAY_SHORT_EMPTY = {};
    public final static short[] ARRAY_SHORT_VALUE = {(short)1, (short)2, (short)3};

    // *****************************************************************************************************************
    // *                                                                                                  TEST HELPERS *
    // *****************************************************************************************************************

    /** Used to verify all predicate results are {@code true} using {@code allMatch()} */
    public final static Predicate<Boolean> TRUE = result -> result;

    /** Used to verify all predicate results are {@code false} using {@code allMatch()} */
    public final static Predicate<Boolean> FALSE = result -> !result;

    /**
     * Returns a new {@link PredicateTestHelper.PredicateApplier} that can easily apply {@code predicate} to given
     * values.
     *
     * @param predicate The Predicate to apply
     *
     * @return A PredicateApplier for {@code predicate}.
     */
    public static PredicateApplier apply(Predicate<Object> predicate) {
        return new PredicateApplier(predicate);
    }

    /**
     * {@link PredicateTestHelper.PredicateApplier} applies a given {@link Predicate} to given values.
     */
    public static class PredicateApplier {
        private final Predicate<Object> predicate;

        /**
         * Create a new {@link PredicateTestHelper.PredicateApplier} for {@code predicate}.
         *
         * @param predicate The given Predicate to apply
         */
        public PredicateApplier(Predicate<Object> predicate) {
            this.predicate = predicate;
        }

        /**
         * Assists in passing a single array as a single element to the {@code to()} method.
         *
         * @param value The single value to pass
         *
         * @return The results of the application as a Stream
         */
        public Stream<Boolean> toOne(Object value) {
            return to(value);
        }

        /**
         * Apply {@code predicate} to {@code values} returning a {@link Stream<Boolean>} of the results.
         *
         * @param values The values to apply Predicate to
         *
         * @return The results of the application as a Stream
         */
        public Stream<Boolean> to(Object... values) {
            return Stream.of(values).map(predicate::test);
        }
    }
}

