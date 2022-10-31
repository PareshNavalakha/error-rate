package com.paresh.indicator;


import java.math.BigDecimal;

public class Profits {


    public static BigDecimal[] of(BigDecimal[] values, int period) {

        BigDecimal[] results = new BigDecimal[values.length];
        results[0] = BigDecimal.ZERO;

        for (int index = 1; index < values.length; index++) {

            if (values[index].compareTo(values[index - 1]) > 0) {
                results[index] = values[index].subtract(values[index - 1]);
            } else {
                results[index] = BigDecimal.ZERO;
            }

        }
        return results;
    }

}
