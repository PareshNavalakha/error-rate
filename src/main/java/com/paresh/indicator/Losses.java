package com.paresh.indicator;


import java.math.BigDecimal;

public class Losses {

    public static BigDecimal[] of(BigDecimal[] values, int period) {
        BigDecimal[] results;
        results = new BigDecimal[values.length];
        results[0] = BigDecimal.ZERO;

        for (int index = 1; index < values.length; index++) {

            if (values[index].compareTo(values[index - 1]) < 0) {
                results[index] = values[index - 1].subtract(values[index]);
            } else {
                results[index] = BigDecimal.ZERO;
            }

        }

        return results;
    }

}
