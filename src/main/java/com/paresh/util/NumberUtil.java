package com.paresh.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public class NumberUtil {

    public static BigDecimal HUNDRED = new BigDecimal(100);

    private NumberUtil() {
    }

    public static double round(double value) {
        return NumberUtil.round(value, 2);
    }

    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static BigDecimal average(BigDecimal[] bigDecimals, RoundingMode roundingMode) {
        BigDecimal sum = Arrays.stream(bigDecimals).map(Objects::requireNonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(new BigDecimal(bigDecimals.length), roundingMode);
    }

    public static BigDecimal average(BigDecimal[] bigDecimals, RoundingMode roundingMode, int start, int length) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int index = start; index < (start + length); index++) {
            sum = sum.add(bigDecimals[index]);
        }
        return sum.divide(BigDecimal.valueOf(length), 2, roundingMode);
    }
}
