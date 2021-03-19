package com.utility.comparisonutility.utils;


import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;

/**
 * Created by vishal on 18/3/21.
 */
public class MathUtils {
    public static BigInteger evalFactorial(Integer n) {
        return BigIntegerMath.factorial(n.intValue());
    }
}
