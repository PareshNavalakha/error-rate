package com.paresh.indicator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExponentialMovingAverage {

    public static BigDecimal[] of(BigDecimal[] values, int period) {

        if (period >= values.length)
            throw new IllegalArgumentException("Given period is bigger then given set of values");

        BigDecimal[] results = new BigDecimal[values.length];
        BigDecimal smoothingConstant = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(period + 1), 2, RoundingMode.HALF_UP);

        for (int index = 0; index < (period - 1); index++) {
            results[index] = BigDecimal.ZERO;
        }

        BigDecimal[] simpleMovingAverage = SimpleMovingAverage.of(values, period);

        for (int index = (period - 1); index < values.length; index++) {
            if (index == (period - 1)) {
                results[index] = simpleMovingAverage[index];
            } else {
                // Formula: (Close - EMA(previous day)) x multiplier + EMA(previous day)
                results[index] = values[index].subtract(results[index - 1]).multiply(smoothingConstant).add(results[index - 1]);
            }
        }

        return results;

    }


}
