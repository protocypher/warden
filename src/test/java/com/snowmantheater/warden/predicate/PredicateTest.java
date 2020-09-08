package com.snowmantheater.warden.predicate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PredicateTest {

    // *****************************************************************************************************************
    // *                                                                                                     TEST DATA *
    // *****************************************************************************************************************

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                    PRIMITIVES |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static boolean BOOL_TRUE  = true;
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

    protected final static Object OBJECT_NULL  = null;
    protected final static Object OBJECT_VALUE = new Object();

    protected final static String STRING_NULL  = null;
    protected final static String STRING_EMPTY = "";
    protected final static String STRING_ABC   = "ABC";
    protected final static String STRING_XYZ   = "XYZ";

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                   COLLECTIONS |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static List<Integer> LIST_NULL  = null;
    protected final static List<Integer> LIST_EMPTY = Collections.emptyList();
    protected final static List<Integer> LIST_VALUE = List.of(1, 2, 3);

    protected final static Map<String,String> MAP_NULL  = null;
    protected final static Map<String,String> MAP_EMPTY = Collections.emptyMap();
    protected final static Map<String,String> MAP_VALUE = Map.of("A", "a", "B", "b", "C", "c");

    protected final static Set<Character> SET_NULL = null;
    protected final static Set<Character> SET_EMPTY = Collections.emptySet();
    protected final static Set<Character> SET_VALUE = Set.of('A', 'B', 'C');

    // +---------------------------------------------------------------------------------------------------------------+
    // |                                                                                                        ARRAYS |
    // +---------------------------------------------------------------------------------------------------------------+

    protected final static Object[] ARRAY_OBJECT_NULL  = null;
    protected final static Object[] ARRAY_OBJECT_EMPTY = { };
    protected final static Object[] ARRAY_OBJECT_VALUE = {new Object(), new Object(), new Object()};

    protected final static boolean[] ARRAY_BOOL_NULL  = null;
    protected final static boolean[] ARRAY_BOOL_EMPTY = { };
    protected final static boolean[] ARRAY_BOOL_VALUE = {true, false, true};

    protected final static byte[] ARRAY_BYTE_NULL  = null;
    protected final static byte[] ARRAY_BYTE_EMPTY = { };
    protected final static byte[] ARRAY_BYTE_VALUE = {1, 2, 3};

    protected final static char[] ARRAY_CHAR_NULL  = null;
    protected final static char[] ARRAY_CHAR_EMPTY = { };
    protected final static char[] ARRAY_CHAR_VALUE = {'A', 'B', 'C'};

    protected final static double[] ARRAY_DOUBLE_NULL  = null;
    protected final static double[] ARRAY_DOUBLE_EMPTY = { };
    protected final static double[] ARRAY_DOUBLE_VALUE = {1.1D, 2.2D, 3.3D};

    protected final static float[] ARRAY_FLOAT_NULL  = null;
    protected final static float[] ARRAY_FLOAT_EMPTY = { };
    protected final static float[] ARRAY_FLOAT_VALUE = {1.1F, 2.2F, 3.3F};

    protected final static int[] ARRAY_INT_NULL  = null;
    protected final static int[] ARRAY_INT_EMPTY = { };
    protected final static int[] ARRAY_INT_VALUE = {1, 2, 3};

    protected final static long[] ARRAY_LONG_NULL  = null;
    protected final static long[] ARRAY_LONG_EMPTY = { };
    protected final static long[] ARRAY_LONG_VALUE = {1L, 2L, 3L};

    protected final static short[] ARRAY_SHORT_NULL  = null;
    protected final static short[] ARRAY_SHORT_EMPTY = { };
    protected final static short[] ARRAY_SHORT_VALUE = {(short)1, (short)2, (short)3};
}
