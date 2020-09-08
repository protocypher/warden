package com.snowmantheater.warden.predicate;

import java.util.*;

import static java.util.Collections.EMPTY_MAP;

public class ValidationData {
    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                        PRIMITIVES
    // -----------------------------------------------------------------------------------------------------------------

    public final static boolean BOOL_TRUE  = true;
    public final static boolean BOOL_FALSE = false;

    public final static byte BYTE_NEG3 = (byte)-3;
    public final static byte BYTE_ZERO = (byte)0;
    public final static byte BYTE_POS3 = (byte)3;

    public final static char CHAR_0 = (char)0;
    public final static char CHAR_A = 'A';
    public final static char CHAR_M = 'M';
    public final static char CHAR_Z = 'Z';

    public final static double DOUBLE_NEG3 = -3.3D;
    public final static double DOUBLE_ZERO = 0D;
    public final static double DOUBLE_POS3 = 3.3D;

    public final static float FLOAT_NEG3 = -3.3F;
    public final static float FLOAT_ZERO = 0F;
    public final static float FLOAT_POS3 = 3.3F;

    public final static int INT_NEG3 = -3;
    public final static int INT_ZERO = 0;
    public final static int INT_POS3 = 3;

    public final static long LONG_NEG3 = -3L;
    public final static long LONG_ZERO = 0L;
    public final static long LONG_POS3 = 3L;

    public final static short SHORT_NEG3 = (short)-3;
    public final static short SHORT_ZERO = (short)0;
    public final static short SHORT_POS3 = (short)3;

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                         INSTANCES
    // -----------------------------------------------------------------------------------------------------------------

    public final static Number NUMBER_NULL = null;
    public final static Number NUMBER_NEG3 = -3;
    public final static Number NUMBER_ZERO = 0;
    public final static Number NUMBER_POS3 = 3;

    public final static Object OBJECT_NULL  = null;
    public final static Object OBJECT_VALUE = new Object();

    public final static String STRING_NULL  = null;
    public final static String STRING_EMPTY = "";
    public final static String STRING_ABC   = "ABC";
    public final static String STRING_XYZ   = "XYZ";

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                       COLLECTIONS
    // -----------------------------------------------------------------------------------------------------------------

    public final static List<Integer> LIST_NULL  = null;
    public final static List<Integer> LIST_EMPTY = Collections.emptyList();
    public final static List<Integer> LIST_VALUE = List.of(1, 2, 3);

    public final static Map<String,String> MAP_NULL  = null;
    public final static Map<String,String> MAP_EMPTY = Collections.emptyMap();
    public final static Map<String,String> MAP_VALUE = Map.of("A", "a", "B", "b", "C", "c");

    public final static Set<Character> SET_NULL = null;
    public final static Set<Character> SET_EMPTY = Collections.emptySet();
    public final static Set<Character> SET_VALUE = Set.of('A', 'B', 'C');

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                            ARRAYS
    // -----------------------------------------------------------------------------------------------------------------

    public final static Object[] ARRAY_OBJECT_NULL  = null;
    public final static Object[] ARRAY_OBJECT_EMPTY = { };
    public final static Object[] ARRAY_OBJECT_VALUE = {new Object(), new Object(), new Object()};

    public final static boolean[] ARRAY_BOOL_NULL  = null;
    public final static boolean[] ARRAY_BOOL_EMPTY = { };
    public final static boolean[] ARRAY_BOOL_VALUE = {true, false, true};

    public final static byte[] ARRAY_BYTE_NULL  = null;
    public final static byte[] ARRAY_BYTE_EMPTY = { };
    public final static byte[] ARRAY_BYTE_VALUE = {1, 2, 3};

    public final static char[] ARRAY_CHAR_NULL  = null;
    public final static char[] ARRAY_CHAR_EMPTY = { };
    public final static char[] ARRAY_CHAR_VALUE = {'A', 'B', 'C'};

    public final static double[] ARRAY_DOUBLE_NULL  = null;
    public final static double[] ARRAY_DOUBLE_EMPTY = { };
    public final static double[] ARRAY_DOUBLE_VALUE = {1.1D, 2.2D, 3.3D};

    public final static float[] ARRAY_FLOAT_NULL  = null;
    public final static float[] ARRAY_FLOAT_EMPTY = { };
    public final static float[] ARRAY_FLOAT_VALUE = {1.1F, 2.2F, 3.3F};

    public final static int[] ARRAY_INT_NULL  = null;
    public final static int[] ARRAY_INT_EMPTY = { };
    public final static int[] ARRAY_INT_VALUE = {1, 2, 3};

    public final static long[] ARRAY_LONG_NULL  = null;
    public final static long[] ARRAY_LONG_EMPTY = { };
    public final static long[] ARRAY_LONG_VALUE = {1L, 2L, 3L};

    public final static short[] ARRAY_SHORT_NULL  = null;
    public final static short[] ARRAY_SHORT_EMPTY = { };
    public final static short[] ARRAY_SHORT_VALUE = {(short)1, (short)2, (short)3};
}
