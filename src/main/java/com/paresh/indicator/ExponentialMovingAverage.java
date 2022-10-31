package com.paresh.indicator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExponentialMovingAverage {

    public static BigDecimal[] of(BigDecimal[] values, int period) {

        BigDecimal[] results = new BigDecimal[values.length];

        if (period >= values.length)
            throw new IllegalArgumentException("Given period is bigger then given set of values");

        BigDecimal smoothingConstant = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(period + 1), 2, RoundingMode.HALF_UP);

        BigDecimal[] periodSma = new BigDecimal[values.length];

        for (int index = 0; index < (period - 1); index++) {
            results[index] = BigDecimal.ZERO;
        }

        BigDecimal[] smaResults = SimpleMovingAverage.of(values, period - 1);

        for (int index = (period - 1); index < values.length; index++) {

            periodSma[index] = smaResults[index - 1];

            if (index == (period - 1)) {
                results[index] = periodSma[index];
            } else if (index > (period - 1)) {
                // Formula: (Close - EMA(previous day)) x multiplier +
                // EMA(previous day)
                results[index] = values[index].subtract(results[index - 1]).multiply(smoothingConstant).add(results[index - 1]);
            }
        }

        return results;

    }


}
